package com.rq.net.bean;

public class MaMaCheckBarcodeInforBean
{
    private String destPhone;
    private String logisticsCode;
    private String opUserId;
    private boolean pliesMode;
    private boolean quick;
    private boolean rackMode;
    private String rackNo;
    private String stationCode;
    private String waybillNo;
    
    public String getDestPhone() {
        return this.destPhone;
    }
    
    public String getLogisticsCode() {
        return this.logisticsCode;
    }
    
    public String getOpUserId() {
        return this.opUserId;
    }
    
    public String getRackNo() {
        return this.rackNo;
    }
    
    public String getStationCode() {
        return this.stationCode;
    }
    
    public String getWaybillNo() {
        return this.waybillNo;
    }
    
    public boolean isPliesMode() {
        return this.pliesMode;
    }
    
    public boolean isQuick() {
        return this.quick;
    }
    
    public boolean isRackMode() {
        return this.rackMode;
    }
    
    public void setDestPhone(final String destPhone) {
        this.destPhone = destPhone;
    }
    
    public void setLogisticsCode(final String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }
    
    public void setOpUserId(final String opUserId) {
        this.opUserId = opUserId;
    }
    
    public void setPliesMode(final boolean pliesMode) {
        this.pliesMode = pliesMode;
    }
    
    public void setQuick(final boolean quick) {
        this.quick = quick;
    }
    
    public void setRackMode(final boolean rackMode) {
        this.rackMode = rackMode;
    }
    
    public void setRackNo(final String rackNo) {
        this.rackNo = rackNo;
    }
    
    public void setStationCode(final String stationCode) {
        this.stationCode = stationCode;
    }
    
    public void setWaybillNo(final String waybillNo) {
        this.waybillNo = waybillNo;
    }
}
