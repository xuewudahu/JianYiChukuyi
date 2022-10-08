package com.rq.net.bean;

public class MaMaCheckInforBean
{
    private String data;
    private String deviceType;
    private String digest;
    private String orgCode;
    private String serialNo;
    private String stationCode;
    private String username;
    
    public String getData() {
        return this.data;
    }
    
    public String getDeviceType() {
        return this.deviceType;
    }
    
    public String getDigest() {
        return this.digest;
    }
    
    public String getOrgCode() {
        return this.orgCode;
    }
    
    public String getSerialNo() {
        return this.serialNo;
    }
    
    public String getStationCode() {
        return this.stationCode;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setData(final String data) {
        this.data = data;
    }
    
    public void setDeviceType(final String deviceType) {
        this.deviceType = deviceType;
    }
    
    public void setDigest(final String digest) {
        this.digest = digest;
    }
    
    public void setOrgCode(final String orgCode) {
        this.orgCode = orgCode;
    }
    
    public void setSerialNo(final String serialNo) {
        this.serialNo = serialNo;
    }
    
    public void setStationCode(final String stationCode) {
        this.stationCode = stationCode;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
}
