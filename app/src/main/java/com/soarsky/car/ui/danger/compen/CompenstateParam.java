package com.soarsky.car.ui.danger.compen;

/**
 * Andriod_Car_App
 * 作者： 苏云
 * 时间： 2016/12/22
 * 公司：长沙硕铠电子科技有限公司
 * Email：suyun@soarsky-e.com
 * 公司网址：http://www.soarsky-e.com
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼
 * 版本：1.0.0.0
 * 邮编：410000
 * 程序功能：快赔返回信息
 * 该类为
 */


public class CompenstateParam {

    /**
     * 实体信息
     */
    private DataBean data;
    /**
     * 状态
     */
    private String status;
    /**
     * 后台返回信息
     */
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * 位置
         */
        private String position;
        /**
         *路径
         */
        private String url;
        private String sourceFile;
        private String firstCar;
        private String secondCar;
        private String occurredTime;
        private String finalAffirm;
        private String firstLicense;
        private String firstPhone;
        private String accidentNumber;
        private String ptype;
        private String createTime;
        private String fstatus;
        private String sstatus;
        private String firstReason;
        private String secondReason;
        private String firstAffirm;
        private String secondPhone;
        private String secondLicense;
        private String secondAffirm;
        private String handleResult;
        private String handleTime;
        private String status;
        private int id;
        private String handler;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSourceFile() {
            return sourceFile;
        }

        public void setSourceFile(String sourceFile) {
            this.sourceFile = sourceFile;
        }

        public void setFinalAffirm(String finalAffirm) {
            this.finalAffirm = finalAffirm;
        }

        public void setFirstPhone(String firstPhone) {
            this.firstPhone = firstPhone;
        }

        public void setPtype(String ptype) {
            this.ptype = ptype;
        }

        public void setSecondPhone(String secondPhone) {
            this.secondPhone = secondPhone;
        }

        public void setHandleTime(String handleTime) {
            this.handleTime = handleTime;
        }

        public String getFirstCar() {
            return firstCar;
        }

        public void setFirstCar(String firstCar) {
            this.firstCar = firstCar;
        }

        public String getSecondCar() {
            return secondCar;
        }

        public void setSecondCar(String secondCar) {
            this.secondCar = secondCar;
        }

        public String getOccurredTime() {
            return occurredTime;
        }

        public void setOccurredTime(String occurredTime) {
            this.occurredTime = occurredTime;
        }


        public String getFirstLicense() {
            return firstLicense;
        }

        public void setFirstLicense(String firstLicense) {
            this.firstLicense = firstLicense;
        }


        public String getAccidentNumber() {
            return accidentNumber;
        }

        public void setAccidentNumber(String accidentNumber) {
            this.accidentNumber = accidentNumber;
        }



        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getFstatus() {
            return fstatus;
        }

        public void setFstatus(String fstatus) {
            this.fstatus = fstatus;
        }

        public String getSstatus() {
            return sstatus;
        }

        public void setSstatus(String sstatus) {
            this.sstatus = sstatus;
        }

        public String getFirstReason() {
            return firstReason;
        }

        public void setFirstReason(String firstReason) {
            this.firstReason = firstReason;
        }

        public String getSecondReason() {
            return secondReason;
        }

        public void setSecondReason(String secondReason) {
            this.secondReason = secondReason;
        }

        public String getFirstAffirm() {
            return firstAffirm;
        }

        public void setFirstAffirm(String firstAffirm) {
            this.firstAffirm = firstAffirm;
        }


        public String getSecondLicense() {
            return secondLicense;
        }

        public void setSecondLicense(String secondLicense) {
            this.secondLicense = secondLicense;
        }

        public String getSecondAffirm() {
            return secondAffirm;
        }

        public void setSecondAffirm(String secondAffirm) {
            this.secondAffirm = secondAffirm;
        }

        public String getHandleResult() {
            return handleResult;
        }

        public void setHandleResult(String handleResult) {
            this.handleResult = handleResult;
        }


        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHandler() {
            return handler;
        }

        public void setHandler(String handler) {
            this.handler = handler;
        }

        public String getFinalAffirm() {
            return finalAffirm;
        }

        public String getFirstPhone() {
            return firstPhone;
        }

        public String getPtype() {
            return ptype;
        }

        public String getSecondPhone() {
            return secondPhone;
        }

        public String getHandleTime() {
            return handleTime;
        }
    }
}
