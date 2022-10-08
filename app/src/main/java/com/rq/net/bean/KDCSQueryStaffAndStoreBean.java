package com.rq.net.bean;

public class KDCSQueryStaffAndStoreBean
{
    private String staffCode;
    
    public KDCSQueryStaffAndStoreBean(final String staffCode) {
        this.staffCode = staffCode;
    }
    
    public String getStaffCode() {
        return this.staffCode;
    }
    
    public void setStaffCode(final String staffCode) {
        this.staffCode = staffCode;
    }
}
