package com.rq.net.bean;

public class StationHelperLoginBean
{
    private String password;
    private String phoneNum;
    
    public StationHelperLoginBean(final String phoneNum, final String password) {
        this.phoneNum = phoneNum;
        this.password = password;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getPhoneNum() {
        return this.phoneNum;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public void setPhoneNum(final String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
