package com.rq.net.bean;

public class KDCSOutLibraryResponseBean
{
    private String billCode;
    private String code;
    private String message;
    private boolean status;
    
    public String getBillCode() {
        return this.billCode;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public boolean isStatus() {
        return this.status;
    }
    
    public void setBillCode(final String billCode) {
        this.billCode = billCode;
    }
    
    public void setCode(final String code) {
        this.code = code;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public void setStatus(final boolean status) {
        this.status = status;
    }
}
