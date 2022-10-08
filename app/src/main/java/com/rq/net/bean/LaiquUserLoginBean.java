package com.rq.net.bean;

public class LaiquUserLoginBean
{
    private String password;
    private String username;
    
    public LaiquUserLoginBean(final String username, final String password) {
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
