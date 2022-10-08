package com.rq.net.bean;

public class JiTuOutLibResponse
{
    private int code;
    private DataBean data;
    private String msg;
    
    public int getCode() {
        return this.code;
    }
    
    public DataBean getData() {
        return this.data;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setData(final DataBean data) {
        this.data = data;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public class DataBean
    {
        private String duplicateList;
        private String errorList;
    }
}
