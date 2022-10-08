package com.rq.net.bean;

public class NetManagerLoginBean
{
    private String appSecret;
    private String appkey;
    
    public NetManagerLoginBean(final String appkey, final String appSecret) {
        this.appkey = appkey;
        this.appSecret = appSecret;
    }
    
    public String getAppSecret() {
        return this.appSecret;
    }
    
    public String getAppkey() {
        return this.appkey;
    }
    
    public void setAppSecret(final String appSecret) {
        this.appSecret = appSecret;
    }
    
    public void setAppkey(final String appkey) {
        this.appkey = appkey;
    }
}
