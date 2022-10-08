package com.rq.net.bean;

public class YunDaKDCSRequestBean
{
    public String action;
    public String appver;
    public String data;
    public String req_time;
    public String sign_method;
    public String token;
    public String version;
    
    public YunDaKDCSRequestBean() {
        this.sign_method = "yd_md5";
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(System.currentTimeMillis());
        this.req_time = sb.toString();
        this.appver = "1.6.2";
        this.version = "V2.0";
    }
    
    public String getAction() {
        return this.action;
    }
    
    public String getAppver() {
        return this.appver;
    }
    
    public String getData() {
        return this.data;
    }
    
    public String getReq_time() {
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
    
    public void setAppver(final String appver) {
        this.appver = appver;
    }
    
    public void setData(final String data) {
        this.data = data;
    }
    
    public void setReq_time(final String req_time) {
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
