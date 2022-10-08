package com.rq.net.bean;

public class ApiDataFcBoxBean<T>
{
    private String chnDesc;
    private int code;
    private T data;
    private String detail;
    private String engDesc;
    
    public String getChnDesc() {
        return this.chnDesc;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public T getData() {
        return this.data;
    }
    
    public String getDetail() {
        return this.detail;
    }
    
    public String getEngDesc() {
        return this.engDesc;
    }
    
    public void setChnDesc(final String chnDesc) {
        this.chnDesc = chnDesc;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setData(final T data) {
        this.data = data;
    }
    
    public void setDetail(final String detail) {
        this.detail = detail;
    }
    
    public void setEngDesc(final String engDesc) {
        this.engDesc = engDesc;
    }
}
