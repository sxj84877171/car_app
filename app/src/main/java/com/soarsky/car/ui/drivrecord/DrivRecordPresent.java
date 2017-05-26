package com.soarsky.car.ui.drivrecord;

import com.soarsky.car.base.BasePresenter;
import com.soarsky.car.ui.license.pwd.LicensePwdParam;
import com.soarsky.car.ui.license.pwd.LicensePwdSendParam;

import rx.Subscriber;

/**
 * Andriod_Car_App
 * 作者： 苏云
 * 时间： 2016/12/9
 * 公司：长沙硕铠电子科技有限公司
 * Email：suyun@soarsky-e.com
 * 公司网址：http://www.soarsky-e.com
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼
 * 版本：1.0.0.0
 * 邮编：410000
 * 程序功能：
 * 该类为
 */

public class DrivRecordPresent extends BasePresenter<DrivRecordModel,DrivRecordView>{


    @Override
    public void onStart() {

    }

    /**
     * 设置查询密码
     * @param param
     */
    public void setQueryPwd(LicensePwdSendParam param){

        mView.showProgess();
        mModel.setQueryPwd(param).subscribe(new Subscriber<LicensePwdParam>() {
            @Override
            public void onCompleted() {

                mView.stopProgess();
            }

            @Override
            public void onError(Throwable e) {
                mView.stopProgess();
            }

            @Override
            public void onNext(LicensePwdParam licensePwdParam) {
                mView.stopProgess();
                mView.onSuccess(licensePwdParam);

            }
        });

    }

}
