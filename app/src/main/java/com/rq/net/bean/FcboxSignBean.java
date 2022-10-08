package com.rq.net.bean;

import java.util.*;

public class FcboxSignBean
{
    private List<ExpressInfosBean> expressInfos;
    private String signImgUrl;
    
    public FcboxSignBean() {
        this.signImgUrl = "";
        this.expressInfos = new ArrayList<ExpressInfosBean>();
    }
    
    public List<ExpressInfosBean> getExpressInfos() {
        return this.expressInfos;
    }
    
    public String getSignImgUrl() {
        return this.signImgUrl;
    }
    
    public void setExpressInfos(final List<ExpressInfosBean> expressInfos) {
        this.expressInfos = expressInfos;
    }
    
    public void setSignImgUrl(final String signImgUrl) {
        this.signImgUrl = signImgUrl;
    }
    
    public static class ExpressInfosBean
    {
        private String boxThrowLocation;
        private String entryTime;
        private String expressCompanyId;
        private String expressCompanyName;
        private String expressNo;
        private String fetchCode;
        private boolean includServiceFee;
        private boolean isStatusSatisfied;
        private String localState;
        private String localType;
        private boolean needPay;
        private String paymentAmount;
        private String paymentStatus;
        private String paymentType;
        private String paymentTypeName;
        private int postId;
        private int postStatus;
        private String postStatusName;
        private String receiverMobile;
        private String receiverName;
        private String shelfTime;
        private String signImgUrl;
        private String subOrderStatusStr;
        
        public String getBoxThrowLocation() {
            return this.boxThrowLocation;
        }
        
        public String getEntryTime() {
            return this.entryTime;
        }
        
        public String getExpressCompanyId() {
            return this.expressCompanyId;
        }
        
        public String getExpressCompanyName() {
            return this.expressCompanyName;
        }
        
        public String getExpressNo() {
            return this.expressNo;
        }
        
        public String getFetchCode() {
            return this.fetchCode;
        }
        
        public String getLocalState() {
            return this.localState;
        }
        
        public String getLocalType() {
            return this.localType;
        }
        
        public String getPaymentAmount() {
            return this.paymentAmount;
        }
        
        public String getPaymentStatus() {
            return this.paymentStatus;
        }
        
        public String getPaymentType() {
            return this.paymentType;
        }
        
        public String getPaymentTypeName() {
            return this.paymentTypeName;
        }
        
        public int getPostId() {
            return this.postId;
        }
        
        public int getPostStatus() {
            return this.postStatus;
        }
        
        public String getPostStatusName() {
            return this.postStatusName;
        }
        
        public String getReceiverMobile() {
            return this.receiverMobile;
        }
        
        public String getReceiverName() {
            return this.receiverName;
        }
        
        public String getShelfTime() {
            return this.shelfTime;
        }
        
        public String getSignImgUrl() {
            return this.signImgUrl;
        }
        
        public String getSubOrderStatusStr() {
            return this.subOrderStatusStr;
        }
        
        public boolean isIncludServiceFee() {
            return this.includServiceFee;
        }
        
        public boolean isIsStatusSatisfied() {
            return this.isStatusSatisfied;
        }
        
        public boolean isNeedPay() {
            return this.needPay;
        }
        
        public void setBoxThrowLocation(final String boxThrowLocation) {
            this.boxThrowLocation = boxThrowLocation;
        }
        
        public void setEntryTime(final String entryTime) {
            this.entryTime = entryTime;
        }
        
        public void setExpressCompanyId(final String expressCompanyId) {
            this.expressCompanyId = expressCompanyId;
        }
        
        public void setExpressCompanyName(final String expressCompanyName) {
            this.expressCompanyName = expressCompanyName;
        }
        
        public void setExpressNo(final String expressNo) {
            this.expressNo = expressNo;
        }
        
        public void setFetchCode(final String fetchCode) {
            this.fetchCode = fetchCode;
        }
        
        public void setIncludServiceFee(final boolean includServiceFee) {
            this.includServiceFee = includServiceFee;
        }
        
        public void setIsStatusSatisfied(final boolean isStatusSatisfied) {
            this.isStatusSatisfied = isStatusSatisfied;
        }
        
        public void setLocalState(final String localState) {
            this.localState = localState;
        }
        
        public void setLocalType(final String localType) {
            this.localType = localType;
        }
        
        public void setNeedPay(final boolean needPay) {
            this.needPay = needPay;
        }
        
        public void setPaymentAmount(final String paymentAmount) {
            this.paymentAmount = paymentAmount;
        }
        
        public void setPaymentStatus(final String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }
        
        public void setPaymentType(final String paymentType) {
            this.paymentType = paymentType;
        }
        
        public void setPaymentTypeName(final String paymentTypeName) {
            this.paymentTypeName = paymentTypeName;
        }
        
        public void setPostId(final int postId) {
            this.postId = postId;
        }
        
        public void setPostStatus(final int postStatus) {
            this.postStatus = postStatus;
        }
        
        public void setPostStatusName(final String postStatusName) {
            this.postStatusName = postStatusName;
        }
        
        public void setReceiverMobile(final String receiverMobile) {
            this.receiverMobile = receiverMobile;
        }
        
        public void setReceiverName(final String receiverName) {
            this.receiverName = receiverName;
        }
        
        public void setShelfTime(final String shelfTime) {
            this.shelfTime = shelfTime;
        }
        
        public void setSignImgUrl(final String signImgUrl) {
            this.signImgUrl = signImgUrl;
        }
        
        public void setSubOrderStatusStr(final String subOrderStatusStr) {
            this.subOrderStatusStr = subOrderStatusStr;
        }
    }
}
