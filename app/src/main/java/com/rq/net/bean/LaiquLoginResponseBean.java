package com.rq.net.bean;

public class LaiquLoginResponseBean
{
    private Object key;
    private Object serviceSites;
    private String token;
    private String userId;
    
    public Object getKey() {
        return this.key;
    }
    
    public Object getServiceSites() {
        return this.serviceSites;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public String getUserId() {
        return this.userId;
    }
    
    public void setKey(final Object key) {
        this.key = key;
    }
    
    public void setServiceSites(final Object serviceSites) {
        this.serviceSites = serviceSites;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }
    
    public void setUserId(final String userId) {
        this.userId = userId;
    }
    
    public static class ServiceSitesBean
    {
        private long bindTime;
        private int isAdmin;
        private Object isKdjlSiteUser;
        private Object isKdjlUser;
        private String lockedReason;
        private String serviceProvideCode;
        private String serviceSiteCode;
        private String serviceSiteName;
        private int sortNumber;
        private int state;
        
        public long getBindTime() {
            return this.bindTime;
        }
        
        public int getIsAdmin() {
            return this.isAdmin;
        }
        
        public Object getIsKdjlSiteUser() {
            return this.isKdjlSiteUser;
        }
        
        public Object getIsKdjlUser() {
            return this.isKdjlUser;
        }
        
        public String getLockedReason() {
            return this.lockedReason;
        }
        
        public String getServiceProvideCode() {
            return this.serviceProvideCode;
        }
        
        public String getServiceSiteCode() {
            return this.serviceSiteCode;
        }
        
        public String getServiceSiteName() {
            return this.serviceSiteName;
        }
        
        public int getSortNumber() {
            return this.sortNumber;
        }
        
        public int getState() {
            return this.state;
        }
        
        public void setBindTime(final long bindTime) {
            this.bindTime = bindTime;
        }
        
        public void setIsAdmin(final int isAdmin) {
            this.isAdmin = isAdmin;
        }
        
        public void setIsKdjlSiteUser(final Object isKdjlSiteUser) {
            this.isKdjlSiteUser = isKdjlSiteUser;
        }
        
        public void setIsKdjlUser(final Object isKdjlUser) {
            this.isKdjlUser = isKdjlUser;
        }
        
        public void setLockedReason(final String lockedReason) {
            this.lockedReason = lockedReason;
        }
        
        public void setServiceProvideCode(final String serviceProvideCode) {
            this.serviceProvideCode = serviceProvideCode;
        }
        
        public void setServiceSiteCode(final String serviceSiteCode) {
            this.serviceSiteCode = serviceSiteCode;
        }
        
        public void setServiceSiteName(final String serviceSiteName) {
            this.serviceSiteName = serviceSiteName;
        }
        
        public void setSortNumber(final int sortNumber) {
            this.sortNumber = sortNumber;
        }
        
        public void setState(final int state) {
            this.state = state;
        }
    }
}
