package com.rq.net.bean;

import java.util.*;

public class LaiquOutLibraryResponseBean
{
    private Object errorCode;
    private List<GoodsListBean> goodsList;
    private int resultCode;
    private Object resultDesc;
    private List<WaybillsRelatedBean> waybillsRelated;
    
    public Object getErrorCode() {
        return this.errorCode;
    }
    
    public List<GoodsListBean> getGoodsList() {
        return this.goodsList;
    }
    
    public int getResultCode() {
        return this.resultCode;
    }
    
    public Object getResultDesc() {
        return this.resultDesc;
    }
    
    public List<WaybillsRelatedBean> getWaybillsRelated() {
        return this.waybillsRelated;
    }
    
    public void setErrorCode(final Object errorCode) {
        this.errorCode = errorCode;
    }
    
    public void setGoodsList(final List<GoodsListBean> goodsList) {
        this.goodsList = goodsList;
    }
    
    public void setResultCode(final int resultCode) {
        this.resultCode = resultCode;
    }
    
    public void setResultDesc(final Object resultDesc) {
        this.resultDesc = resultDesc;
    }
    
    public void setWaybillsRelated(final List<WaybillsRelatedBean> waybillsRelated) {
        this.waybillsRelated = waybillsRelated;
    }
    
    public static class GoodsListBean
    {
        private Object agencySign;
        private String billCode;
        private Object errorCode;
        private String expressCompanyCode;
        private String goodsNumber;
        private Object goodsStatusCode;
        private long instorageTime;
        private long outstorageTime;
        private String receiverName;
        private String receiverPhone;
        private int resultCode;
        private Object resultDesc;
        private Object waybillsRelated;
        
        public Object getAgencySign() {
            return this.agencySign;
        }
        
        public String getBillCode() {
            return this.billCode;
        }
        
        public Object getErrorCode() {
            return this.errorCode;
        }
        
        public String getExpressCompanyCode() {
            return this.expressCompanyCode;
        }
        
        public String getGoodsNumber() {
            return this.goodsNumber;
        }
        
        public Object getGoodsStatusCode() {
            return this.goodsStatusCode;
        }
        
        public long getInstorageTime() {
            return this.instorageTime;
        }
        
        public long getOutstorageTime() {
            return this.outstorageTime;
        }
        
        public String getReceiverName() {
            return this.receiverName;
        }
        
        public String getReceiverPhone() {
            return this.receiverPhone;
        }
        
        public int getResultCode() {
            return this.resultCode;
        }
        
        public Object getResultDesc() {
            return this.resultDesc;
        }
        
        public Object getWaybillsRelated() {
            return this.waybillsRelated;
        }
        
        public void setAgencySign(final Object agencySign) {
            this.agencySign = agencySign;
        }
        
        public void setBillCode(final String billCode) {
            this.billCode = billCode;
        }
        
        public void setErrorCode(final Object errorCode) {
            this.errorCode = errorCode;
        }
        
        public void setExpressCompanyCode(final String expressCompanyCode) {
            this.expressCompanyCode = expressCompanyCode;
        }
        
        public void setGoodsNumber(final String goodsNumber) {
            this.goodsNumber = goodsNumber;
        }
        
        public void setGoodsStatusCode(final Object goodsStatusCode) {
            this.goodsStatusCode = goodsStatusCode;
        }
        
        public void setInstorageTime(final long instorageTime) {
            this.instorageTime = instorageTime;
        }
        
        public void setOutstorageTime(final long outstorageTime) {
            this.outstorageTime = outstorageTime;
        }
        
        public void setReceiverName(final String receiverName) {
            this.receiverName = receiverName;
        }
        
        public void setReceiverPhone(final String receiverPhone) {
            this.receiverPhone = receiverPhone;
        }
        
        public void setResultCode(final int resultCode) {
            this.resultCode = resultCode;
        }
        
        public void setResultDesc(final Object resultDesc) {
            this.resultDesc = resultDesc;
        }
        
        public void setWaybillsRelated(final Object waybillsRelated) {
            this.waybillsRelated = waybillsRelated;
        }
    }
    
    public static class WaybillsRelatedBean
    {
        private Object agencySign;
        private Object beforeCallInfo;
        private String billCode;
        private Object cancelSign;
        private Object expressCode;
        private String expressCompanyCode;
        private String expressCompanyName;
        private Object expressName;
        private String goodsNumber;
        private String goodsStatusCode;
        private int instorageDays;
        private long instorageTime;
        private Object isProblem;
        private long lastUpdateTime;
        private Object messageList;
        private int messageResult;
        private Object messageType;
        private Object oriPhotoSize;
        private Object oriPickupPhoto;
        private Object pickupPhoto;
        private Object pickupType;
        private Object precost;
        private Object problem;
        private Object problemType;
        private String receiverName;
        private String receiverPhone;
        private Object remark;
        private String serviceSiteCode;
        private Object shelfName;
        private Object shelfNumber;
        private String spCode;
        private Object statusCode;
        private Object templateId;
        private Object templateName;
        private Object templateType;
        private Object virtualBill;
        private Object virtualCallInfo;
        private Object virtualNumber;
        
        public Object getAgencySign() {
            return this.agencySign;
        }
        
        public Object getBeforeCallInfo() {
            return this.beforeCallInfo;
        }
        
        public String getBillCode() {
            return this.billCode;
        }
        
        public Object getCancelSign() {
            return this.cancelSign;
        }
        
        public Object getExpressCode() {
            return this.expressCode;
        }
        
        public String getExpressCompanyCode() {
            return this.expressCompanyCode;
        }
        
        public String getExpressCompanyName() {
            return this.expressCompanyName;
        }
        
        public Object getExpressName() {
            return this.expressName;
        }
        
        public String getGoodsNumber() {
            return this.goodsNumber;
        }
        
        public String getGoodsStatusCode() {
            return this.goodsStatusCode;
        }
        
        public int getInstorageDays() {
            return this.instorageDays;
        }
        
        public long getInstorageTime() {
            return this.instorageTime;
        }
        
        public Object getIsProblem() {
            return this.isProblem;
        }
        
        public long getLastUpdateTime() {
            return this.lastUpdateTime;
        }
        
        public Object getMessageList() {
            return this.messageList;
        }
        
        public int getMessageResult() {
            return this.messageResult;
        }
        
        public Object getMessageType() {
            return this.messageType;
        }
        
        public Object getOriPhotoSize() {
            return this.oriPhotoSize;
        }
        
        public Object getOriPickupPhoto() {
            return this.oriPickupPhoto;
        }
        
        public Object getPickupPhoto() {
            return this.pickupPhoto;
        }
        
        public Object getPickupType() {
            return this.pickupType;
        }
        
        public Object getPrecost() {
            return this.precost;
        }
        
        public Object getProblem() {
            return this.problem;
        }
        
        public Object getProblemType() {
            return this.problemType;
        }
        
        public String getReceiverName() {
            return this.receiverName;
        }
        
        public String getReceiverPhone() {
            return this.receiverPhone;
        }
        
        public Object getRemark() {
            return this.remark;
        }
        
        public String getServiceSiteCode() {
            return this.serviceSiteCode;
        }
        
        public Object getShelfName() {
            return this.shelfName;
        }
        
        public Object getShelfNumber() {
            return this.shelfNumber;
        }
        
        public String getSpCode() {
            return this.spCode;
        }
        
        public Object getStatusCode() {
            return this.statusCode;
        }
        
        public Object getTemplateId() {
            return this.templateId;
        }
        
        public Object getTemplateName() {
            return this.templateName;
        }
        
        public Object getTemplateType() {
            return this.templateType;
        }
        
        public Object getVirtualBill() {
            return this.virtualBill;
        }
        
        public Object getVirtualCallInfo() {
            return this.virtualCallInfo;
        }
        
        public Object getVirtualNumber() {
            return this.virtualNumber;
        }
        
        public void setAgencySign(final Object agencySign) {
            this.agencySign = agencySign;
        }
        
        public void setBeforeCallInfo(final Object beforeCallInfo) {
            this.beforeCallInfo = beforeCallInfo;
        }
        
        public void setBillCode(final String billCode) {
            this.billCode = billCode;
        }
        
        public void setCancelSign(final Object cancelSign) {
            this.cancelSign = cancelSign;
        }
        
        public void setExpressCode(final Object expressCode) {
            this.expressCode = expressCode;
        }
        
        public void setExpressCompanyCode(final String expressCompanyCode) {
            this.expressCompanyCode = expressCompanyCode;
        }
        
        public void setExpressCompanyName(final String expressCompanyName) {
            this.expressCompanyName = expressCompanyName;
        }
        
        public void setExpressName(final Object expressName) {
            this.expressName = expressName;
        }
        
        public void setGoodsNumber(final String goodsNumber) {
            this.goodsNumber = goodsNumber;
        }
        
        public void setGoodsStatusCode(final String goodsStatusCode) {
            this.goodsStatusCode = goodsStatusCode;
        }
        
        public void setInstorageDays(final int instorageDays) {
            this.instorageDays = instorageDays;
        }
        
        public void setInstorageTime(final long instorageTime) {
            this.instorageTime = instorageTime;
        }
        
        public void setIsProblem(final Object isProblem) {
            this.isProblem = isProblem;
        }
        
        public void setLastUpdateTime(final long lastUpdateTime) {
            this.lastUpdateTime = lastUpdateTime;
        }
        
        public void setMessageList(final Object messageList) {
            this.messageList = messageList;
        }
        
        public void setMessageResult(final int messageResult) {
            this.messageResult = messageResult;
        }
        
        public void setMessageType(final Object messageType) {
            this.messageType = messageType;
        }
        
        public void setOriPhotoSize(final Object oriPhotoSize) {
            this.oriPhotoSize = oriPhotoSize;
        }
        
        public void setOriPickupPhoto(final Object oriPickupPhoto) {
            this.oriPickupPhoto = oriPickupPhoto;
        }
        
        public void setPickupPhoto(final Object pickupPhoto) {
            this.pickupPhoto = pickupPhoto;
        }
        
        public void setPickupType(final Object pickupType) {
            this.pickupType = pickupType;
        }
        
        public void setPrecost(final Object precost) {
            this.precost = precost;
        }
        
        public void setProblem(final Object problem) {
            this.problem = problem;
        }
        
        public void setProblemType(final Object problemType) {
            this.problemType = problemType;
        }
        
        public void setReceiverName(final String receiverName) {
            this.receiverName = receiverName;
        }
        
        public void setReceiverPhone(final String receiverPhone) {
            this.receiverPhone = receiverPhone;
        }
        
        public void setRemark(final Object remark) {
            this.remark = remark;
        }
        
        public void setServiceSiteCode(final String serviceSiteCode) {
            this.serviceSiteCode = serviceSiteCode;
        }
        
        public void setShelfName(final Object shelfName) {
            this.shelfName = shelfName;
        }
        
        public void setShelfNumber(final Object shelfNumber) {
            this.shelfNumber = shelfNumber;
        }
        
        public void setSpCode(final String spCode) {
            this.spCode = spCode;
        }
        
        public void setStatusCode(final Object statusCode) {
            this.statusCode = statusCode;
        }
        
        public void setTemplateId(final Object templateId) {
            this.templateId = templateId;
        }
        
        public void setTemplateName(final Object templateName) {
            this.templateName = templateName;
        }
        
        public void setTemplateType(final Object templateType) {
            this.templateType = templateType;
        }
        
        public void setVirtualBill(final Object virtualBill) {
            this.virtualBill = virtualBill;
        }
        
        public void setVirtualCallInfo(final Object virtualCallInfo) {
            this.virtualCallInfo = virtualCallInfo;
        }
        
        public void setVirtualNumber(final Object virtualNumber) {
            this.virtualNumber = virtualNumber;
        }
    }
}
