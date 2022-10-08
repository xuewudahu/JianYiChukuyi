package com.rq.net.bean;

public class BlueShopCookieBean
{
    private String password;
    private String username;
    
    public BlueShopCookieBean(final String username, final String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
}
