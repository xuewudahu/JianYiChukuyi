package com.rq.net.bean;

public class KDCSCheckOutLibraryBillCodeInforBean
{
    private String billCode;
    private String companyCode;
    private String depotCode;
    
    public String getBillCode() {
        return this.billCode;
    }
    
    public String getCompanyCode() {
        return this.companyCode;
    }
    
    public String getDepotCode() {
        return this.depotCode;
    }
    
    public void setBillCode(final String billCode) {
        this.billCode = billCode;
    }
    
    public void setCompanyCode(final String companyCode) {
        this.companyCode = companyCode;
    }
    
    public void setDepotCode(final String depotCode) {
        this.depotCode = depotCode;
    }
}
