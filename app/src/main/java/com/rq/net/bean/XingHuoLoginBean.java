package com.rq.net.bean;

public class XingHuoLoginBean
{
    private String loginType;
    private String password;
    private String rememberMe;
    private String userName;
    
    public XingHuoLoginBean(final String password, final String userName, final String rememberMe, final String loginType) {
        this.rememberMe = "false";
        this.loginType = "pwd";
        this.password = password;
        this.userName = userName;
        this.rememberMe = rememberMe;
        this.loginType = loginType;
    }
    
    public String getLoginType() {
        return this.loginType;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getRememberMe() {
        return this.rememberMe;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setLoginType(final String loginType) {
        this.loginType = loginType;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public void setRememberMe(final String rememberMe) {
        this.rememberMe = rememberMe;
    }
    
    public void setUserName(final String userName) {
        this.userName = userName;
    }
}
