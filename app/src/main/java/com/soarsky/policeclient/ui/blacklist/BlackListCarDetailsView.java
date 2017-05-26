package com.soarsky.policeclient.ui.blacklist;

import com.soarsky.policeclient.base.BaseView;
import com.soarsky.policeclient.bean.AccidentDataBean;
import com.soarsky.policeclient.bean.CarDetailsDataBean;
import com.soarsky.policeclient.data.local.db.bean.BlackCar;

import java.util.List;

/**
 * andriod_police_app<br>
 * 作者： 何明辉<br>
 * 时间： 2016/11/3<br>
 * 公司：长沙硕铠电子科技有限公司<br>
 * Email：wangsongqing@soarsky-e.com<br>
 * 公司网址：http://www.soarsky-e.com<br>
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼<br>
 * 版本：1.0.0.0<br>
 * 邮编：410000<br>
 * 程序功能：<br>
 * 该类为  黑名单列表View<br>
 */

public interface BlackListCarDetailsView extends BaseView{


    /**
     * 从服务器获取数据错误的回调
     */
    void onError();

    /**
     * 没有数据的回调
     */
    void onFail(String s);

    void onSuccess();
    /**
     * 参考其他view类
     * @param detailsCarParam
     */
    public void showData(CarDetailsDataBean detailsCarParam);

}
