package com.rq.net.bean;

public class GaoPaiResponse
{
    private DataBean data;
    private String errorCode;
    private String errorMsg;
    private boolean success;
    
    public DataBean getData() {
        return this.data;
    }
    
    public String getErrorCode() {
        return this.errorCode;
    }
    
    public String getErrorMsg() {
        return this.errorMsg;
    }
    
    public boolean isSuccess() {
        return this.success;
    }
    
    public void setData(final DataBean data) {
        this.data = data;
    }
    
    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }
    
    public void setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    public void setSuccess(final boolean success) {
        this.success = success;
    }
    
    public class DataBean
    {
    }
}
