package com.rq.net.bean;

public class GetStsResponseTokenBean
{
    private String AccessKeyId;
    private String AccessKeySecret;
    private String Expiration;
    private String SecurityToken;
    
    public String getAccessKeyId() {
        return this.AccessKeyId;
    }
    
    public String getAccessKeySecret() {
        return this.AccessKeySecret;
    }
    
    public String getExpiration() {
        return this.Expiration;
    }
    
    public String getSecurityToken() {
        return this.SecurityToken;
    }
    
    public void setAccessKeyId(final String accessKeyId) {
        this.AccessKeyId = accessKeyId;
    }
    
    public void setAccessKeySecret(final String accessKeySecret) {
        this.AccessKeySecret = accessKeySecret;
    }
    
    public void setExpiration(final String expiration) {
        this.Expiration = expiration;
    }
    
    public void setSecurityToken(final String securityToken) {
        this.SecurityToken = securityToken;
    }
}
