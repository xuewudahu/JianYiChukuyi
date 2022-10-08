package com.rq.net.bean;

import java.util.*;

public class StationHelperRequestLoginBean
{
    private String Authorication;
    private String errMsg;
    private List<StrMap> extraParams;
    private String phoneNum;
    private int retCode;
    private String token;
    private String userId;
    
    public StationHelperRequestLoginBean() {
    }
    
    public StationHelperRequestLoginBean(final int retCode, final String errMsg, final String token, final String userId, final String phoneNum, final List<StrMap> extraParams) {
        this.retCode = retCode;
        this.errMsg = errMsg;
        this.token = token;
        this.userId = userId;
        this.phoneNum = phoneNum;
        this.extraParams = extraParams;
    }
    
    public String getAuthorication() {
        return this.Authorication;
    }
    
    public String getErrMsg() {
        return this.errMsg;
    }
    
    public List<StrMap> getExtraParams() {
        return this.extraParams;
    }
    
    public String getPhoneNum() {
        return this.phoneNum;
    }
    
    public int getRetCode() {
        return this.retCode;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public String getUserId() {
        return this.userId;
    }
    
    public void setAuthorication(final String authorication) {
        this.Authorication = authorication;
    }
    
    public void setErrMsg(final String errMsg) {
        this.errMsg = errMsg;
    }
    
    public void setExtraParams(final List<StrMap> extraParams) {
        this.extraParams = extraParams;
    }
    
    public void setPhoneNum(final String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public void setRetCode(final int retCode) {
        this.retCode = retCode;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }
    
    public void setUserId(final String userId) {
        this.userId = userId;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("StationHelperRequestLoginBean{retCode=");
        sb.append(this.retCode);
        sb.append(", errMsg='");
        sb.append(this.errMsg);
        sb.append('\'');
        sb.append(", token='");
        sb.append(this.token);
        sb.append('\'');
        sb.append(", userId='");
        sb.append(this.userId);
        sb.append('\'');
        sb.append(", phoneNum='");
        sb.append(this.phoneNum);
        sb.append('\'');
        sb.append(", Authorication='");
        sb.append(this.Authorication);
        sb.append('\'');
        sb.append(", extraParams=");
        sb.append(this.extraParams);
        sb.append('}');
        return sb.toString();
    }
    
    public static class StrMap
    {
        private String key;
        private String value;
        
        public String getKey() {
            return this.key;
        }
        
        public String getValue() {
            return this.value;
        }
        
        public void setKey(final String key) {
            this.key = key;
        }
        
        public void setValue(final String value) {
            this.value = value;
        }
    }
}
