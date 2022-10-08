package com.rq.net.bean;

public class StageLoginRequestBean
{
    private int code;
    private DataBean data;
    private DataInfo info;
    private String message;
    
    public int getCode() {
        return this.code;
    }
    
    public DataBean getData() {
        return this.data;
    }
    
    public DataInfo getInfo() {
        return this.info;
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
    
    public void setInfo(final DataInfo info) {
        this.info = info;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public class DataBean
    {
        private int accountType;
        private Setting notice_setting;
        private String token;
        
        public int getAccountType() {
            return this.accountType;
        }
        
        public Setting getNotice_setting() {
            return this.notice_setting;
        }
        
        public String getToken() {
            return this.token;
        }
        
        public void setAccountType(final int accountType) {
            this.accountType = accountType;
        }
        
        public void setNotice_setting(final Setting notice_setting) {
            this.notice_setting = notice_setting;
        }
        
        public void setToken(final String token) {
            this.token = token;
        }
        
        public class Setting
        {
        }
    }
    
    public class DataInfo
    {
    }
}
