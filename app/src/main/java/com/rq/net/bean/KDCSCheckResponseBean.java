package com.rq.net.bean;

import java.util.*;

public class KDCSCheckResponseBean
{
    private List<Items> items;
    private List<Items> suspectedItems;
    private int type;
    
    public List<Items> getItems() {
        return this.items;
    }
    
    public List<Items> getSuspectedItems() {
        return this.suspectedItems;
    }
    
    public int getType() {
        return this.type;
    }
    
    public void setItems(final List<Items> items) {
        this.items = items;
    }
    
    public void setSuspectedItems(final List<Items> suspectedItems) {
        this.suspectedItems = suspectedItems;
    }
    
    public void setType(final int type) {
        this.type = type;
    }
    
    public class Items
    {
        private String billCode;
        private String companyName;
        private String expressCompanyCode;
        private String leaveRemark;
        private String logo;
        private String receiveMan;
        private String receiveManMobile;
        private String takeCode;
        
        public String getBillCode() {
            return this.billCode;
        }
        
        public String getCompanyName() {
            return this.companyName;
        }
        
        public String getExpressCompanyCode() {
            return this.expressCompanyCode;
        }
        
        public String getLeaveRemark() {
            return this.leaveRemark;
        }
        
        public String getLogo() {
            return this.logo;
        }
        
        public String getReceiveMan() {
            return this.receiveMan;
        }
        
        public String getReceiveManMobile() {
            return this.receiveManMobile;
        }
        
        public String getTakeCode() {
            return this.takeCode;
        }
        
        public void setBillCode(final String billCode) {
            this.billCode = billCode;
        }
        
        public void setCompanyName(final String companyName) {
            this.companyName = companyName;
        }
        
        public void setExpressCompanyCode(final String expressCompanyCode) {
            this.expressCompanyCode = expressCompanyCode;
        }
        
        public void setLeaveRemark(final String leaveRemark) {
            this.leaveRemark = leaveRemark;
        }
        
        public void setLogo(final String logo) {
            this.logo = logo;
        }
        
        public void setReceiveMan(final String receiveMan) {
            this.receiveMan = receiveMan;
        }
        
        public void setReceiveManMobile(final String receiveManMobile) {
            this.receiveManMobile = receiveManMobile;
        }
        
        public void setTakeCode(final String takeCode) {
            this.takeCode = takeCode;
        }
    }
}
