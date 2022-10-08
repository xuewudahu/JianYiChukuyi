package com.rq.net.bean;

public class FcboxDeviceTokenBean
{
    private String channel;
    private String deviceId;
    private String deviceType;
    private String ip;
    private String mac;
    private String os;
    private String platform;
    private String resolution;
    private String versionCode;
    private String versionName;
    
    public FcboxDeviceTokenBean() {
        this.channel = "xiaomi";
        this.deviceType = "Honor CHM-TL00H";
        this.os = "Android 7.1.2";
        this.platform = "Android";
        this.resolution = "720*1280";
    }
    
    public String getChannel() {
        return this.channel;
    }
    
    public String getDeviceId() {
        return this.deviceId;
    }
    
    public String getDeviceType() {
        return this.deviceType;
    }
    
    public String getIp() {
        return this.ip;
    }
    
    public String getMac() {
        return this.mac;
    }
    
    public String getOs() {
        return this.os;
    }
    
    public String getPlatform() {
        return this.platform;
    }
    
    public String getResolution() {
        return this.resolution;
    }
    
    public String getVersionCode() {
        return this.versionCode;
    }
    
    public String getVersionName() {
        return this.versionName;
    }
    
    public void setChannel(final String channel) {
        this.channel = channel;
    }
    
    public void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }
    
    public void setDeviceType(final String deviceType) {
        this.deviceType = deviceType;
    }
    
    public void setIp(final String ip) {
        this.ip = ip;
    }
    
    public void setMac(final String mac) {
        this.mac = mac;
    }
    
    public void setOs(final String os) {
        this.os = os;
    }
    
    public void setPlatform(final String platform) {
        this.platform = platform;
    }
    
    public void setResolution(final String resolution) {
        this.resolution = resolution;
    }
    
    public void setVersionCode(final String versionCode) {
        this.versionCode = versionCode;
    }
    
    public void setVersionName(final String versionName) {
        this.versionName = versionName;
    }
}
