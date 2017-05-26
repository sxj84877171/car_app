package com.soarsky.policeclient.server.design;

/**
 * android_police_app<br>
 * 作者： 魏凯<br>
 * 时间： 2016/12/16<br>
 * 公司：长沙硕铠电子科技有限公司<br>
 * Email：weikai@soarsky-e.com<br>
 * 公司网址：http://www.soarsky-e.com<br>
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼<br>
 * 版本：1.0.0.0<br>
 * 邮编：410000<br>
 * 程序功能：<br>
 * 该类为稽查开启关闭<br>
 */

public interface ICheck {

    /**
     * 开启稽查
     */
    void startCheck(boolean changeName);

    /**
     * 关闭稽查
     */
    void stopCheck(boolean changeName);


    /**
     * 是否在稽查
     */
    boolean isChecking();


}
