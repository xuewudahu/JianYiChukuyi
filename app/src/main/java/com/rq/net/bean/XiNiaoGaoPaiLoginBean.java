package com.rq.net.bean;

public class XiNiaoGaoPaiLoginBean
{
    private String deviceCode;
    private String key;
    private String unionCode;
    
    public String getDeviceCode() {
        return this.deviceCode;
    }
    
    public String getKey() {
        return this.key;
    }
    
    public String getUnionCode() {
        return this.unionCode;
    }
    
    public void setDeviceCode(final String deviceCode) {
        this.deviceCode = deviceCode;
    }
    
    public void setKey(final String key) {
        this.key = key;
    }
    
    public void setUnionCode(final String unionCode) {
        this.unionCode = unionCode;
    }
}
