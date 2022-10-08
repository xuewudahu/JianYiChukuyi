package com.rq.net.bean;

public class KuaiBaoGetUserUnPickUpListsResponseBean
{
    private int num;
    private Object result;
    
    public int getNum() {
        return this.num;
    }
    
    public Object getResult() {
        return this.result;
    }
    
    public void setNum(final int num) {
        this.num = num;
    }
    
    public void setResult(final Object result) {
        this.result = result;
    }
    
    public static class ResultBean
    {
        private String brand;
        private String brand_cn;
        private String created_time;
        private String id;
        private String nick_name;
        private String pickup_code;
        private String signer;
        private String waybill_no;
        
        public String getBrand() {
            return this.brand;
        }
        
        public String getBrand_cn() {
            return this.brand_cn;
        }
        
        public String getCreated_time() {
            return this.created_time;
        }
        
        public String getId() {
            return this.id;
        }
        
        public String getNick_name() {
            return this.nick_name;
        }
        
        public String getPickup_code() {
            return this.pickup_code;
        }
        
        public String getSigner() {
            return this.signer;
        }
        
        public String getWaybill_no() {
            return this.waybill_no;
        }
        
        public void setBrand(final String brand) {
            this.brand = brand;
        }
        
        public void setBrand_cn(final String brand_cn) {
            this.brand_cn = brand_cn;
        }
        
        public void setCreated_time(final String created_time) {
            this.created_time = created_time;
        }
        
        public void setId(final String id) {
            this.id = id;
        }
        
        public void setNick_name(final String nick_name) {
            this.nick_name = nick_name;
        }
        
        public void setPickup_code(final String pickup_code) {
            this.pickup_code = pickup_code;
        }
        
        public void setSigner(final String signer) {
            this.signer = signer;
        }
        
        public void setWaybill_no(final String waybill_no) {
            this.waybill_no = waybill_no;
        }
    }
}
