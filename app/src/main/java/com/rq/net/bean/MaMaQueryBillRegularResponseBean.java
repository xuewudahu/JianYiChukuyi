package com.rq.net.bean;

public class MaMaQueryBillRegularResponseBean
{
    private String logisticsCode;
    private String waybillRegular;
    
    public String getLogisticsCode() {
        return this.logisticsCode;
    }
    
    public String getWaybillRegular() {
        return this.waybillRegular;
    }
    
    public void setLogisticsCode(final String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }
    
    public void setWaybillRegular(final String waybillRegular) {
        this.waybillRegular = waybillRegular;
    }
}
