package com.rq.net.bean;

import java.util.*;

public class DeviceMixTypeBean
{
    private String sign;
    private String sn;
    private List<String> st;
    private String timestamp;
    
    public DeviceMixTypeBean() {
        this.st = new ArrayList<String>();
    }
    
    public String getSign() {
        return this.sign;
    }
    
    public String getSn() {
        return this.sn;
    }
    
    public List<String> getSt() {
        return this.st;
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
    
    public void setSt(final List<String> st) {
        this.st = st;
    }
    
    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }
}
