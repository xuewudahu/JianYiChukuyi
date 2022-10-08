package com.rq.net.bean;

public class KuaiBaoDeliveryStorageBean extends KuaiBaoBaseBean
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
        private String brand;
        private String phone;
        private String scan_time;
        private String source_type;
        private String waybill_nos;
        
        public DataBean(final String scan_time, final String phone, final String source_type, final String brand, final String waybill_nos) {
            this.scan_time = scan_time;
            this.phone = phone;
            this.source_type = source_type;
            this.brand = brand;
            this.waybill_nos = waybill_nos;
        }
        
        public String getBrand() {
            return this.brand;
        }
        
        public String getPhone() {
            return this.phone;
        }
        
        public String getScan_time() {
            return this.scan_time;
        }
        
        public String getSource_type() {
            return this.source_type;
        }
        
        public String getWaybill_nos() {
            return this.waybill_nos;
        }
        
        public void setBrand(final String brand) {
            this.brand = brand;
        }
        
        public void setPhone(final String phone) {
            this.phone = phone;
        }
        
        public void setScan_time(final String scan_time) {
            this.scan_time = scan_time;
        }
        
        public void setSource_type(final String source_type) {
            this.source_type = source_type;
        }
        
        public void setWaybill_nos(final String waybill_nos) {
            this.waybill_nos = waybill_nos;
        }
    }
}
