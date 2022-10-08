package com.rq.net.bean;

public class jinLinBaoPickUpFreeConfirmRequestBean
{
    public String count;
    public String courier_uid;
    public String image_data;
    public String logis_id;
    public String order_ids;
    public String sid;
    public String sign_type;
    public String sn;
    public String ts;
    public String uid;
    
    public jinLinBaoPickUpFreeConfirmRequestBean() {
        this.sn = "jlb_ocr_501020208";
        this.image_data = "{}";
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(System.currentTimeMillis());
        this.ts = sb.toString();
        this.sign_type = "MD5";
    }
    
    public String getCount() {
        return this.count;
    }
    
    public String getCourier_uid() {
        return this.courier_uid;
    }
    
    public String getImage_data() {
        return this.image_data;
    }
    
    public String getLogis_id() {
        return this.logis_id;
    }
    
    public String getOrder_ids() {
        return this.order_ids;
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
    
    public void setCount(final String count) {
        this.count = count;
    }
    
    public void setCourier_uid(final String courier_uid) {
        this.courier_uid = courier_uid;
    }
    
    public void setImage_data(final String image_data) {
        this.image_data = image_data;
    }
    
    public void setLogis_id(final String logis_id) {
        this.logis_id = logis_id;
    }
    
    public void setOrder_ids(final String order_ids) {
        this.order_ids = order_ids;
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
