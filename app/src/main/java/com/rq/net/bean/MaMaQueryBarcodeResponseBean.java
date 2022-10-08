package com.rq.net.bean;

public class MaMaQueryBarcodeResponseBean
{
    private String destPhone;
    private String empCode;
    private String empName;
    private String id;
    private String logisticsCode;
    private String logisticsName;
    private String orgCode;
    private String stationCode;
    private String statusCode;
    private String statusName;
    private String waybillNo;
    
    public String getDestPhone() {
        return this.destPhone;
    }

    @Override
    public String toString() {
        return "MaMaQueryBarcodeResponseBean{" +
                "destPhone='" + destPhone + '\'' +
                ", empCode='" + empCode + '\'' +
                ", empName='" + empName + '\'' +
                ", id='" + id + '\'' +
                ", logisticsCode='" + logisticsCode + '\'' +
                ", logisticsName='" + logisticsName + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", stationCode='" + stationCode + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", statusName='" + statusName + '\'' +
                ", waybillNo='" + waybillNo + '\'' +
                '}';
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
    
    public String getLogisticsName() {
        return this.logisticsName;
    }
    
    public String getOrgCode() {
        return this.orgCode;
    }
    
    public String getStationCode() {
        return this.stationCode;
    }
    
    public String getStatusCode() {
        return this.statusCode;
    }
    
    public String getStatusName() {
        return this.statusName;
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
    
    public void setLogisticsName(final String logisticsName) {
        this.logisticsName = logisticsName;
    }
    
    public void setOrgCode(final String orgCode) {
        this.orgCode = orgCode;
    }
    
    public void setStationCode(final String stationCode) {
        this.stationCode = stationCode;
    }
    
    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }
    
    public void setStatusName(final String statusName) {
        this.statusName = statusName;
    }
    
    public void setWaybillNo(final String waybillNo) {
        this.waybillNo = waybillNo;
    }
}
