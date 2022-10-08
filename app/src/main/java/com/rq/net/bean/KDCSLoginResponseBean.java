package com.rq.net.bean;

public class KDCSLoginResponseBean
{
    private String access_token;
    private String expires_in;
    private String openid;
    private String refresh_token;
    private String scope;
    private String staff_code;
    private String user_id;
    
    public String getAccess_token() {
        return this.access_token;
    }
    
    public String getExpires_in() {
        return this.expires_in;
    }
    
    public String getOpenid() {
        return this.openid;
    }
    
    public String getRefresh_token() {
        return this.refresh_token;
    }
    
    public String getScope() {
        return this.scope;
    }
    
    public String getStaff_code() {
        return this.staff_code;
    }
    
    public String getUser_id() {
        return this.user_id;
    }
    
    public void setAccess_token(final String access_token) {
        this.access_token = access_token;
    }
    
    public void setExpires_in(final String expires_in) {
        this.expires_in = expires_in;
    }
    
    public void setOpenid(final String openid) {
        this.openid = openid;
    }
    
    public void setRefresh_token(final String refresh_token) {
        this.refresh_token = refresh_token;
    }
    
    public void setScope(final String scope) {
        this.scope = scope;
    }
    
    public void setStaff_code(final String staff_code) {
        this.staff_code = staff_code;
    }
    
    public void setUser_id(final String user_id) {
        this.user_id = user_id;
    }
}
