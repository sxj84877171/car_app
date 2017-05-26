package com.soarsky.car.ui.borrowandreturn.borrow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.soarsky.car.R;
import com.soarsky.car.base.BaseActivity;
import com.soarsky.car.bean.DetailsInfo;
import com.soarsky.car.bean.ResponseDataBean;
import com.soarsky.car.ui.borrowandreturn.recorddetails.RecordDetailsMedol;
import com.soarsky.car.ui.borrowandreturn.recorddetails.RecordDetailsPresent;
import com.soarsky.car.ui.borrowandreturn.recorddetails.RecordDetailsView;
import com.soarsky.car.uitl.ToastUtil;

/**
 * Andriod_Car_App<br>
 * 作者： 王松清<br>
 * 时间： 2016/12/8<br>
 * 公司：长沙硕铠电子科技有限公司<br>
 * Email：wangsongqing@soarsky-e.com<br>
 * 公司网址：http://www.soarsky-e.com<br>
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼<br>
 * 版本：1.0.0.0<br>
 * 邮编：410000<br>
 * 程序功能：<br>
 * 该类为   车主同意借车<br>
 */

public class AgreeBorrowActivity extends BaseActivity<RecordDetailsPresent,RecordDetailsMedol> implements RecordDetailsView ,View.OnClickListener {
    /**
     * 标题
     */
    private TextView topicTv;
    /**
     * 返回
     */
    private LinearLayout backLay;
    /**
     * 车辆类型
     */
    private TextView type;
    /**
     * 借用车牌
     */
    private TextView carNum;
    /**
     * 借车人姓名
     */
    private TextView borrower_name;
    /**
     * 借车人电话
     */
    private TextView phone;
    /**
     * 借车人驾照
     */
    private TextView licen_num;
    /**
     * 开始时间
     */
    private TextView tv_startTime;
    /**
     * 结束时间
     */
    private TextView tv_endTime;
    /**
     * 借车记录id
     */
    private Integer bId;

    /**
     * 页面要展示的布局
     * @return  int类型的id
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_agree_borrow;
    }

    /**
     * 初始化控件
     */
    @Override
    public void initView() {
        topicTv = (TextView) findViewById(R.id.topicTv);
        topicTv.setText(R.string.borrow_aplication);

        backLay = (LinearLayout) findViewById(R.id.backLay);
        backLay.setOnClickListener(this);

        type = (TextView) findViewById(R.id.carType);
        carNum = (TextView) findViewById(R.id.carNum);
        borrower_name = (TextView) findViewById(R.id.borrowerName);
        phone = (TextView) findViewById(R.id.borrower_phoneNum);
        licen_num = (TextView) findViewById(R.id.borrowerIdNum);
        tv_startTime = (TextView) findViewById(R.id.startTime);
        tv_endTime = (TextView) findViewById(R.id.endTime);

    }

    @Override
    protected String getHeaderTitle() {
        return null;
    }

    /**
     * 点击事件
     * @param view  点击的控件对象
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backLay :
                finish();
                break;
        }
    }

    /**
     * 车主同意借车成功后触发的方法
     * @param detailParm 详细信息
     */
    @Override
    public void showSuccess(ResponseDataBean<DetailsInfo> detailParm) {
        type.setText(detailParm.getData().getModel());
        carNum.setText(detailParm.getData().getCarnum());
        borrower_name.setText(detailParm.getData().getAppuser().getUserName());
        phone.setText(detailParm.getData().getAppuser().getPhone());
        licen_num.setText(detailParm.getData().getAppuser().getIdcard());
        tv_startTime.setText(detailParm.getData().getStime());
        tv_endTime.setText(detailParm.getData().getEtime());
    }

    /**
     * 车主同意借车失败后触发的方法
     * @param detailParm  详细信息
     */
    @Override
    public void showFail(ResponseDataBean<DetailsInfo> detailParm) {
        ToastUtil.show(AgreeBorrowActivity.this,detailParm.getMessage());
    }

    /**
     * 请求错误触发的方法
     * @param e 错误信息
     */
    @Override
    public void showError(Throwable e) {

    }

    /**
     * 启动当前类调用的方法
     * @param savedInstanceState 保存数据的对象
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        bId = bundle.getInt("bId");
        mPresenter.getDetails(bId);
    }
}
