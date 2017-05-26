package com.soarsky.car.ui.home.main;

import com.soarsky.car.server.wifi.WifiTransfer;

import java.net.Socket;

/**
 * Andriod_Car_App
 * 作者： 苏云
 * 时间： 2017/3/15
 * 公司：长沙硕铠电子科技有限公司
 * Email：suyun@soarsky-e.com
 * 公司网址：http://www.soarsky-e.com
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼
 * 版本：1.0.0.0
 * 邮编：410000
 * 程序功能：
 * 该类为 声音连接监听
 */


public interface OnVolumeListener {

    /**
     * 与终端连接成功
     */
    void onVolumeSuccess(WifiTransfer transfer,Socket socket);
    /**
     * 与终端连接失败
     */
    void onVolumeFailed();

}
