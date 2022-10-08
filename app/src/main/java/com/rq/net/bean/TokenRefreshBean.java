package com.rq.net.bean;

public class TokenRefreshBean
{
    private String token;
    
    public TokenRefreshBean(final String token) {
        this.token = token;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }
}
