package com.rq.net.bean;

public class MaMaOutLibraryBean
{
    private String destPhone;
    private String empCode;
    private String empName;
    private String id;
    private String logisticsCode;
    private String orgCode;
    private String picFlag;
    private String recieverPhone;
    private String recieverSignoff;
    private String resource;
    private String stationCode;
    private int storePhoneType;
    private String uploadType;
    private String username;
    private String waybillNo;
    
    public MaMaOutLibraryBean() {
        this.uploadType = "1745";
        this.picFlag = "0";
        this.resource = "YZ-AND";
        this.storePhoneType = 1;
    }
    
    public String getDestPhone() {
        return this.destPhone;
    }
    
    public String getEmpCode() {
        return this.empCode;
    }
    
    public String getEmpName() {
        return this.empName;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getLogisticsCode() {
        return this.logisticsCode;
    }
    
    public String getOrgCode() {
        return this.orgCode;
    }
    
    public String getRecieverPhone() {
        return this.recieverPhone;
    }
    
    public String getRecieverSignoff() {
        return this.recieverSignoff;
    }
    
    public String getStationCode() {
        return this.stationCode;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getWaybillNo() {
        return this.waybillNo;
    }
    
    public void setDestPhone(final String destPhone) {
        this.destPhone = destPhone;
    }
    
    public void setEmpCode(final String empCode) {
        this.empCode = empCode;
    }
    
    public void setEmpName(final String empName) {
        this.empName = empName;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public void setLogisticsCode(final String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }
    
    public void setOrgCode(final String orgCode) {
        this.orgCode = orgCode;
    }
    
    public void setRecieverPhone(final String recieverPhone) {
        this.recieverPhone = recieverPhone;
    }
    
    public void setRecieverSignoff(final String recieverSignoff) {
        this.recieverSignoff = recieverSignoff;
    }
    
    public void setStationCode(final String stationCode) {
        this.stationCode = stationCode;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public void setWaybillNo(final String waybillNo) {
        this.waybillNo = waybillNo;
    }
}
