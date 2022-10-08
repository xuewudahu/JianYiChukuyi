package com.rq.net.bean;

public class KuaiBaoGetUserUnPickUpListsBean extends KuaiBaoBaseBean
{
    private String data;
    
    public String getData() {
        return this.data;
    }
    
    public void setData(final String data) {
        this.data = data;
    }
    
    public static class DataBean
    {
        private String phone;
        private String waybill;
        
        public DataBean(final String waybill, final String phone) {
            this.waybill = waybill;
            this.phone = phone;
        }
        
        public String getPhone() {
            return this.phone;
        }
        
        public String getWaybill() {
            return this.waybill;
        }
        
        public void setPhone(final String phone) {
            this.phone = phone;
        }
        
        public void setWaybill(final String waybill) {
            this.waybill = waybill;
        }
    }
}
