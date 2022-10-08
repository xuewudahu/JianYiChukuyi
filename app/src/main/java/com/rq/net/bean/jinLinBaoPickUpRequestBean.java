package com.rq.net.bean;

public class jinLinBaoPickUpRequestBean
{
    public String consignee_phone;
    public String logis_id;
    public String order_id;
    public String sid;
    public String sign_type;
    public String sn;
    public String ts;
    public String uid;
    
    public jinLinBaoPickUpRequestBean() {
        this.sn = "jlb_ocr_501020208";
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(System.currentTimeMillis());
        this.ts = sb.toString();
        this.sign_type = "MD5";
    }
    
    public String getConsignee_phone() {
        return this.consignee_phone;
    }
    
    public String getLogis_id() {
        return this.logis_id;
    }
    
    public String getOrder_id() {
        return this.order_id;
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
    
    public void setConsignee_phone(final String consignee_phone) {
        this.consignee_phone = consignee_phone;
    }
    
    public void setLogis_id(final String logis_id) {
        this.logis_id = logis_id;
    }
    
    public void setOrder_id(final String order_id) {
        this.order_id = order_id;
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
