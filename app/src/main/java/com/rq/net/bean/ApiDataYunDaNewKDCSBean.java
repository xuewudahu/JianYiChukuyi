package com.rq.net.bean;

public class ApiDataYunDaNewKDCSBean<T>
{
    private T body;
    private String errorcode;
    private String isCipher;
    private String msg;
    private String res_time;
    private boolean success;
    
    public T getBody() {
        return this.body;
    }
    
    public String getErrorcode() {
        return this.errorcode;
    }
    
    public String getIsCipher() {
        return this.isCipher;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public String getRes_time() {
        return this.res_time;
    }
    
    public boolean isSuccess() {
        return this.success;
    }
    
    public void setBody(final T body) {
        this.body = body;
    }
    
    public void setErrorcode(final String errorcode) {
        this.errorcode = errorcode;
    }
    
    public void setIsCipher(final String isCipher) {
        this.isCipher = isCipher;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public void setRes_time(final String res_time) {
        this.res_time = res_time;
    }
    
    public void setSuccess(final boolean success) {
        this.success = success;
    }
}
