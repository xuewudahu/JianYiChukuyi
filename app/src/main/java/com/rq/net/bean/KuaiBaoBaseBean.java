package com.rq.net.bean;


import com.rq.net.setting.RqFilePreference;

public class KuaiBaoBaseBean
{
    protected String app_id;
    protected String session_id;
    protected String sign;
    protected String ts;
    
    public KuaiBaoBaseBean() {
        this.app_id = "10014";
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(System.currentTimeMillis());
        this.ts = sb.toString();
        this.session_id = RqFilePreference.getInstance().getKuaibaoSessionId();
    }
    
    public String getApp_id() {
        return this.app_id;
    }
    
    public String getSession_id() {
        return this.session_id;
    }
    
    public String getSign() {
        return this.sign;
    }
    
    public String getTs() {
        return this.ts;
    }
    
    public void setApp_id(final String app_id) {
        this.app_id = app_id;
    }
    
    public void setSession_id(final String session_id) {
        this.session_id = session_id;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setTs(final String ts) {
        this.ts = ts;
    }
}
