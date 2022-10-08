package com.rq.net.bean;

public class LaiquBillInfoResponseBean
{
    private String billCode;
    private String billDetailInfo;
    private String expressCode;
    private String expressName;
    private boolean newCustomer;
    private String phoneLast4;
    private String receiverName;
    private String receiverPhone;
    private int virtualBill;
    private String virtualNumber;
    
    public String getBillCode() {
        return this.billCode;
    }
    
    public String getBillDetailInfo() {
        return this.billDetailInfo;
    }
    
    public String getExpressCode() {
        return this.expressCode;
    }
    
    public String getExpressName() {
        return this.expressName;
    }
    
    public String getPhoneLast4() {
        return this.phoneLast4;
    }
    
    public String getReceiverName() {
        return this.receiverName;
    }
    
    public String getReceiverPhone() {
        return this.receiverPhone;
    }
    
    public int getVirtualBill() {
        return this.virtualBill;
    }
    
    public String getVirtualNumber() {
        return this.virtualNumber;
    }
    
    public boolean isNewCustomer() {
        return this.newCustomer;
    }
    
    public void setBillCode(final String billCode) {
        this.billCode = billCode;
    }
    
    public void setBillDetailInfo(final String billDetailInfo) {
        this.billDetailInfo = billDetailInfo;
    }
    
    public void setExpressCode(final String expressCode) {
        this.expressCode = expressCode;
    }
    
    public void setExpressName(final String expressName) {
        this.expressName = expressName;
    }
    
    public void setNewCustomer(final boolean newCustomer) {
        this.newCustomer = newCustomer;
    }
    
    public void setPhoneLast4(final String phoneLast4) {
        this.phoneLast4 = phoneLast4;
    }
    
    public void setReceiverName(final String receiverName) {
        this.receiverName = receiverName;
    }
    
    public void setReceiverPhone(final String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
    
    public void setVirtualBill(final int virtualBill) {
        this.virtualBill = virtualBill;
    }
    
    public void setVirtualNumber(final String virtualNumber) {
        this.virtualNumber = virtualNumber;
    }
}
