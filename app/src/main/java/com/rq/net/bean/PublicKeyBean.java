package com.rq.net.bean;

public class PublicKeyBean
{
    private String cookie;
    private String errorMsg;
    private ResultBean result;
    private String state;
    private int status;
    private boolean success;
    
    public String getCookie() {
        return this.cookie;
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
        private String publicKey;
        
        public String getPublicKey() {
            return this.publicKey;
        }
        
        public void setPublicKey(final String publicKey) {
            this.publicKey = publicKey;
        }
    }
}
