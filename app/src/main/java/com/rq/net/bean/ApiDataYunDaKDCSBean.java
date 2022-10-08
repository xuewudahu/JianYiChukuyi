package com.rq.net.bean;

public class ApiDataYunDaKDCSBean<T>
{
    private T body;
    private String errmsg;
    private Object errorcode;
    private long req_time;
    private boolean success;
    
    public T getBody() {
        return this.body;
    }
    
    public String getErrmsg() {
        return this.errmsg;
    }
    
    public Object getErrorcode() {
        return this.errorcode;
    }
    
    public long getReq_time() {
        return this.req_time;
    }
    
    public boolean isSuccess() {
        return this.success;
    }
    
    public void setBody(final T body) {
        this.body = body;
    }
    
    public void setErrmsg(final String errmsg) {
        this.errmsg = errmsg;
    }
    
    public void setErrorcode(final Object errorcode) {
        this.errorcode = errorcode;
    }
    
    public void setReq_time(final long req_time) {
        this.req_time = req_time;
    }
    
    public void setSuccess(final boolean success) {
        this.success = success;
    }
}
