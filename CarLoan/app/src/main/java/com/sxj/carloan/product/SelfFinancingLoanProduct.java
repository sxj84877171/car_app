package com.sxj.carloan.product;

import com.sxj.carloan.bean.ServerBean;

/**
 * Created by admin on 2017/8/20.
 */

public class SelfFinancingLoanProduct implements IProductCalc {

    ServerBean.RowsBean rowsBean;

    public SelfFinancingLoanProduct(ServerBean.RowsBean rowsBean){
        this.rowsBean = rowsBean;
    }

    /**
     * 获取产品名称
     *
     * @return
     */
    @Override
    public String getProduceName() {
        return "自有资金贷款产品";
    }

    /**
     * 获取费率
     *
     * @return
     */
    @Override
    public double getFeiLv() {
        return 31.68;
    }

    private double baozhengjin = 0;
    /**
     * 获取保证金
     *
     * @return
     */
    @Override
    public double getBaoZhengJin() {
        return baozhengjin;
    }

    public void setBaozhengjin(double baozhengjin) {
        this.baozhengjin = baozhengjin;
    }

    /**
     * 获取月供
     *loan_amount_ywy*1.2376/36*10000
     * @return
     */
    @Override
    public double getYueGong() {
        double loan_amount_ywy = Double.parseDouble(rowsBean.getLoan_amount_ywy());
        return loan_amount_ywy*1.2376/36*10000;
    }

    /**
     * 获取调整项
     *
     * @return
     */
    @Override
    public double getTiaoZhengXiang() {
        return 0;
    }

    /**
     * 获取GPS费率
     *if( loan_amount_ywy<10) gps_fee=2980; else gps_fee=4980;
     * @return
     */
    @Override
    public double getGpsFei() {
        double loan_amount_ywy = Double.parseDouble(rowsBean.getLoan_amount_ywy());
        double gps_fee = 4980;
        if( loan_amount_ywy<10){
            gps_fee=2980;
        } else {
            gps_fee=4980;
        }

        return gps_fee;
    }

    /**
     * 获取抵押费
     *
     * @return
     */
    @Override
    public double getDiYaFei() {
        return 0;
    }

    /**
     * 获取家访费
     *
     * @return
     */
    @Override
    public double getJiaFangFei() {
        return 0;
    }

    /**
     * 合计
     *
     * @return
     */
    @Override
    public double getHeJi() {
        return 0;
    }

    /***
     * 获取客户履约后退款
     * fee_return_custom=deposit*1.2376
     * @return
     */
    @Override
    public double getKeFuLvYueHouTuiKuan() {
        return getBaoZhengJin() * 1.2376;
    }

    /**
     * 业务类型[case_type_id]
     *
     * @return
     */
    @Override
    public String getCase_type_id() {
        return null;
    }

    /**
     * 资金来源[funds_source_id]
     *
     * @return
     */
    @Override
    public String getFunds_source_id() {
        return null;
    }

    /**
     * 分期类别[installment_type_id]
     *
     * @return
     */
    @Override
    public String getInstallment_type_id() {
        return null;
    }

    /**
     * 贷款年限[credit_years]
     *
     * @return
     */
    @Override
    public String getCredit_years() {
        return null;
    }

    /**
     * 首付比例[loan_advance_percent]
     *
     * @return
     */
    @Override
    public String getLoan_advance_percent() {
        return null;
    }

    /**
     * 费率[fee_rate]
     */
    @Override
    public String getFee_rate() {
        return null;
    }

    /**
     * 首付费率[fee_rate_advance]
     */
    @Override
    public String getFe_rate_advance() {
        return null;
    }

    /**
     * 余额费率[fee_rate_balance]
     */
    @Override
    public String getFee_rate_balance() {
        return null;
    }

    /**
     * 公司贷款[loan_amount_ywy_corp]
     */
    @Override
    public String getLoan_amount_ywy_corp() {
        return null;
    }

    /**
     * 公司贷款公式
     */
    @Override
    public String getCompaionGongShi() {
        return null;
    }

    /**
     * 银行申报金额[loan_amount_high]
     */
    @Override
    public String getLoan_amount_high() {
        return null;
    }

    /**
     * 银行申报金额公式
     */
    @Override
    public String getBankJiSuanGongShi() {
        return null;
    }

    /**
     * 银行利息[interest_bank]
     */
    @Override
    public String getInterest_bank() {
        return null;
    }

    /**
     * 银行利息公式
     */
    @Override
    public String getBankLiXiGongShi() {
        return null;
    }

    /**
     * 前置利息[interest_company]
     */
    @Override
    public String getInterest_company() {
        return null;
    }

    /**
     * 前置利息公式
     */
    @Override
    public String getInterest_companytGongShi() {
        return null;
    }

    /**
     * 保证金[deposit]
     */
    @Override
    public String getDeposit() {
        return null;
    }

    /**
     * 保证金公式
     *
     * @return
     */
    @Override
    public String getDepositGongShi() {
        return null;
    }

    /**
     * 月供[前12月][payback_month_12]
     */
    @Override
    public String getPayback_month_12() {
        return null;
    }

    /**
     * 月供[前12月]公式
     *
     * @return
     */
    @Override
    public String getPayback_month_12GongShi() {
        return null;
    }

    /**
     * 月供[payback_month]
     */
    @Override
    public String getPayBackMonth() {
        return null;
    }

    /**
     *
     */
    @Override
    public String getPayBackMonthGongShi() {
        return null;
    }

    /**
     * 调整项[extras_fee]
     */
    @Override
    public String getExtrasFee() {
        return null;
    }

    /**
     * 调整项
     */
    @Override
    public String getExtrasFeeGongShi() {
        return null;
    }

    /**
     * 流程保证金及服务费[service_fee]
     */
    @Override
    public String getServiceFee() {
        return null;
    }

    /**
     * 流程保证金及服务费公式
     */
    @Override
    public String getServiceFeeGongShi() {
        return null;
    }

    /**
     * GPS费[gps_fee]
     */
    @Override
    public String getGpsFee() {
        return null;
    }

    /**
     * GPS费公式
     */
    @Override
    public String getGpsFeeGongShi() {
        return null;
    }

    /**
     * 抵押费[mortgage_fee]
     */
    @Override
    public String getMortgageFee() {
        return null;
    }

    /**
     * 抵押费公式
     */
    @Override
    public String getMortgageFeeGongShi() {
        return null;
    }

    /**
     * 家访费[home_visit_fee]
     */
    @Override
    public String getHomeVisitFee() {
        return null;
    }

    /**
     * 家访费公式
     */
    @Override
    public String getHomeVisitFeeGongShi() {
        return null;
    }

    /**
     * 保险费[baoxian_fee]
     */
    @Override
    public String getBaoXianFee() {
        return null;
    }

    @Override
    public String getBaoXianFeeGongShi() {
        return null;
    }

    /**
     * 评估费[evaluation_fee]
     */
    @Override
    public String getEvaluationFee() {
        return null;
    }

    /**
     * 评估费公式
     */
    @Override
    public String getEvaluationFeeGongShi() {
        return null;
    }

    /**
     * 前期收取费[earlier_fee]
     */
    @Override
    public String getEarlierFee() {
        return null;
    }

    /**
     * 前期收取费公式
     */
    @Override
    public String getEarlierFeeGongShi() {
        return null;
    }

    /**
     * 返经销商[fee_return_agency]
     */
    @Override
    public String getFeeReturnAgency() {
        return null;
    }

    /**
     *
     */
    @Override
    public String getFeeReturnAgencyGongShi() {
        return null;
    }

    /**
     * 合计[fee_total]
     */
    @Override
    public String getFeeTotal() {
        return null;
    }

    /**
     * 合计公式
     */
    @Override
    public String getFeeTotalGongShi() {
        return null;
    }

    /**
     * 客户履约后退款[fee_return_custom]
     */
    @Override
    public String getFeeReturnCustom() {
        return null;
    }

    /**
     * 客户履约后退款公式
     */
    @Override
    public String getFeeReturnCustomGongShi() {
        return null;
    }

    /**
     * 商业险[commercial_insurance]
     */
    @Override
    public String getCommercialInsturance() {
        return null;
    }

    /**
     * 商业险公式
     */
    @Override
    public String getCommercialInsturanceGongShi() {
        return null;
    }

    /**
     * 商业险返[commercial_insurance_return]
     */
    @Override
    public String getCommercialInsturanceReturn() {
        return null;
    }

    /**
     * 商业险返公式
     *
     * @return
     */
    @Override
    public String getCommercialInsturanceReturnGongShi() {
        return null;
    }

    /**
     * 付经销商合计[payment_for_agency]
     */
    @Override
    public String getPaymentForAgency() {
        return null;
    }

    /**
     * 付经销商合计公式
     */
    @Override
    public String getPaymentForAgencyGongShi() {
        return null;
    }
}
