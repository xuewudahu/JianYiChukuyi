package com.rq.net.bean;

public class DeviceLoginBodyBean
{
    private String mobile;
    private String password;
    private String serial_number;
    private String sign;
    private String smscode;
    private String timestamp;
    private int type;
    
    public String getMobile() {
        return this.mobile;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getSerial_number() {
        return this.serial_number;
    }
    
    public String getSign() {
        return this.sign;
    }
    
    public String getSmscode() {
        return this.smscode;
    }
    
    public String getTimestamp() {
        return this.timestamp;
    }
    
    public int getType() {
        return this.type;
    }
    
    public void setMobile(final String mobile) {
        this.mobile = mobile;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public void setSerial_number(final String serial_number) {
        this.serial_number = serial_number;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setSmscode(final String smscode) {
        this.smscode = smscode;
    }
    
    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }
    
    public void setType(final int type) {
        this.type = type;
    }
}
