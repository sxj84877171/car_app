package com.soarsky.car.server.wifi;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;

import com.soarsky.car.App;
import com.soarsky.car.base.Configure;
import com.soarsky.car.bean.Car;
import com.soarsky.car.server.design.IScan;
import com.soarsky.car.server.design.OnCarScanedListener;
import com.soarsky.car.uitl.LogUtil;
import com.soarsky.car.uitl.ValidatorUtils;
import com.soarsky.car.uitl.WifiUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Andriod_Car_App<br>
 * 作者：何明辉<br>
 * 时间： 2016/11/15.<br>
 * 公司：长沙硕铠电子科技有限公司<br>
 * Email：heminghui@soarsky-e.com<br>
 * 公司网址：http://www.soarsky-e.com<br>
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼<br>
 * 版本：1.0.0.0<br>
 * 邮编：410000<br>
 * 程序功能：扫描附近的热点<br>
 * 该类为 与终端通讯服务类<br>
 */

public class Scan extends HandlerThread implements IScan {
    private Context context;
    private WifiBroadcast wifiBroadcast;
    public static final String TAG = Scan.class.getSimpleName();
    private OnCarScanedListener carScanedListener;
    private Handler handler;
    private List<Car> autocarList;
    private List<Car> carList;
    private boolean isSacn;

    public Scan(Context context) {
        super(TAG, Thread.MIN_PRIORITY);
        this.context = context;
        init();
    }


    //懒汉式单例类.在第一次调用的时候实例化自己

    private static Scan single = null;

    //静态工厂方法
    public static Scan getInstance(Context context) {
        if (single == null) {
            single = new Scan(context);
        }
        return single;
    }

    /**
     * 初始化
     */
    private void init() {
        start();
        handler = new Handler(getLooper());
    }


    /**
     * 开启wifi
     */

    public void openWifi() {
        registerBoardCastReciver();
        if (!WifiUtil.getInstance().isWifiEnable()) {
            WifiUtil.getInstance().setWifiEnabled(true);
        }
    }


    /**
     * 打开扫描
     */

    @Override
    public void startScan() {
        registerBoardCastReciver();
        WifiUtil.getInstance().getWifiManager().startScan();
    }

    @Override
    public void setCarScanedListener(OnCarScanedListener carScanedListener) {
        this.carScanedListener = carScanedListener;

    }

    @Override
    public List<Car> getScanedCarList() {
        return carList;
    }


    public List<Car> getAutocarList() {
        return autocarList;
    }

    public List<Car> getCarList() {

        return carList;
    }


    /**
     * 获取扫描到的热点
     *
     * @param scanResults
     */
    public void getScanResult(final List<ScanResult> scanResults) {


        //todo  服务没有注册
        if (wifiBroadcast != null) {

            try {
                context.unregisterReceiver(wifiBroadcast);
            } catch (Exception e) {

                startScan();
            }

            wifiBroadcast = null;
        }
        filterScanResult(scanResults);


    }


    /**
     * 筛选到扫描的热点
     *
     * @param scanResults 自动得到2 3状态 2手动 得到 2  3  4状态
     *                    现在只验证了热点名称是不是车牌号 共13位  前4位日期5位连接次数第6位状态89位车型 最后7位车牌号
     */
    public void filterScanResult(List<ScanResult> scanResults) {


        //自动连接热点列表
        autocarList = new ArrayList<>();
        //手动连接热点列表
        carList = new ArrayList<>();
        if (scanResults != null) {
            for (ScanResult sr : scanResults) {
                //验证是否是有效热点
                if (ValidatorUtils.validatorSsid(sr.SSID)) {
//                    LogUtil.i("wifi扫描到车辆" + sr.SSID);
                    Car car = new Car(sr.SSID);
                    if (car.isReady()) {
                        autocarList.add(car);
                    }
                    if (car.isReadyGo()) {
                        if (App.getApp().getCarNum().equals(car.getCarNum())) {
                            App.getApp().setSsID(car.getSsid());
                        }

                        carList.add(car);
                    }
                }

            }
        }

        if (carScanedListener != null) {
            carScanedListener.newCarScannedList(carList);
        }


        /**
         * 15秒后重新开始扫描
         */
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                openWifi();
            }
        }, Configure.SACN_TIME);
    }


    /**
     * 注册广播
     */

    public void registerBoardCastReciver() {
        if (wifiBroadcast == null) {
            wifiBroadcast = new WifiBroadcast(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
            intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
            context.registerReceiver(wifiBroadcast, intentFilter);
        }

    }


    public boolean isSacn() {
        return isSacn;
    }


    /**
     * 停止handlerThread
     */
    public void onDestory() {

        if (wifiBroadcast != null) {
            try {
                context.unregisterReceiver(wifiBroadcast);
            } catch (Exception e) {
            }
        }
        single = null;
        if (getLooper() != null) {
            getLooper().quit();
        }
    }
}
