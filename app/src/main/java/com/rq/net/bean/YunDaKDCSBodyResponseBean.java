package com.rq.net.bean;

public class YunDaKDCSBodyResponseBean
{
    private int code;
    private String message;
    private boolean result;
    
    public int getCode() {
        return this.code;
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
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public void setResult(final boolean result) {
        this.result = result;
    }
    
    public static class DataBean
    {
        private String company;
        
        public String getCompany() {
            return this.company;
        }
        
        public void setCompany(final String company) {
            this.company = company;
        }
    }
}
