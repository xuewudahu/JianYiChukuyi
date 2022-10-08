package com.rq.net.bean;

public class PandaHarvestRequestBean
{
    private String accountName;
    private String apiName;
    private String bizData;
    private String clientCode;
    private String sign;
    private String timestamp;
    
    public String getAccountName() {
        return this.accountName;
    }
    
    public String getApiName() {
        return this.apiName;
    }
    
    public String getBizData() {
        return this.bizData;
    }
    
    public String getClientCode() {
        return this.clientCode;
    }
    
    public String getSign() {
        return this.sign;
    }
    
    public String getTimestamp() {
        return this.timestamp;
    }
    
    public void setAccountName(final String accountName) {
        this.accountName = accountName;
    }
    
    public void setApiName(final String apiName) {
        this.apiName = apiName;
    }
    
    public void setBizData(final String bizData) {
        this.bizData = bizData;
    }
    
    public void setClientCode(final String clientCode) {
        this.clientCode = clientCode;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PandaHarvestRequestBean{clientCode='");
        sb.append(this.clientCode);
        sb.append('\'');
        sb.append(", bizData='");
        sb.append(this.bizData);
        sb.append('\'');
        sb.append(", timestamp='");
        sb.append(this.timestamp);
        sb.append('\'');
        sb.append(", accountName='");
        sb.append(this.accountName);
        sb.append('\'');
        sb.append(", apiName='");
        sb.append(this.apiName);
        sb.append('\'');
        sb.append(", sign='");
        sb.append(this.sign);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
