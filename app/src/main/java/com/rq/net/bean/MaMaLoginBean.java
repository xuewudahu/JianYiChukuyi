package com.rq.net.bean;

public class MaMaLoginBean
{
    private String modelNo;
    private String password;
    private String serialNo;
    private String username;
    private String versionNo;

    private String password_save;

    public String getPassword_save() {
        return password_save;
    }

    public void setPassword_save(String password_save) {
        this.password_save = password_save;
    }

    public String getModelNo() {
        return this.modelNo;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getSerialNo() {
        return this.serialNo;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getVersionNo() {
        return this.versionNo;
    }
    
    public void setModelNo(final String modelNo) {
        this.modelNo = modelNo;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public void setSerialNo(final String serialNo) {
        this.serialNo = serialNo;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public void setVersionNo(final String versionNo) {
        this.versionNo = versionNo;
    }
}
