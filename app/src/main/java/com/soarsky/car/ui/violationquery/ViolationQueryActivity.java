package com.soarsky.car.ui.violationquery;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.soarsky.car.App;
import com.soarsky.car.R;
import com.soarsky.car.base.BaseActivity;
import com.soarsky.car.bean.ViolationQueryInfo;
import com.soarsky.car.uitl.ToastUtil;

/**
 * Andriod_Car_App<br>
 * 作者： 苏云<br>
 * 时间： 2016/12/9<br>
 * 公司：长沙硕铠电子科技有限公司<br>
 * Email：suyun@soarsky-e.com<br>
 * 公司网址：http://www.soarsky-e.com<br>
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼<br>
 * 版本：1.0.0.0<br>
 * 邮编：410000<br>
 * 程序功能：违章查询<br>
 * 该类为 ViolationQueryActivity<br>
 */

public class ViolationQueryActivity extends BaseActivity<ViolationQueryPresent,ViolationQueryModel> implements ViolationQueryView,View.OnClickListener{
    /**
     * 标题
     */
    private TextView topicTv;
    /**
     * 返回
     */
    private LinearLayout backLay;
    /**
     * 违章查询列表
     */
    private ListView query_listView;
    /**
     * 其列表适配器
     */
    private ViolationQueryAdatpter adatpter;
    /**
     * 进度条
     */
    private ProgressDialog progressDialog;
    /**
     * 后台查询更新的时间
     */
    private TextView violationQueryTimeTv;
    /**
     * 总罚款
     */
    private TextView queryFineTv;
    /**
     * 总未处理的违章
     */
    private TextView queryNotTv;
    /**
     * 总记分
     */
    private TextView queryCentTv;
    /**
     * application
     */
    private App app;
    /**
     * 该类的key
     */
    public final static String TAG = "ViolationQueryActivity";

    @Override
    public int getLayoutId() {
        return R.layout.activity_violation_query;
    }

    @Override
    public void initView() {

        app = (App)getApplication();
        app.addActivity(TAG,this);

        topicTv = (TextView) findViewById(R.id.topicTv);
        topicTv.setText(app.getCommonParam().getCarNum()==null?"":app.getCommonParam().getCarNum());
        backLay = (LinearLayout) findViewById(R.id.backLay);
        backLay.setOnClickListener(this);
        query_listView = (ListView) findViewById(R.id.query_listView);
        violationQueryTimeTv = (TextView) findViewById(R.id.violationQueryTimeTv);

        queryFineTv = (TextView) findViewById(R.id.queryFineTv);

        queryNotTv = (TextView) findViewById(R.id.queryNotTv);
        queryCentTv = (TextView) findViewById(R.id.queryCentTv);


    }

    @Override
    protected void onResume() {
        super.onResume();
        requestViolationQuery();
    }

    /**
     * 请求违章
     */
    public void requestViolationQuery(){
        String carNum = App.getApp().getCommonParam().getCarNum() ;
        if(carNum != null && !"".equals(carNum.trim())) {
            ViolationSendParam p = new ViolationSendParam();
            p.setCarnum(App.getApp().getCommonParam().getCarNum());
            mPresenter.violationQuery(p);
        }else{
            ToastUtil.show(this,R.string.no_car);
            finish();
        }
    }

    @Override
    protected String getHeaderTitle() {
        return "";
    }

    @Override
    public void showProgess() {

        super.showProgess();
    }

    @Override
    public void stopProgess() {
        super.stopProgess();
    }

    /**
     * 获取违章成功
     * @param param 违章信息
     */
    @Override
    public void showSuccess(ViolationQueryInfo param) {

        if(param != null){

            adatpter = new ViolationQueryAdatpter(this,param.getIlist());
            query_listView.setAdapter(adatpter);

            violationQueryTimeTv.setText(""+param.getLastTime());
            queryFineTv.setText(""+param.getCountMoney());
            queryNotTv.setText(""+param.getDealCount());

            queryCentTv.setText(""+param.getCountCent());
        }
    }

    /**
     * 获取违章失败
     */
    @Override
    public void showError() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backLay:
                finish();
                break;
        }
    }


}
