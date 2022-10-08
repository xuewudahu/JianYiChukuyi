package com.rq.net.bean;

public class BizDataBean
{
    private String mailNo;
    
    public String getMailNo() {
        return this.mailNo;
    }
    
    public void setMailNo(final String mailNo) {
        this.mailNo = mailNo;
    }
    
    @Override
    public String toString() {
        return "{\"mailNo\":\"ma\"}";
    }
}
