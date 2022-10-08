package com.rq.net.bean;

import java.util.*;

public class XingHuoOutLibraryReponse
{
    private String errorMsg;
    private ResultBean result;
    private String state;
    private int status;
    private boolean success;
    
    public String getErrorMsg() {
        return this.errorMsg;
    }
    
    public ResultBean getResult() {
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
    
    public void setResult(final ResultBean result) {
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
    
    public class ResultBean
    {
        private int resultCode;
        private String resultDesc;
        private int waitTakeCount;
        private List<Bills> waybills;
        
        public int getResultCode() {
            return this.resultCode;
        }
        
        public String getResultDesc() {
            return this.resultDesc;
        }
        
        public int getWaitTakeCount() {
            return this.waitTakeCount;
        }
        
        public List<Bills> getWaybills() {
            return this.waybills;
        }
        
        public void setResultCode(final int resultCode) {
            this.resultCode = resultCode;
        }
        
        public void setResultDesc(final String resultDesc) {
            this.resultDesc = resultDesc;
        }
        
        public void setWaitTakeCount(final int waitTakeCount) {
            this.waitTakeCount = waitTakeCount;
        }
        
        public void setWaybills(final List<Bills> waybills) {
            this.waybills = waybills;
        }
        
        public class Bills
        {
            private String receiverPhone;
            
            public String getReceiverPhone() {
                return this.receiverPhone;
            }
            
            public void setReceiverPhone(final String receiverPhone) {
                this.receiverPhone = receiverPhone;
            }
        }
    }
}
