package com.rq.net.bean;

public class ApiDataYunDaChaoShiBean<T>
{
    private T body;
    private String code;
    private String message;
    private boolean result;
    
    public T getBody() {
        return this.body;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public boolean isResult() {
        return this.result;
    }
    
    public void setBody(final T body) {
        this.body = body;
    }
    
    public void setCode(final String code) {
        this.code = code;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public void setResult(final boolean result) {
        this.result = result;
    }
}
