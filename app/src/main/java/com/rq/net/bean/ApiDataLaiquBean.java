package com.rq.net.bean;

public class ApiDataLaiquBean<T>
{
    private String errorCode;
    private String errorMsg;
    private T result;
    private int status;
    
    public String getErrorCode() {
        return this.errorCode;
    }
    
    public String getErrorMsg() {
        return this.errorMsg;
    }
    
    public T getResult() {
        return this.result;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }
    
    public void setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    public void setResult(final T result) {
        this.result = result;
    }
    
    public void setStatus(final int status) {
        this.status = status;
    }
}
