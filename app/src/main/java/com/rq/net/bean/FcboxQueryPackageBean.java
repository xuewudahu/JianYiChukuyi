package com.rq.net.bean;

public class FcboxQueryPackageBean
{
    private String pageNo;
    private String pageSize;
    private String receiverMobile;
    private int timeRangeType;
    
    public String getPageNo() {
        return this.pageNo;
    }
    
    public String getPageSize() {
        return this.pageSize;
    }
    
    public String getReceiverMobile() {
        return this.receiverMobile;
    }
    
    public int getTimeRangeType() {
        return this.timeRangeType;
    }
    
    public void setPageNo(final String pageNo) {
        this.pageNo = pageNo;
    }
    
    public void setPageSize(final String pageSize) {
        this.pageSize = pageSize;
    }
    
    public void setReceiverMobile(final String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }
    
    public void setTimeRangeType(final int timeRangeType) {
        this.timeRangeType = timeRangeType;
    }
}
