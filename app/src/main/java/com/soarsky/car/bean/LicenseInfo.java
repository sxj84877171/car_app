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
 * 该类为行驶证信息<br>
 */

public class LicenseInfo {
    private boolean checked;
    /**
     * 车牌号
     */
    private String plateno;
    /**
     * 车辆类型
     */
    private String vehicletype;
    /**
     *
     */
    private String usercharacter;
    /**
     * 车辆识别代码
     */
    private String vin;
    /**
     * 发动机编号
     */
    private String enginno;
    /**
     * 注册日期
     */
    private String registerdate;
    /**
     * 发证日期
     */
    private String issuedate;
    /**
     *品牌型号
     */
    private String model;
    /**
     * 电话
     */
    private String phone;
    /**
     * 照片地址
     */
    private String imageUrl;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 车身颜色
     */
    private String color;
    /**
     * 记录
     */
    private String jilu;
    /**
     * 文件
     */
    private String sourceFile;
    /**
     * 座位数
     */
    private String seatNum;
    /**
     * 集合
     */
    private Object ilist;
    /**
     * 状态
     */
    private String status;
    /**
     * 地址
     */
    private String address;
    /**
     * 所属人
     */
    private String name;
    /**
     * id
     */
    private int id;
    /**
     * 车辆身份标示0 亲情号 1 车主 2借车
     */
    private int sign;


    private String  authcode;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getPlateno() {
        return plateno;
    }

    public void setPlateno(String plateno) {
        this.plateno = plateno;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

    public String getUsercharacter() {
        return usercharacter;
    }

    public void setUsercharacter(String usercharacter) {
        this.usercharacter = usercharacter;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getEnginno() {
        return enginno;
    }

    public void setEnginno(String enginno) {
        this.enginno = enginno;
    }

    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getJilu() {
        return jilu;
    }

    public void setJilu(String jilu) {
        this.jilu = jilu;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public Object getIlist() {
        return ilist;
    }

    public void setIlist(Object ilist) {
        this.ilist = ilist;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }


    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }
}
