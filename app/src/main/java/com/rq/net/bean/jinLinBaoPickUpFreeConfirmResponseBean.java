package com.rq.net.bean;

public class jinLinBaoPickUpFreeConfirmResponseBean
{
    private Body body;
    private int code;
    private String msg;
    
    public Body getBody() {
        return this.body;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setBody(final Body body) {
        this.body = body;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public class Body
    {
        private String consignee_phone;
        private int count;
        private int succ_count;
        
        public String getConsignee_phone() {
            return this.consignee_phone;
        }
        
        public int getCount() {
            return this.count;
        }
        
        public int getSucc_count() {
            return this.succ_count;
        }
        
        public void setConsignee_phone(final String consignee_phone) {
            this.consignee_phone = consignee_phone;
        }
        
        public void setCount(final int count) {
            this.count = count;
        }
        
        public void setSucc_count(final int succ_count) {
            this.succ_count = succ_count;
        }
    }
}
