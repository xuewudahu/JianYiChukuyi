package com.rq.net.bean;

public class DataBean
{
    private String agentId;
    private String company;
    private String shipId;
    
    public DataBean() {
        this.agentId = "";
        this.company = "";
    }
    
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
