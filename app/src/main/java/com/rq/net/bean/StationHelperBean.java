package com.rq.net.bean;

public class StationHelperBean
{
    public String password;
    public String phoneNum;
    
    public StationHelperBean(final String phoneNum, final String password) {
        this.phoneNum = phoneNum;
        this.password = password;
    }
}
