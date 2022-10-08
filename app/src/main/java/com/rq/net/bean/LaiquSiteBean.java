package com.rq.net.bean;

public class LaiquSiteBean
{
    private String serviceProvideCode;
    private String serviceSiteCode;
    
    public LaiquSiteBean(final String serviceProvideCode, final String serviceSiteCode) {
        this.serviceProvideCode = serviceProvideCode;
        this.serviceSiteCode = serviceSiteCode;
    }
    
    public String getServiceProvideCode() {
        return this.serviceProvideCode;
    }
    
    public String getServiceSiteCode() {
        return this.serviceSiteCode;
    }
    
    public void setServiceProvideCode(final String serviceProvideCode) {
        this.serviceProvideCode = serviceProvideCode;
    }
    
    public void setServiceSiteCode(final String serviceSiteCode) {
        this.serviceSiteCode = serviceSiteCode;
    }
}
