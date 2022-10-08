package com.rq.net.bean;

public class ApiDataBean<T>
{
    private int code;
    private T data;
    private String message;
    
    public int getCode() {
        return this.code;
    }
    
    public T getData() {
        return this.data;
    }
    
    public String getMsg() {
        return this.message;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setData(final T data) {
        this.data = data;
    }
    
    public void setMsg(final String message) {
        this.message = message;
    }
}
