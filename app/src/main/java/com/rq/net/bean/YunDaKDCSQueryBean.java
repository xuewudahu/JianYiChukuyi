package com.rq.net.bean;

public class YunDaKDCSQueryBean
{
    private String action;
    private String appid;
    private String appver;
    private YunDaQueryBean data;
    private String option;
    private long req_time;
    private String sign_method;
    private String token;
    private String version;
    
    public YunDaKDCSQueryBean() {
        this.action = "appMarket.appMarket.ship.signShipCheck";
        this.appid = "88ibnoktffyc88r4";
        this.appver = "1.6.3.1";
        this.option = "false";
        this.req_time = System.currentTimeMillis();
        this.sign_method = "yd_md5";
        this.token = "";
        this.version = "V1.0";
    }
    
    public String getAction() {
        return this.action;
    }
    
    public String getAppid() {
        return this.appid;
    }
    
    public String getAppver() {
        return this.appver;
    }
    
    public YunDaQueryBean getData() {
        return this.data;
    }
    
    public String getOption() {
        return this.option;
    }
    
    public long getReq_time() {
        return this.req_time;
    }
    
    public String getSign_method() {
        return this.sign_method;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public void setAction(final String action) {
        this.action = action;
    }
    
    public void setAppid(final String appid) {
        this.appid = appid;
    }
    
    public void setAppver(final String appver) {
        this.appver = appver;
    }
    
    public void setData(final YunDaQueryBean data) {
        this.data = data;
    }
    
    public void setOption(final String option) {
        this.option = option;
    }
    
    public void setReq_time(final long req_time) {
        this.req_time = req_time;
    }
    
    public void setSign_method(final String sign_method) {
        this.sign_method = sign_method;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }
    
    public void setVersion(final String version) {
        this.version = version;
    }
}
