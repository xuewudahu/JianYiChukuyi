package com.rq.net.bean;

import java.util.*;

public class FsshOutLibraryResponseBean
{
    private List<DataBean> Data;
    private int RecordCount;
    private String ResultValue;
    private boolean Status;
    private String StatusCode;
    private String StatusMessage;
    
    public List<DataBean> getData() {
        return this.Data;
    }
    
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
    
    public void setData(final List<DataBean> data) {
        this.Data = data;
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
    
    public static class DataBean
    {
        private String BillCode;
        private String GoodCodes;
        
        public String getBillCode() {
            return this.BillCode;
        }
        
        public String getGoodCodes() {
            return this.GoodCodes;
        }
        
        public void setBillCode(final String billCode) {
            this.BillCode = billCode;
        }
        
        public void setGoodCodes(final String goodCodes) {
            this.GoodCodes = goodCodes;
        }
    }
}
