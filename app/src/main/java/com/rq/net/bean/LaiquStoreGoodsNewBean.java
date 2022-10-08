package com.rq.net.bean;

import java.util.*;

public class LaiquStoreGoodsNewBean
{
    private int sendSms;
    private List<Template> templates;
    private List<Waybill> waybills;
    
    public class Template
    {
        private String messageType;
        private int smsId;
        private String templateType;
        
        public Template() {
            this.messageType = "text";
            this.templateType = "";
        }
        
        public String getMessageType() {
            return this.messageType;
        }
        
        public int getSmsId() {
            return this.smsId;
        }
        
        public String getTemplateType() {
            return this.templateType;
        }
        
        public void setMessageType(final String messageType) {
            this.messageType = messageType;
        }
        
        public void setSmsId(final int smsId) {
            this.smsId = smsId;
        }
        
        public void setTemplateType(final String templateType) {
            this.templateType = templateType;
        }
    }
    
    public class Waybill
    {
        private boolean agencySign;
        private String billCode;
        private String expressCode;
        private String goodsNumber;
        private String receiverName;
        private String receiverPhone;
        private long scanTime;
        private String shelfName;
        private String shelfNum;
        private int virtualBill;
        
        public String getBillCode() {
            return this.billCode;
        }
        
        public String getExpressCode() {
            return this.expressCode;
        }
        
        public String getGoodsNumber() {
            return this.goodsNumber;
        }
        
        public String getReceiverName() {
            return this.receiverName;
        }
        
        public String getReceiverPhone() {
            return this.receiverPhone;
        }
        
        public long getScanTime() {
            return this.scanTime;
        }
        
        public String getShelfName() {
            return this.shelfName;
        }
        
        public String getShelfNum() {
            return this.shelfNum;
        }
        
        public int getVirtualBill() {
            return this.virtualBill;
        }
        
        public boolean isAgencySign() {
            return this.agencySign;
        }
        
        public void setAgencySign(final boolean agencySign) {
            this.agencySign = agencySign;
        }
        
        public void setBillCode(final String billCode) {
            this.billCode = billCode;
        }
        
        public void setExpressCode(final String expressCode) {
            this.expressCode = expressCode;
        }
        
        public void setGoodsNumber(final String goodsNumber) {
            this.goodsNumber = goodsNumber;
        }
        
        public void setReceiverName(final String receiverName) {
            this.receiverName = receiverName;
        }
        
        public void setReceiverPhone(final String receiverPhone) {
            this.receiverPhone = receiverPhone;
        }
        
        public void setScanTime(final long scanTime) {
            this.scanTime = scanTime;
        }
        
        public void setShelfName(final String shelfName) {
            this.shelfName = shelfName;
        }
        
        public void setShelfNum(final String shelfNum) {
            this.shelfNum = shelfNum;
        }
        
        public void setVirtualBill(final int virtualBill) {
            this.virtualBill = virtualBill;
        }
    }
}
