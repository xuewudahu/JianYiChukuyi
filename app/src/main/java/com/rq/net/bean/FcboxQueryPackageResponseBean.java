package com.rq.net.bean;

public class FcboxQueryPackageResponseBean
{
    private int pageNo;
    private int pageSize;
    private Object result;
    private int totalCount;
    
    public int getPageNo() {
        return this.pageNo;
    }
    
    public int getPageSize() {
        return this.pageSize;
    }
    
    public Object getResult() {
        return this.result;
    }
    
    public int getTotalCount() {
        return this.totalCount;
    }
    
    public void setPageNo(final int pageNo) {
        this.pageNo = pageNo;
    }
    
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }
    
    public void setResult(final Object result) {
        this.result = result;
    }
    
    public void setTotalCount(final int totalCount) {
        this.totalCount = totalCount;
    }
}
