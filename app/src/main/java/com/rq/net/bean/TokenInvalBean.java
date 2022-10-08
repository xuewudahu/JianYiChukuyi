package com.rq.net.bean;

public class TokenInvalBean
{
    private int code;
    private String msg;
    
    public TokenInvalBean(final int code, final String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
}
