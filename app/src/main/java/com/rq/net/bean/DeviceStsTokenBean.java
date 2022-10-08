package com.rq.net.bean;

public class DeviceStsTokenBean
{
    private String sign;
    private String sn;
    private String timestamp;
    
    public String getSign() {
        return this.sign;
    }
    
    public String getSn() {
        return this.timestamp;
    }
    
    public String getTn() {
        return this.timestamp;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setSn(final String sn) {
        this.sn = sn;
    }
    
    public void setTn(final String timestamp) {
        this.timestamp = timestamp;
    }
}
