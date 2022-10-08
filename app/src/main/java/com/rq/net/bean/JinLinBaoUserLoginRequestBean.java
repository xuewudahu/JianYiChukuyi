package com.rq.net.bean;

public class JinLinBaoUserLoginRequestBean
{
    public String check_money;
    public String name;
    public String password;
    public String sign_type;
    public String sn;
    public String ts;
    
    public JinLinBaoUserLoginRequestBean() {
        this.sn = "jlb_ocr_501020208";
        this.check_money = "0";
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(System.currentTimeMillis());
        this.ts = sb.toString();
        this.sign_type = "MD5";
    }
    
    public String getCheck_money() {
        return this.check_money;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getSign_type() {
        return this.sign_type;
    }
    
    public String getSn() {
        return this.sn;
    }
    
    public String getTs() {
        return this.ts;
    }
    
    public void setCheck_money(final String check_money) {
        this.check_money = check_money;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public void setSign_type(final String sign_type) {
        this.sign_type = sign_type;
    }
    
    public void setSn(final String sn) {
        this.sn = sn;
    }
    
    public void setTs(final String ts) {
        this.ts = ts;
    }
}
