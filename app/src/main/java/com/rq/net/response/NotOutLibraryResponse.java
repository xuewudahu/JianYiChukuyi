package com.kuaidihelp.posthouse.Response;

import java.util.*;

public class NotOutLibraryResponse
{
    private String errorMsg;
    private List<NotOuBean> result;
    private String state;
    private int status;
    private boolean success;
    
    public String getErrorMsg() {
        return this.errorMsg;
    }
    
    public List<NotOuBean> getResult() {
        return this.result;
    }
    
    public String getState() {
        return this.state;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public boolean isSuccess() {
        return this.success;
    }
    
    public void setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    public void setResult(final List<NotOuBean> result) {
        this.result = result;
    }
    
    public void setState(final String state) {
        this.state = state;
    }
    
    public void setStatus(final int status) {
        this.status = status;
    }
    
    public void setSuccess(final boolean success) {
        this.success = success;
    }
    
    public class NotOuBean
    {
        private String billCode;
        private String goodNum;
        private long instorageTime;
        private String shelfName;
        private String shelfNum;
        
        public String getBillCode() {
            return this.billCode;
        }
        
        public String getGoodNum() {
            return this.goodNum;
        }
        
        public long getInstorageTime() {
            return this.instorageTime;
        }
        
        public String getShelfName() {
            return this.shelfName;
        }
        
        public String getShelfNum() {
            return this.shelfNum;
        }
        
        public void setBillCode(final String billCode) {
            this.billCode = billCode;
        }
        
        public void setGoodNum(final String goodNum) {
            this.goodNum = goodNum;
        }
        
        public void setInstorageTime(final long instorageTime) {
            this.instorageTime = instorageTime;
        }
        
        public void setShelfName(final String shelfName) {
            this.shelfName = shelfName;
        }
        
        public void setShelfNum(final String shelfNum) {
            this.shelfNum = shelfNum;
        }
    }
}
