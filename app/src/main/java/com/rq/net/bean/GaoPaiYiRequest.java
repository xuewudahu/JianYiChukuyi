package com.rq.net.bean;

public class GaoPaiYiRequest
{
    private String deviceCode;
    private String deviceNumber;
    private String manufacturer;
    private String photoSignLink;
    private String signature;
    private String timestamp;
    private String unionCode;
    private String version;
    private String waybillNo;
    
    public GaoPaiYiRequest() {
        this.manufacturer = "KI";
        this.photoSignLink = "";
        this.deviceNumber = "JoyFinder-RK03399";
        this.version = "2.0.0.1";
    }
    
    public String getDeviceCode() {
        return this.deviceCode;
    }
    
    public String getDeviceNumber() {
        return this.deviceNumber;
    }
    
    public String getManufacturer() {
        return this.manufacturer;
    }
    
    public String getPhotoSignLink() {
        return this.photoSignLink;
    }
    
    public String getSignature() {
        return this.signature;
    }
    
    public String getTimestamp() {
        return this.timestamp;
    }
    
    public String getUnionCode() {
        return this.unionCode;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public String getWaybillNo() {
        return this.waybillNo;
    }
    
    public void setDeviceCode(final String deviceCode) {
        this.deviceCode = deviceCode;
    }
    
    public void setDeviceNumber(final String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }
    
    public void setManufacturer(final String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public void setPhotoSignLink(final String photoSignLink) {
        this.photoSignLink = photoSignLink;
    }
    
    public void setSignature(final String signature) {
        this.signature = signature;
    }
    
    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }
    
    public void setUnionCode(final String unionCode) {
        this.unionCode = unionCode;
    }
    
    public void setVersion(final String version) {
        this.version = version;
    }
    
    public void setWaybillNo(final String waybillNo) {
        this.waybillNo = waybillNo;
    }
}
