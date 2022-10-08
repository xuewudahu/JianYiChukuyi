package com.rq.net.bean;

public class KuaiBaoQueryBillcodeInforBean extends KuaiBaoBaseBean
{
    private String data;
    
    public String getData() {
        return this.data;
    }
    
    public void setData(final String data) {
        this.data = data;
    }
    
    public static class BillcodeInforData
    {
        private String brand;
        private String is_match;
        private String is_new;
        private String waybillNo;
        
        public BillcodeInforData(final String is_match, final String is_new, final String waybillNo, final String brand) {
            this.is_match = is_match;
            this.is_new = is_new;
            this.waybillNo = waybillNo;
            this.brand = brand;
        }
        
        public String getBrand() {
            return this.brand;
        }
        
        public String getIs_match() {
            return this.is_match;
        }
        
        public String getIs_new() {
            return this.is_new;
        }
        
        public String getWaybillNo() {
            return this.waybillNo;
        }
        
        public void setBrand(final String brand) {
            this.brand = brand;
        }
        
        public void setIs_match(final String is_match) {
            this.is_match = is_match;
        }
        
        public void setIs_new(final String is_new) {
            this.is_new = is_new;
        }
        
        public void setWaybillNo(final String waybillNo) {
            this.waybillNo = waybillNo;
        }
    }
}
