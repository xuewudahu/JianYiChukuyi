package com.rq.net.bean;

public class JiTuResponse
{
    private int code;
    private DataBean data;
    private String msg;
    
    public int getCode() {
        return this.code;
    }
    
    public DataBean getData() {
        return this.data;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setData(final DataBean data) {
        this.data = data;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public class DataBean
    {
        private String cityDesc;
        private String loginNetworkMobile;
        private String loginNetworkTypeDesc;
        private String loginNetworkTypeId;
        private String macAddr;
        private String mobile;
        private String networkCode;
        private String providerDesc;
        private String token;
        
        public String getCityDesc() {
            return this.cityDesc;
        }
        
        public String getLoginNetworkMobile() {
            return this.loginNetworkMobile;
        }
        
        public String getLoginNetworkTypeDesc() {
            return this.loginNetworkTypeDesc;
        }
        
        public String getLoginNetworkTypeId() {
            return this.loginNetworkTypeId;
        }
        
        public String getMacAddr() {
            return this.macAddr;
        }
        
        public String getMobile() {
            return this.mobile;
        }
        
        public String getNetworkCode() {
            return this.networkCode;
        }
        
        public String getProviderDesc() {
            return this.providerDesc;
        }
        
        public String getToken() {
            return this.token;
        }
        
        public void setCityDesc(final String cityDesc) {
            this.cityDesc = cityDesc;
        }
        
        public void setLoginNetworkMobile(final String loginNetworkMobile) {
            this.loginNetworkMobile = loginNetworkMobile;
        }
        
        public void setLoginNetworkTypeDesc(final String loginNetworkTypeDesc) {
            this.loginNetworkTypeDesc = loginNetworkTypeDesc;
        }
        
        public void setLoginNetworkTypeId(final String loginNetworkTypeId) {
            this.loginNetworkTypeId = loginNetworkTypeId;
        }
        
        public void setMacAddr(final String macAddr) {
            this.macAddr = macAddr;
        }
        
        public void setMobile(final String mobile) {
            this.mobile = mobile;
        }
        
        public void setNetworkCode(final String networkCode) {
            this.networkCode = networkCode;
        }
        
        public void setProviderDesc(final String providerDesc) {
            this.providerDesc = providerDesc;
        }
        
        public void setToken(final String token) {
            this.token = token;
        }
    }
}
