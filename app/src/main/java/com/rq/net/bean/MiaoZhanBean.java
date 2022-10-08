package com.rq.net.bean;

public class MiaoZhanBean
{
    private int errorCode;
    private String errorMsg;
    private Boolean success;
    
    public int getErrorCode() {
        return this.errorCode;
    }
    
    public String getErrorMsg() {
        return this.errorMsg;
    }
    
    public Boolean getSuccess() {
        return this.success;
    }
    
    public void setErrorCode(final int errorCode) {
        this.errorCode = errorCode;
    }
    
    public void setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    public void setSuccess(final Boolean success) {
        this.success = success;
    }
}
