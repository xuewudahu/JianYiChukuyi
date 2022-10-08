package com.rq.net.bean;

import java.util.*;

public class LaiquCheckBarcodeResponseBean
{
    private int page;
    private int pageSize;
    private int records;
    private List<RowsBean> rows;
    private Object searchId;
    private Object sortCriterion;
    private int total;
    
    public int getPage() {
        return this.page;
    }
    
    public int getPageSize() {
        return this.pageSize;
    }
    
    public int getRecords() {
        return this.records;
    }
    
    public List<RowsBean> getRows() {
        return this.rows;
    }
    
    public Object getSearchId() {
        return this.searchId;
    }
    
    public Object getSortCriterion() {
        return this.sortCriterion;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setPage(final int page) {
        this.page = page;
    }
    
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }
    
    public void setRecords(final int records) {
        this.records = records;
    }
    
    public void setRows(final List<RowsBean> rows) {
        this.rows = rows;
    }
    
    public void setSearchId(final Object searchId) {
        this.searchId = searchId;
    }
    
    public void setSortCriterion(final Object sortCriterion) {
        this.sortCriterion = sortCriterion;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
    
    public static class RowsBean
    {
        private boolean agencySign;
        private Object beforeCallInfo;
        private String billCode;
        private boolean cancelSign;
        private String expressCode;
        private String expressCompanyCode;
        private String expressCompanyName;
        private String expressName;
        private String goodsNumber;
        private String goodsStatusCode;
        private int instorageDays;
        private long instorageTime;
        private Object isProblem;
        private long lastUpdateTime;
        private List<MessageListBean> messageList;
        private int messageResult;
        private String messageType;
        private Object oriPhotoSize;
        private Object oriPickupPhoto;
        private Object pickupPhoto;
        private Object pickupType;
        private int precost;
        private Object problem;
        private Object problemType;
        private String receiverName;
        private String receiverPhone;
        private Object remark;
        private String serviceSiteCode;
        private String shelfName;
        private String shelfNumber;
        private String spCode;
        private Object statusCode;
        private Object templateId;
        private Object templateName;
        private Object templateType;
        private int virtualBill;
        private Object virtualCallInfo;
        private Object virtualNumber;
        
        public Object getBeforeCallInfo() {
            return this.beforeCallInfo;
        }
        
        public String getBillCode() {
            return this.billCode;
        }
        
        public String getExpressCode() {
            return this.expressCode;
        }
        
        public String getExpressCompanyCode() {
            return this.expressCompanyCode;
        }
        
        public String getExpressCompanyName() {
            return this.expressCompanyName;
        }
        
        public String getExpressName() {
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
        
        public List<MessageListBean> getMessageList() {
            return this.messageList;
        }
        
        public int getMessageResult() {
            return this.messageResult;
        }
        
        public String getMessageType() {
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
        
        public int getPrecost() {
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
        
        public String getShelfName() {
            return this.shelfName;
        }
        
        public String getShelfNumber() {
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
        
        public int getVirtualBill() {
            return this.virtualBill;
        }
        
        public Object getVirtualCallInfo() {
            return this.virtualCallInfo;
        }
        
        public Object getVirtualNumber() {
            return this.virtualNumber;
        }
        
        public boolean isAgencySign() {
            return this.agencySign;
        }
        
        public boolean isCancelSign() {
            return this.cancelSign;
        }
        
        public void setAgencySign(final boolean agencySign) {
            this.agencySign = agencySign;
        }
        
        public void setBeforeCallInfo(final Object beforeCallInfo) {
            this.beforeCallInfo = beforeCallInfo;
        }
        
        public void setBillCode(final String billCode) {
            this.billCode = billCode;
        }
        
        public void setCancelSign(final boolean cancelSign) {
            this.cancelSign = cancelSign;
        }
        
        public void setExpressCode(final String expressCode) {
            this.expressCode = expressCode;
        }
        
        public void setExpressCompanyCode(final String expressCompanyCode) {
            this.expressCompanyCode = expressCompanyCode;
        }
        
        public void setExpressCompanyName(final String expressCompanyName) {
            this.expressCompanyName = expressCompanyName;
        }
        
        public void setExpressName(final String expressName) {
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
        
        public void setMessageList(final List<MessageListBean> messageList) {
            this.messageList = messageList;
        }
        
        public void setMessageResult(final int messageResult) {
            this.messageResult = messageResult;
        }
        
        public void setMessageType(final String messageType) {
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
        
        public void setPrecost(final int precost) {
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
        
        public void setShelfName(final String shelfName) {
            this.shelfName = shelfName;
        }
        
        public void setShelfNumber(final String shelfNumber) {
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
        
        public void setVirtualBill(final int virtualBill) {
            this.virtualBill = virtualBill;
        }
        
        public void setVirtualCallInfo(final Object virtualCallInfo) {
            this.virtualCallInfo = virtualCallInfo;
        }
        
        public void setVirtualNumber(final Object virtualNumber) {
            this.virtualNumber = virtualNumber;
        }
        
        public static class MessageListBean
        {
            private String content;
            private int result;
            private String type;
            
            public String getContent() {
                return this.content;
            }
            
            public int getResult() {
                return this.result;
            }
            
            public String getType() {
                return this.type;
            }
            
            public void setContent(final String content) {
                this.content = content;
            }
            
            public void setResult(final int result) {
                this.result = result;
            }
            
            public void setType(final String type) {
                this.type = type;
            }
        }
    }
}
