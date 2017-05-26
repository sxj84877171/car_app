package com.soarsky.car.ui.home.fragment.personal;

import android.app.Activity;

import com.soarsky.car.base.BaseModel;
import com.soarsky.car.data.local.db.bean.FamilyNum;
import com.soarsky.car.data.remote.server1.Api;
import com.soarsky.car.helper.RxSchedulers;
import com.soarsky.car.ui.family.FamilyNumDb;

import rx.Observable;

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

public class PersonalModel implements BaseModel{

    public Activity context;


    private FamilyNumDb familyNumDb;

    public void setContext(Activity context){

        this.context = context;
        familyNumDb = new FamilyNumDb(context);
        familyNumDb.getFamilyNumDao();
        familyNumDb.getFamilyNumQuery();

    }

    /***
     * 获取亲情号码
     * @param param
     * @return
     */
    public Observable<QueryFamilyParam> queryFirendPhone(QueryFamilySendParam param){
        return Api.getInstance().service.queryFirendPhone(param.getUsername(),param.getCarnum(),param.getPhone()).compose(RxSchedulers.<QueryFamilyParam>io_main());
    }

    /***
     * 插入亲情号码数据
     * @param familyNum
     * @return
     */
    public Observable<FamilyNum> insertFamilyNum(FamilyNum familyNum){
        return familyNumDb.insertData(familyNum);
    }

    /***
     * 清空亲情号表的所有数据
     * @return
     */
    public Observable<Void> deleteAll(){
        return familyNumDb.deleteAll();
    }

}
