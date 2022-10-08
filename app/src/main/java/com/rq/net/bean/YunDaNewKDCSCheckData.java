package com.rq.net.bean;

public class YunDaNewKDCSCheckData
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
        private String company;
        private String shipId;
        
        public String getAgentId() {
            return this.agentId;
        }
        
        public String getCompany() {
            return this.company;
        }
        
        public String getShipId() {
            return this.shipId;
        }
        
        public void setAgentId(final String agentId) {
            this.agentId = agentId;
        }
        
        public void setCompany(final String company) {
            this.company = company;
        }
        
        public void setShipId(final String shipId) {
            this.shipId = shipId;
        }
    }
}
