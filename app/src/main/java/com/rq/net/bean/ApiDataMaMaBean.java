package com.rq.net.bean;

public class ApiDataMaMaBean<T>
{
    private String code;
    private int costTime;
    private T data;
    private String message;
    
    public String getCode() {
        return this.code;
    }
    
    public int getCostTime() {
        return this.costTime;
    }
    
    public T getData() {
        return this.data;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setCode(final String code) {
        this.code = code;
    }
    
    public void setCostTime(final int costTime) {
        this.costTime = costTime;
    }
    
    public void setData(final T data) {
        this.data = data;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
}
