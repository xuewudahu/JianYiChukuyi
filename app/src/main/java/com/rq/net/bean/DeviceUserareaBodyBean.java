package com.rq.net.bean;

public class DeviceUserareaBodyBean
{
    private String serial_number;
    private String sign;
    private String timestamp;
    
    public String getSerial_number() {
        return this.serial_number;
    }
    
    public String getSign() {
        return this.sign;
    }
    
    public String getTimestamp() {
        return this.timestamp;
    }
    
    public void setSerial_number(final String serial_number) {
        this.serial_number = serial_number;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }
}
