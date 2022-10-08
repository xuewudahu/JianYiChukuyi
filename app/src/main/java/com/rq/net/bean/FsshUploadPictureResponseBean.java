package com.rq.net.bean;

public class FsshUploadPictureResponseBean
{
    private int RecordCount;
    private String ResultValue;
    private boolean Status;
    private String StatusCode;
    private String StatusMessage;
    
    public int getRecordCount() {
        return this.RecordCount;
    }
    
    public String getResultValue() {
        return this.ResultValue;
    }
    
    public String getStatusCode() {
        return this.StatusCode;
    }
    
    public String getStatusMessage() {
        return this.StatusMessage;
    }
    
    public boolean isStatus() {
        return this.Status;
    }
    
    public void setRecordCount(final int recordCount) {
        this.RecordCount = recordCount;
    }
    
    public void setResultValue(final String resultValue) {
        this.ResultValue = resultValue;
    }
    
    public void setStatus(final boolean status) {
        this.Status = status;
    }
    
    public void setStatusCode(final String statusCode) {
        this.StatusCode = statusCode;
    }
    
    public void setStatusMessage(final String statusMessage) {
        this.StatusMessage = statusMessage;
    }
}
