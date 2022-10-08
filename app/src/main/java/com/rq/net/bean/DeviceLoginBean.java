package com.rq.net.bean;


public class DeviceLoginBean {
    private String token = "";
    private String username;

    public DeviceLoginBean() {
    }

    public String getToken() {
        return this.token;
    }

    public String getUsername() {
        return this.username;
    }

    public void setToken(String var1) {
        this.token = var1;
    }

    public void setUsername(String var1) {
        this.username = var1;
    }
}
