package com.soarsky.car.ui.license.pwd;

import com.soarsky.car.base.BaseModel;
import com.soarsky.car.bean.LicensePwdBean;
import com.soarsky.car.bean.LicensePwdSendParam;
import com.soarsky.car.bean.ResponseDataBean;
import com.soarsky.car.helper.RxSchedulers;

import rx.Observable;

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
 * 程序功能：设置查询密码model<br>
 * 该类为 LicensePwdModel<br>
 */

public class LicensePwdModel implements BaseModel{

    public Observable<ResponseDataBean<LicensePwdBean>> setQueryPwd(LicensePwdSendParam param){

        return api.setQueryPwd(param.getUsername(),param.getQueryPwd()).compose(RxSchedulers.<ResponseDataBean<LicensePwdBean>>io_main());
    }
}
