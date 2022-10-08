package com.rq.net.bean;

public class StationHelperRequestBean
{
    private String callee;
    private String mailNum;
    private String outType;
    private String packNum;
    private String userId;
    
    public StationHelperRequestBean(final String userId, final String mailNum) {
        this.callee = "";
        this.packNum = "";
        this.outType = "0";
        this.userId = userId;
        this.mailNum = mailNum;
    }
    
    public String getCallee() {
        return this.callee;
    }
    
    public String getMailNum() {
        return this.mailNum;
    }
    
    public String getOutType() {
        return this.outType;
    }
    
    public String getPackNum() {
        return this.packNum;
    }
    
    public String getUserId() {
        return this.userId;
    }
    
    public void setCallee(final String callee) {
        this.callee = callee;
    }
    
    public void setMailNum(final String mailNum) {
        this.mailNum = mailNum;
    }
    
    public void setOutType(final String outType) {
        this.outType = outType;
    }
    
    public void setPackNum(final String packNum) {
        this.packNum = packNum;
    }
    
    public void setUserId(final String userId) {
        this.userId = userId;
    }
}
