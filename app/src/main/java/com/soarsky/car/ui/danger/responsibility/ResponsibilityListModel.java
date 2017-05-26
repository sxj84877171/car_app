package com.soarsky.car.ui.danger.responsibility;

import com.soarsky.car.base.BaseModel;
import com.soarsky.car.data.remote.server1.Api;
import com.soarsky.car.helper.RxSchedulers;

import rx.Observable;

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


public class ResponsibilityListModel implements BaseModel {

    /**
     * 获取快赔列表
     * @param carnum
     * @return
     */
    public Observable<ResponsibilityListParam> getFastList(String carnum){
        return Api.getInstance().service.getFastList(carnum).compose(RxSchedulers.<ResponsibilityListParam>io_main());
    }
}
