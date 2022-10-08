package com.rq.net.bean;

public class JackYunPictureBean
{
    private String logisticNo;
    private String picFile;
    
    public JackYunPictureBean(final String logisticNo, final String picFile) {
        this.logisticNo = logisticNo;
        this.picFile = picFile;
    }
    
    public String getLogisticNo() {
        return this.logisticNo;
    }
    
    public String getPicFile() {
        return this.picFile;
    }
    
    public void setLogisticNo(final String logisticNo) {
        this.logisticNo = logisticNo;
    }
    
    public void setPicFile(final String picFile) {
        this.picFile = picFile;
    }
}
