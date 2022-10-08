package com.rq.net.bean;

public class RequestJiTuOutlibrary
{
    private String deliveryMobile;
    private String listId;
    private String scanNetworkCity;
    private String scanNetworkContact;
    private String scanNetworkProvince;
    private String scanNetworkTypeId;
    private String scanNetworkTypeName;
    private String scanPda;
    private String scanTime;
    private String signCode;
    private String signId;
    private String signName;
    private String signer;
    private String waybillId;
    
    public RequestJiTuOutlibrary(final String deliveryMobile, final String listId, final String scanNetworkCity, final String scanNetworkContact, final String scanNetworkProvince, final String scanNetworkTypeId, final String scanNetworkTypeName, final String scanPda, final String scanTime, final String signCode, final String signId, final String signName, final String signer, final String waybillId) {
        this.deliveryMobile = deliveryMobile;
        this.listId = listId;
        this.scanNetworkCity = scanNetworkCity;
        this.scanNetworkContact = scanNetworkContact;
        this.scanNetworkProvince = scanNetworkProvince;
        this.scanNetworkTypeId = scanNetworkTypeId;
        this.scanNetworkTypeName = scanNetworkTypeName;
        this.scanPda = scanPda;
        this.scanTime = scanTime;
        this.signCode = signCode;
        this.signId = signId;
        this.signName = signName;
        this.signer = signer;
        this.waybillId = waybillId;
    }
    
    public String getDeliveryMobile() {
        return this.deliveryMobile;
    }
    
    public String getListId() {
        return this.listId;
    }
    
    public String getScanNetworkCity() {
        return this.scanNetworkCity;
    }
    
    public String getScanNetworkContact() {
        return this.scanNetworkContact;
    }
    
    public String getScanNetworkProvince() {
        return this.scanNetworkProvince;
    }
    
    public String getScanNetworkTypeId() {
        return this.scanNetworkTypeId;
    }
    
    public String getScanNetworkTypeName() {
        return this.scanNetworkTypeName;
    }
    
    public String getScanPda() {
        return this.scanPda;
    }
    
    public String getScanTime() {
        return this.scanTime;
    }
    
    public String getSignCode() {
        return this.signCode;
    }
    
    public String getSignId() {
        return this.signId;
    }
    
    public String getSignName() {
        return this.signName;
    }
    
    public String getSigner() {
        return this.signer;
    }
    
    public String getWaybillId() {
        return this.waybillId;
    }
    
    public void setDeliveryMobile(final String deliveryMobile) {
        this.deliveryMobile = deliveryMobile;
    }
    
    public void setListId(final String listId) {
        this.listId = listId;
    }
    
    public void setScanNetworkCity(final String scanNetworkCity) {
        this.scanNetworkCity = scanNetworkCity;
    }
    
    public void setScanNetworkContact(final String scanNetworkContact) {
        this.scanNetworkContact = scanNetworkContact;
    }
    
    public void setScanNetworkProvince(final String scanNetworkProvince) {
        this.scanNetworkProvince = scanNetworkProvince;
    }
    
    public void setScanNetworkTypeId(final String scanNetworkTypeId) {
        this.scanNetworkTypeId = scanNetworkTypeId;
    }
    
    public void setScanNetworkTypeName(final String scanNetworkTypeName) {
        this.scanNetworkTypeName = scanNetworkTypeName;
    }
    
    public void setScanPda(final String scanPda) {
        this.scanPda = scanPda;
    }
    
    public void setScanTime(final String scanTime) {
        this.scanTime = scanTime;
    }
    
    public void setSignCode(final String signCode) {
        this.signCode = signCode;
    }
    
    public void setSignId(final String signId) {
        this.signId = signId;
    }
    
    public void setSignName(final String signName) {
        this.signName = signName;
    }
    
    public void setSigner(final String signer) {
        this.signer = signer;
    }
    
    public void setWaybillId(final String waybillId) {
        this.waybillId = waybillId;
    }
}
