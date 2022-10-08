package com.rq.net.bean;

import java.util.*;

public class YunDaKDCSUploadBean
{
    private List<ItemsBean> items;
    private MyAgentInfoBean myAgentInfo;
    
    public YunDaKDCSUploadBean() {
        this.items = new ArrayList<ItemsBean>();
    }
    
    public List<ItemsBean> getItems() {
        return this.items;
    }
    
    public MyAgentInfoBean getMyAgentInfo() {
        return this.myAgentInfo;
    }
    
    public void setItems(final List<ItemsBean> items) {
        this.items = items;
    }
    
    public void setMyAgentInfo(final MyAgentInfoBean myAgentInfo) {
        this.myAgentInfo = myAgentInfo;
    }
    
    public static class ItemsBean
    {
        private String company;
        private String pickCode;
        private String recePhone;
        private String shipId;
        private String ydUserId;
        
        public String getCompany() {
            return this.company;
        }
        
        public String getPickCode() {
            return this.pickCode;
        }
        
        public String getRecePhone() {
            return this.recePhone;
        }
        
        public String getShipId() {
            return this.shipId;
        }
        
        public String getYdUserId() {
            return this.ydUserId;
        }
        
        public void setCompany(final String company) {
            this.company = company;
        }
        
        public void setPickCode(final String pickCode) {
            this.pickCode = pickCode;
        }
        
        public void setRecePhone(final String recePhone) {
            this.recePhone = recePhone;
        }
        
        public void setShipId(final String shipId) {
            this.shipId = shipId;
        }
        
        public void setYdUserId(final String ydUserId) {
            this.ydUserId = ydUserId;
        }
    }
    
    public static class MyAgentInfoBean
    {
        private String accountPhone;
        private String agentAddress;
        private String agentId;
        private String agentName;
        private String agentPhone;
        private String kdyId;
        private String source;
        private String userId;
        
        public String getAccountPhone() {
            return this.accountPhone;
        }
        
        public String getAgentAddress() {
            return this.agentAddress;
        }
        
        public String getAgentId() {
            return this.agentId;
        }
        
        public String getAgentName() {
            return this.agentName;
        }
        
        public String getAgentPhone() {
            return this.agentPhone;
        }
        
        public String getKdyId() {
            return this.kdyId;
        }
        
        public String getSource() {
            return this.source;
        }
        
        public String getUserId() {
            return this.userId;
        }
        
        public void setAccountPhone(final String accountPhone) {
            this.accountPhone = accountPhone;
        }
        
        public void setAgentAddress(final String agentAddress) {
            this.agentAddress = agentAddress;
        }
        
        public void setAgentId(final String agentId) {
            this.agentId = agentId;
        }
        
        public void setAgentName(final String agentName) {
            this.agentName = agentName;
        }
        
        public void setAgentPhone(final String agentPhone) {
            this.agentPhone = agentPhone;
        }
        
        public void setKdyId(final String kdyId) {
            this.kdyId = kdyId;
        }
        
        public void setSource(final String source) {
            this.source = source;
        }
        
        public void setUserId(final String userId) {
            this.userId = userId;
        }
    }
}
