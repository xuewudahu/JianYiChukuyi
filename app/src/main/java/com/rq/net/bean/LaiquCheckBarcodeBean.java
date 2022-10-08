package com.rq.net.bean;

public class LaiquCheckBarcodeBean
{
    private int page;
    private String queryInfo;
    private String queryType;
    private int rows;
    
    public LaiquCheckBarcodeBean() {
        this.page = 1;
        this.rows = 10;
    }
    
    public int getPage() {
        return this.page;
    }
    
    public String getQueryInfo() {
        return this.queryInfo;
    }
    
    public String getQueryType() {
        return this.queryType;
    }
    
    public int getRows() {
        return this.rows;
    }
    
    public void setPage(final int page) {
        this.page = page;
    }
    
    public void setQueryInfo(final String queryInfo) {
        this.queryInfo = queryInfo;
    }
    
    public void setQueryType(final String queryType) {
        this.queryType = queryType;
    }
    
    public void setRows(final int rows) {
        this.rows = rows;
    }
}
