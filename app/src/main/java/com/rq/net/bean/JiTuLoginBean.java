package com.rq.net.bean;

public class JiTuLoginBean
{
    private String account;
    private String appDeviceId;
    private String macAddr;
    private String password;
    
    public JiTuLoginBean(final String appDeviceId, final String account, final String password, final String macAddr) {
        this.appDeviceId = appDeviceId;
        this.account = account;
        this.password = password;
        this.macAddr = macAddr;
    }
    
    public String getAccount() {
        return this.account;
    }
    
    public String getAppDeviceId() {
        return this.appDeviceId;
    }
    
    public String getMacAddr() {
        return this.macAddr;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setAccount(final String account) {
        this.account = account;
    }
    
    public void setAppDeviceId(final String appDeviceId) {
        this.appDeviceId = appDeviceId;
    }
    
    public void setMacAddr(final String macAddr) {
        this.macAddr = macAddr;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
}
