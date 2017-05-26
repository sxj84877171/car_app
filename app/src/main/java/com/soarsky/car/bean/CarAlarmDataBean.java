package com.soarsky.car.bean;

/**
 * Andriod_Car_App<br>
 * 作者： 王松清<br>
 * 时间： 2017/1/21<br>
 * 公司：长沙硕铠电子科技有限公司<br>
 * Email：wangsongqing@soarsky-e.com<br>
 * 公司网址：http://www.soarsky-e.com<br>
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼<br>
 * 版本：1.0.0.0<br>
 * 邮编：410000<br>
 * 程序功能：<br>
 * 该类为防盗报警<br>
 */

public class CarAlarmDataBean {
    /**
     * 地址
     */
    private String address;
    /**
     * id
     */
    private int id;
    /**
     * 驾驶员
     */
    private String drivers;
    /**
     * 车牌号
     */
    private String carnum;
    /**
     * 经度
     */
    private String lon;
    /**
     * 纬度
     */
    private String lat;
    /**
     * 上传时间
     */
    private String stimer;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrivers() {
        return drivers;
    }

    public void setDrivers(String drivers) {
        this.drivers = drivers;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getStimer() {
        return stimer;
    }

    public void setStimer(String stimer) {
        this.stimer = stimer;
    }

}
