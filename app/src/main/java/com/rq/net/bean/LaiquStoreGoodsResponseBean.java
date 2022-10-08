package com.rq.net.bean;

public class LaiquStoreGoodsResponseBean
{
    private String billCode;
    private String expressCompanyCode;
    private int resultCode;
    private String resultDesc;
    
    public String getBillCode() {
        return this.billCode;
    }
    
    public String getExpressCompanyCode() {
        return this.expressCompanyCode;
    }
    
    public int getResultCode() {
        return this.resultCode;
    }
    
    public String getResultDesc() {
        return this.resultDesc;
    }
    
    public void setBillCode(final String billCode) {
        this.billCode = billCode;
    }
    
    public void setExpressCompanyCode(final String expressCompanyCode) {
        this.expressCompanyCode = expressCompanyCode;
    }
    
    public void setResultCode(final int resultCode) {
        this.resultCode = resultCode;
    }
    
    public void setResultDesc(final String resultDesc) {
        this.resultDesc = resultDesc;
    }
}
