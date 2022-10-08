package com.rq.net.bean;

public class jinLinBaoPickUpConfirmRequestBean
{
    public String amount;
    public String charge_way;
    public String logis_id;
    public String note;
    public String order_id;
    public String sid;
    public String sign;
    public String sign_type;
    public String sn;
    public String ts;
    public String uid;
    
    public jinLinBaoPickUpConfirmRequestBean() {
        this.sign_type = "MD5";
        this.sn = "jlb_ocr_501020205";
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(System.currentTimeMillis());
        this.ts = sb.toString();
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public String getCharge_way() {
        return this.charge_way;
    }
    
    public String getLogis_id() {
        return this.logis_id;
    }
    
    public String getNote() {
        return this.note;
    }
    
    public String getOrder_id() {
        return this.order_id;
    }
    
    public String getSid() {
        return this.sid;
    }
    
    public String getSign() {
        return this.sign;
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
    
    public void setAmount(final String amount) {
        this.amount = amount;
    }
    
    public void setCharge_way(final String charge_way) {
        this.charge_way = charge_way;
    }
    
    public void setLogis_id(final String logis_id) {
        this.logis_id = logis_id;
    }
    
    public void setNote(final String note) {
        this.note = note;
    }
    
    public void setOrder_id(final String order_id) {
        this.order_id = order_id;
    }
    
    public void setSid(final String sid) {
        this.sid = sid;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
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
