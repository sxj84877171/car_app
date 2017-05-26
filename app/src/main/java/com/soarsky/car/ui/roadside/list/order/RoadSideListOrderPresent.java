package com.soarsky.car.ui.roadside.list.order;

import com.soarsky.car.base.BasePresenter;

import rx.Subscriber;

/**
 * Andriod_Car_App
 * 作者： 苏云
 * 时间： 2016/12/21
 * 公司：长沙硕铠电子科技有限公司
 * Email：suyun@soarsky-e.com
 * 公司网址：http://www.soarsky-e.com
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼
 * 版本：1.0.0.0
 * 邮编：410000
 * 程序功能：
 * 该类为
 */


public class RoadSideListOrderPresent extends BasePresenter<RoadSideListOrderModel,RoadSideListOrderView>{

    @Override
    public void onStart() {

    }

    /**
     * 获取故障救援详细信息
     * @param id
     */
    public void getRescueById(String id){
        mView.showProgess();
        mModel.getRescueById(id).subscribe(new Subscriber<RoadSideListOrderParam>() {
            @Override
            public void onCompleted() {

                mView.stopProgess();
            }

            @Override
            public void onError(Throwable e) {

                mView.stopProgess();
                mView.getRescueByIdFail();
            }

            @Override
            public void onNext(RoadSideListOrderParam roadSideListOrderParam) {

                mView.stopProgess();
                mView.getRescueByIdSuccess(roadSideListOrderParam);
            }
        });
    }


    public void delRescueById(String id){
        mView.showProgess();
        mModel.delRescueById(id).subscribe(new Subscriber<RoadSideListOrderDelRescueParam>() {
            @Override
            public void onCompleted() {

                mView.stopProgess();
            }

            @Override
            public void onError(Throwable e) {
                mView.stopProgess();
                mView.delRescueByIdFail();
            }

            @Override
            public void onNext(RoadSideListOrderDelRescueParam roadSideListOrderDelRescueParam) {

                mView.stopProgess();
                mView.delRescueByIdSuccess(roadSideListOrderDelRescueParam);
            }
        });
    }

    public void showOrderDelete(){
        mView.showOrderDelete();
    }

}
