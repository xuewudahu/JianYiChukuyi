package com.rq.net.bean;

public class BlueShopLoginBean
{
    private String password;
    private String platform;
    private String username;
    
    public BlueShopLoginBean(final String platform, final String username, final String password) {
        this.platform = "android";
        this.platform = platform;
        this.username = username;
        this.password = password;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getPlatform() {
        return this.platform;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public void setPlatform(final String platform) {
        this.platform = platform;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
}
