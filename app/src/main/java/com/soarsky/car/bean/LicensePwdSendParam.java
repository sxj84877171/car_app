package com.soarsky.car.bean;

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

public class LicensePwdSendParam {
    /**
     * 车牌号
     */
    private String username;
    /**
     * 查询密码
     */
    private String queryPwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQueryPwd() {
        return queryPwd;
    }

    public void setQueryPwd(String queryPwd) {
        this.queryPwd = queryPwd;
    }
}
