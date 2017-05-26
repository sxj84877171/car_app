package com.soarsky.car.ui.danger.responsibilitydetails;

import com.soarsky.car.base.BasePresenter;

import rx.Subscriber;

/**
 * Andriod_Car_App
 * 作者： 何明辉
 * 时间： 2016/12/20
 * 公司：长沙硕铠电子科技有限公司
 * Email：heminghui@soarsky-e.com
 * 公司网址：http://www.soarsky-e.com
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼
 * 版本：1.0.0.0
 * 邮编：410000
 * 程序功能：
 * 该类为
 */


public class ResponsibilityDetailsPresent extends BasePresenter<ResponsibilityDetailsModel,ResponsibilityDetailsView> {
    @Override
    public void onStart() {

    }

    /**
     * 获取单条快赔详细信息
     * @param id
     * @return
     */
    public void getFastInfo(String id){
        mView.showProgess();

        mModel.getFastInfo(id).subscribe(new Subscriber<ResponsibilityDetailsParam>() {
            @Override
            public void onCompleted() {
                mView.stopProgess();
            }

            @Override
            public void onError(Throwable e) {

                mView.stopProgess();
                mView.getFastInfoFail();
            }

            @Override
            public void onNext(ResponsibilityDetailsParam responsibilityDetailsParam) {

                mView.stopProgess();
                mView.getFastInfoSuccess(responsibilityDetailsParam);
            }
        });
    }


}
