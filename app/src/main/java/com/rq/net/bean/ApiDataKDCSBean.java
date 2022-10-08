package com.rq.net.bean;

public class ApiDataKDCSBean<T>
{
    private String message;
    private T result;
    private boolean status;
    private String statusCode;
    
    public String getMessage() {
        return this.message;
    }
    
    public T getResult() {
        return this.result;
    }
    
    public String getStatusCode() {
        return this.statusCode;
    }
    
    public boolean isStatus() {
        return this.status;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public void setResult(final T result) {
        this.result = result;
    }
    
    public void setStatus(final boolean status) {
        this.status = status;
    }
    
    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }
}
