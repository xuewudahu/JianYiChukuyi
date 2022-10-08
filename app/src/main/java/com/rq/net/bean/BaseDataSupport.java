package com.rq.net.bean;

//import org.litepal.crud.*;

public class BaseDataSupport /*extends DataSupport*/
{
    private String backOne;
    private String backThree;
    private String backTwo;
    private String dateTime;
    private String deviceId;
    private String deviceType;
    private String imageBarcodePath;
    private String imageFacePath;
    private String imageName;
    private boolean isBatchScan;
    private int operationType;
    private int outCount;
    private int outState;
    private String remarks;
    public String sign;
    public String timestamp;
    private int uploadStatus;
    private String userId;
    
    public BaseDataSupport() {
        this.uploadStatus = 0;
        this.isBatchScan = false;
        this.backOne = "";
        this.backTwo = "";
        this.backThree = "";
        this.outState = 1;
        this.outCount = 0;
    }
    
    public String getBackOne() {
        return this.backOne;
    }
    
    public String getBackThree() {
        return this.backThree;
    }
    
    public String getBackTwo() {
        return this.backTwo;
    }
    
    public String getDateTime() {
        return this.dateTime;
    }
    
    public String getDeviceId() {
        return this.deviceId;
    }
    
    public String getDeviceType() {
        return this.deviceType;
    }
    
    public String getImageBarcodePath() {
        return this.imageBarcodePath;
    }
    
    public String getImageFacePath() {
        return this.imageFacePath;
    }
    
    public String getImageName() {
        return this.imageName;
    }
    
    public int getOperationType() {
        return this.operationType;
    }
    
    public int getOutCount() {
        return this.outCount;
    }
    
    public int getOutState() {
        return this.outState;
    }
    
    public String getRemarks() {
        return this.remarks;
    }
    
    public String getSign() {
        return this.sign;
    }
    
    public String getTimestamp() {
        return this.timestamp;
    }
    
    public int getUploadStatus() {
        return this.uploadStatus;
    }
    
    public String getUserId() {
        return this.userId;
    }
    
    public boolean isBatchScan() {
        return this.isBatchScan;
    }
    
    public void setBackOne(final String backOne) {
        this.backOne = backOne;
    }
    
    public void setBackThree(final String backThree) {
        this.backThree = backThree;
    }
    
    public void setBackTwo(final String backTwo) {
        this.backTwo = backTwo;
    }
    
    public void setBatchScan(final boolean isBatchScan) {
        this.isBatchScan = isBatchScan;
    }
    
    public void setDateTime(final String dateTime) {
        this.dateTime = dateTime;
    }
    
    public void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }
    
    public void setDeviceType(final String deviceType) {
        this.deviceType = deviceType;
    }
    
    public void setImageBarcodePath(final String imageBarcodePath) {
        this.imageBarcodePath = imageBarcodePath;
    }
    
    public void setImageFacePath(final String imageFacePath) {
        this.imageFacePath = imageFacePath;
    }
    
    public void setImageName(final String imageName) {
        this.imageName = imageName;
    }
    
    public void setOperationType(final int operationType) {
        this.operationType = operationType;
    }
    
    public void setOutCount(final int outCount) {
        this.outCount = outCount;
    }
    
    public void setOutState(final int outState) {
        this.outState = outState;
    }
    
    public void setRemarks(final String remarks) {
        this.remarks = remarks;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }
    
    public void setUploadStatus(final int uploadStatus) {
        this.uploadStatus = uploadStatus;
    }
    
    public void setUserId(final String userId) {
        this.userId = userId;
    }
}
