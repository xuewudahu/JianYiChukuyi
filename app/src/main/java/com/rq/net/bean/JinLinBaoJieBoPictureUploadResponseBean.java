package com.rq.net.bean;

public class JinLinBaoJieBoPictureUploadResponseBean
{
    private BodyBean body;
    private int code;
    private String msg;
    
    public BodyBean getBody() {
        return this.body;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setBody(final BodyBean body) {
        this.body = body;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public static class BodyBean
    {
        private String exp_code;
        private String img;
        private long img_id;
        private int payment;
        
        public String getExp_code() {
            return this.exp_code;
        }
        
        public String getImg() {
            return this.img;
        }
        
        public long getImg_id() {
            return this.img_id;
        }
        
        public int getPayment() {
            return this.payment;
        }
        
        public void setExp_code(final String exp_code) {
            this.exp_code = exp_code;
        }
        
        public void setImg(final String img) {
            this.img = img;
        }
        
        public void setImg_id(final long img_id) {
            this.img_id = img_id;
        }
        
        public void setPayment(final int payment) {
            this.payment = payment;
        }
    }
}
