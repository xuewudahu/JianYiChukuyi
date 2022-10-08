package com.rq.net.bean;

public class CameraCheckOutBean<T>
{
    private T d;
    private String e;
    private String m;
    private boolean success;
    
    public T getD() {
        return this.d;
    }
    
    public String getE() {
        return this.e;
    }
    
    public String getM() {
        return this.m;
    }
    
    public boolean isSuccess() {
        return this.success;
    }
    
    public void setD(final T d) {
        this.d = d;
    }
    
    public void setE(final String e) {
        this.e = e;
    }
    
    public void setM(final String m) {
        this.m = m;
    }
    
    public void setSuccess(final boolean success) {
        this.success = success;
    }
}
