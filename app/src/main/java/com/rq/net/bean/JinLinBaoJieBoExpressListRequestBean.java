package com.rq.net.bean;

public class JinLinBaoJieBoExpressListRequestBean
{
    public String logis_id;
    public String sid;
    public String sign_type;
    public String sn;
    public String ts;
    public String uid;
    
    public JinLinBaoJieBoExpressListRequestBean() {
        this.sn = "jlb_ocr_501020208";
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(System.currentTimeMillis());
        this.ts = sb.toString();
        this.sign_type = "MD5";
    }
    
    public String getLogis_id() {
        return this.logis_id;
    }
    
    public String getSid() {
        return this.sid;
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
    
    public String getUid() {
        return this.uid;
    }
    
    public void setLogis_id(final String logis_id) {
        this.logis_id = logis_id;
    }
    
    public void setSid(final String sid) {
        this.sid = sid;
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
    
    public void setUid(final String uid) {
        this.uid = uid;
    }
}
