package com.rq.net.bean;

public class JinLinBaoUserLogin2RequestBean
{
    public String logis_id;
    public String sign_type;
    public String ts;
    
    public JinLinBaoUserLogin2RequestBean() {
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(System.currentTimeMillis());
        this.ts = sb.toString();
        this.sign_type = "MD5";
    }
    
    public String getLogis_id() {
        return this.logis_id;
    }
    
    public String getSign_type() {
        return this.sign_type;
    }
    
    public String getTs() {
        return this.ts;
    }
    
    public void setLogis_id(final String logis_id) {
        this.logis_id = logis_id;
    }
    
    public void setSign_type(final String sign_type) {
        this.sign_type = sign_type;
    }
    
    public void setTs(final String ts) {
        this.ts = ts;
    }
}
