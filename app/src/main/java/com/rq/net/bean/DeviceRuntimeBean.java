package com.rq.net.bean;

public class DeviceRuntimeBean
{
    private String count_date;
    private long current_space;
    private int duration;
    private long native_space;
    private String serial_number;
    private String sign;
    private String timestamp;
    
    public String getCount_date() {
        return this.count_date;
    }
    
    public long getCurrent_space() {
        return this.current_space;
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    public long getNative_space() {
        return this.native_space;
    }
    
    public String getSerial_number() {
        return this.serial_number;
    }
    
    public String getSign() {
        return this.sign;
    }
    
    public String getTimestamp() {
        return this.timestamp;
    }
    
    public void setCount_date(final String count_date) {
        this.count_date = count_date;
    }
    
    public void setCurrent_space(final long current_space) {
        this.current_space = current_space;
    }
    
    public void setDuration(final int duration) {
        this.duration = duration;
    }
    
    public void setNative_space(final long native_space) {
        this.native_space = native_space;
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
