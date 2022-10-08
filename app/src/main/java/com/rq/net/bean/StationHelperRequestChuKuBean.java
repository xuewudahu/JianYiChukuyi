package com.rq.net.bean;

public class StationHelperRequestChuKuBean
{
    private String expressId;
    private String imgFlag;
    private String outSource;
    private String outType;
    private String outWay;
    private String userId;
    
    public StationHelperRequestChuKuBean(final String userId, final String expressId) {
        this.outType = "0";
        this.imgFlag = "0";
        this.outWay = "0";
        this.outSource = "5";
        this.userId = userId;
        this.expressId = expressId;
    }
    
    public String getExpressId() {
        return this.expressId;
    }
    
    public String getImgFlag() {
        return this.imgFlag;
    }
    
    public String getOutSource() {
        return this.outSource;
    }
    
    public String getOutType() {
        return this.outType;
    }
    
    public String getOutWay() {
        return this.outWay;
    }
    
    public String getUserId() {
        return this.userId;
    }
    
    public void setExpressId(final String expressId) {
        this.expressId = expressId;
    }
    
    public void setImgFlag(final String imgFlag) {
        this.imgFlag = imgFlag;
    }
    
    public void setOutSource(final String outSource) {
        this.outSource = outSource;
    }
    
    public void setOutType(final String outType) {
        this.outType = outType;
    }
    
    public void setOutWay(final String outWay) {
        this.outWay = outWay;
    }
    
    public void setUserId(final String userId) {
        this.userId = userId;
    }
}
