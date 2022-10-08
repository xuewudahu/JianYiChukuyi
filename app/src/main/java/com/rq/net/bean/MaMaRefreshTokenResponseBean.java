package com.rq.net.bean;

public class MaMaRefreshTokenResponseBean
{
    private String accid;
    private String imToken;
    private String token;
    
    public String getAccid() {
        return this.accid;
    }
    
    public String getImToken() {
        return this.imToken;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public void setAccid(final String accid) {
        this.accid = accid;
    }
    
    public void setImToken(final String imToken) {
        this.imToken = imToken;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }
}
