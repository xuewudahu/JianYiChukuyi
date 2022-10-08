package com.rq.net.bean;

public class JinLinBaoJieBoPictureUploadRequestBean
{
    public String batch_id;
    public String delivery_mode;
    public String express_id;
    public String logis_id;
    public String payment;
    public String sid;
    public String sign_type;
    public String sn;
    public String storage_type;
    public String ts;
    public String uid;
    
    public JinLinBaoJieBoPictureUploadRequestBean() {
        this.sn = "jlb_ocr_501020205";
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(System.currentTimeMillis());
        this.ts = sb.toString();
        this.sign_type = "MD5";
    }
    
    public String getBatch_id() {
        return this.batch_id;
    }
    
    public String getDelivery_mode() {
        return this.delivery_mode;
    }
    
    public String getExpress_id() {
        return this.express_id;
    }
    
    public String getLogis_id() {
        return this.logis_id;
    }
    
    public String getPayment() {
        return this.payment;
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
    
    public String getStorage_type() {
        return this.storage_type;
    }
    
    public String getTs() {
        return this.ts;
    }
    
    public String getUid() {
        return this.uid;
    }
    
    public void setBatch_id(final String batch_id) {
        this.batch_id = batch_id;
    }
    
    public void setDelivery_mode(final String delivery_mode) {
        this.delivery_mode = delivery_mode;
    }
    
    public void setExpress_id(final String express_id) {
        this.express_id = express_id;
    }
    
    public void setLogis_id(final String logis_id) {
        this.logis_id = logis_id;
    }
    
    public void setPayment(final String payment) {
        this.payment = payment;
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
    
    public void setStorage_type(final String storage_type) {
        this.storage_type = storage_type;
    }
    
    public void setTs(final String ts) {
        this.ts = ts;
    }
    
    public void setUid(final String uid) {
        this.uid = uid;
    }
}
