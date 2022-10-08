package com.rq.net.bean;

import java.util.*;

public class LaiquBillInfoBean
{
    private List<BillCode> waybills;
    
    public List<BillCode> getWaybills() {
        return this.waybills;
    }
    
    public void setWaybills(final List<BillCode> waybills) {
        this.waybills = waybills;
    }
    
    public static class BillCode
    {
        private String billCode;
        
        public BillCode(final String billCode) {
            this.billCode = billCode;
        }
        
        public String getBillCode() {
            return this.billCode;
        }
        
        public void setBillCode(final String billCode) {
            this.billCode = billCode;
        }
    }
}
