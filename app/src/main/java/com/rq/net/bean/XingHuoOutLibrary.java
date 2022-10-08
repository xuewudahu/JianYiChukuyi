package com.rq.net.bean;

public class XingHuoOutLibrary
{
    private String content;
    private String pickupType;
    
    public XingHuoOutLibrary(final String pickupType, final String content) {
        this.pickupType = pickupType;
        this.content = content;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public String getPickupType() {
        return this.pickupType;
    }
    
    public void setContent(final String content) {
        this.content = content;
    }
    
    public void setPickupType(final String pickupType) {
        this.pickupType = pickupType;
    }
}
