package com.rq.net.bean;

public class YunDaNewKDCSCheckResponseBean
{
    private int code;
    private DataBean data;
    private String message;
    private boolean result;
    
    public int getCode() {
        return this.code;
    }
    
    public DataBean getData() {
        return this.data;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public boolean isResult() {
        return this.result;
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
    
    public void setResult(final boolean result) {
        this.result = result;
    }
    
    public static class DataBean
    {
        private String company;
        private String recePhone;
        private String ydUserId;
        
        public String getCompany() {
            return this.company;
        }
        
        public String getRecePhone() {
            return this.recePhone;
        }
        
        public String getYdUserId() {
            return this.ydUserId;
        }
        
        public void setCompany(final String company) {
            this.company = company;
        }
        
        public void setRecePhone(final String recePhone) {
            this.recePhone = recePhone;
        }
        
        public void setYdUserId(final String ydUserId) {
            this.ydUserId = ydUserId;
        }
    }
}
