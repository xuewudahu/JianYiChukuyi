package com.rq.net.bean;

public class DeleteDeviceCloudBean
{
    private String sign;
    private String sn;
    private String timestamp;
    
    public String getSign() {
        return this.sign;
    }
    
    public String getSn() {
        return this.sn;
    }
    
    public String getTimestamp() {
        return this.timestamp;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setSn(final String sn) {
        this.sn = sn;
    }
    
    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }
}
