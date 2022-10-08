package com.rq.net.bean;

public class XingHuoResponse
{
    private String cookie;
    private int errorCode;
    private String errorMsg;
    private ResultBean result;
    private String state;
    private int status;
    private boolean success;
    
    public String getCookie() {
        return this.cookie;
    }
    
    public int getErrorCode() {
        return this.errorCode;
    }
    
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
    
    public void setCookie(final String cookie) {
        this.cookie = cookie;
    }
    
    public void setErrorCode(final int errorCode) {
        this.errorCode = errorCode;
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
        private String transfer;
        
        public String getTransfer() {
            return this.transfer;
        }
        
        public void setTransfer(final String transfer) {
            this.transfer = transfer;
        }
    }
}
