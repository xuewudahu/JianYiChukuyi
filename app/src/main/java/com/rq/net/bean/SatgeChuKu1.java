package com.rq.net.bean;

public class SatgeChuKu1
{
    private int code;
    private DataBean data;
    private String message;
    
    public int getCode() {
        return this.code;
    }
    
    public DataBean getData() {
        return this.data;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setData(final DataBean data) {
        this.data = data;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public class DataBean
    {
        private String yid;
        
        public String getYid() {
            return this.yid;
        }
        
        public void setYid(final String yid) {
            this.yid = yid;
        }
    }
}
