package com.rq.net.bean;

public class YunDa1781KDCSNoPicketBean
{
    private String action;
    private String appid;
    private String appver;
    private DataBean data;
    private String option;
    private long req_time;
    private String sign_method;
    private String token;
    private String version;
    
    public String getAction() {
        return this.action;
    }
    
    public String getAppid() {
        return this.appid;
    }
    
    public String getAppver() {
        return this.appver;
    }
    
    public DataBean getData() {
        return this.data;
    }
    
    public String getOption() {
        return this.option;
    }
    
    public long getReq_time() {
        return this.req_time;
    }
    
    public String getSign_method() {
        return this.sign_method;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public void setAction(final String action) {
        this.action = action;
    }
    
    public void setAppid(final String appid) {
        this.appid = appid;
    }
    
    public void setAppver(final String appver) {
        this.appver = appver;
    }
    
    public void setData(final DataBean data) {
        this.data = data;
    }
    
    public void setOption(final String option) {
        this.option = option;
    }
    
    public void setReq_time(final long req_time) {
        this.req_time = req_time;
    }
    
    public void setSign_method(final String sign_method) {
        this.sign_method = sign_method;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }
    
    public void setVersion(final String version) {
        this.version = version;
    }
    
    public static class DataBean
    {
        private String agentId;
        private String recePhone;
        private String shipId;
        private String ydUserId;
        
        public String getAgentId() {
            return this.agentId;
        }
        
        public String getRecePhone() {
            return this.recePhone;
        }
        
        public String getShipId() {
            return this.shipId;
        }
        
        public String getYdUserId() {
            return this.ydUserId;
        }
        
        public void setAgentId(final String agentId) {
            this.agentId = agentId;
        }
        
        public void setRecePhone(final String recePhone) {
            this.recePhone = recePhone;
        }
        
        public void setShipId(final String shipId) {
            this.shipId = shipId;
        }
        
        public void setYdUserId(final String ydUserId) {
            this.ydUserId = ydUserId;
        }
    }
}
