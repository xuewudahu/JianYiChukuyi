package com.rq.net.bean;

public class LaiquSiteLoginResponseBean
{
    private int checked;
    private Object errorMsg;
    private int isAdmin;
    private int isFocus;
    private int isKdjlUser;
    private int lockedDays;
    private String lockedReason;
    private ServiceSiteInfoBean serviceSiteInfo;
    private int state;
    private Object statusCode;
    private boolean successed;
    
    public int getChecked() {
        return this.checked;
    }
    
    public Object getErrorMsg() {
        return this.errorMsg;
    }
    
    public int getIsAdmin() {
        return this.isAdmin;
    }
    
    public int getIsFocus() {
        return this.isFocus;
    }
    
    public int getIsKdjlUser() {
        return this.isKdjlUser;
    }
    
    public int getLockedDays() {
        return this.lockedDays;
    }
    
    public String getLockedReason() {
        return this.lockedReason;
    }
    
    public ServiceSiteInfoBean getServiceSiteInfo() {
        return this.serviceSiteInfo;
    }
    
    public int getState() {
        return this.state;
    }
    
    public Object getStatusCode() {
        return this.statusCode;
    }
    
    public boolean isSuccessed() {
        return this.successed;
    }
    
    public void setChecked(final int checked) {
        this.checked = checked;
    }
    
    public void setErrorMsg(final Object errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    public void setIsAdmin(final int isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public void setIsFocus(final int isFocus) {
        this.isFocus = isFocus;
    }
    
    public void setIsKdjlUser(final int isKdjlUser) {
        this.isKdjlUser = isKdjlUser;
    }
    
    public void setLockedDays(final int lockedDays) {
        this.lockedDays = lockedDays;
    }
    
    public void setLockedReason(final String lockedReason) {
        this.lockedReason = lockedReason;
    }
    
    public void setServiceSiteInfo(final ServiceSiteInfoBean serviceSiteInfo) {
        this.serviceSiteInfo = serviceSiteInfo;
    }
    
    public void setState(final int state) {
        this.state = state;
    }
    
    public void setStatusCode(final Object statusCode) {
        this.statusCode = statusCode;
    }
    
    public void setSuccessed(final boolean successed) {
        this.successed = successed;
    }
    
    public static class ServiceSiteInfoBean
    {
        private String address;
        private String city;
        private String county;
        private String phone;
        private String province;
        private String serviceProvideCode;
        private String serviceProvideName;
        private String serviceSiteCode;
        private String serviceSiteName;
        private Object toCheckServiceSiteAddress;
        private Object toCheckServiceSiteName;
        
        public String getAddress() {
            return this.address;
        }
        
        public String getCity() {
            return this.city;
        }
        
        public String getCounty() {
            return this.county;
        }
        
        public String getPhone() {
            return this.phone;
        }
        
        public String getProvince() {
            return this.province;
        }
        
        public String getServiceProvideCode() {
            return this.serviceProvideCode;
        }
        
        public String getServiceProvideName() {
            return this.serviceProvideName;
        }
        
        public String getServiceSiteCode() {
            return this.serviceSiteCode;
        }
        
        public String getServiceSiteName() {
            return this.serviceSiteName;
        }
        
        public Object getToCheckServiceSiteAddress() {
            return this.toCheckServiceSiteAddress;
        }
        
        public Object getToCheckServiceSiteName() {
            return this.toCheckServiceSiteName;
        }
        
        public void setAddress(final String address) {
            this.address = address;
        }
        
        public void setCity(final String city) {
            this.city = city;
        }
        
        public void setCounty(final String county) {
            this.county = county;
        }
        
        public void setPhone(final String phone) {
            this.phone = phone;
        }
        
        public void setProvince(final String province) {
            this.province = province;
        }
        
        public void setServiceProvideCode(final String serviceProvideCode) {
            this.serviceProvideCode = serviceProvideCode;
        }
        
        public void setServiceProvideName(final String serviceProvideName) {
            this.serviceProvideName = serviceProvideName;
        }
        
        public void setServiceSiteCode(final String serviceSiteCode) {
            this.serviceSiteCode = serviceSiteCode;
        }
        
        public void setServiceSiteName(final String serviceSiteName) {
            this.serviceSiteName = serviceSiteName;
        }
        
        public void setToCheckServiceSiteAddress(final Object toCheckServiceSiteAddress) {
            this.toCheckServiceSiteAddress = toCheckServiceSiteAddress;
        }
        
        public void setToCheckServiceSiteName(final Object toCheckServiceSiteName) {
            this.toCheckServiceSiteName = toCheckServiceSiteName;
        }
    }
}
