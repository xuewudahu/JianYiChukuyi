package com.rq.net.bean;

public class MaMaNoOutLibraryDataBean
{
    private String ifSign;
    private String pageIndex;
    private String pageSize;
    private String searchType;
    private String searchValue;
    
    public MaMaNoOutLibraryDataBean() {
        this.pageSize = "15";
        this.ifSign = "0";
        this.searchType = "";
        this.searchValue = "6004";
        this.pageIndex = "0";
    }
    
    public String getIfSign() {
        return this.ifSign;
    }
    
    public String getPageIndex() {
        return this.pageIndex;
    }
    
    public String getPageSize() {
        return this.pageSize;
    }
    
    public String getSearchType() {
        return this.searchType;
    }
    
    public String getSearchValue() {
        return this.searchValue;
    }
    
    public void setIfSign(final String ifSign) {
        this.ifSign = ifSign;
    }
    
    public void setPageIndex(final String pageIndex) {
        this.pageIndex = pageIndex;
    }
    
    public void setPageSize(final String pageSize) {
        this.pageSize = pageSize;
    }
    
    public void setSearchType(final String searchType) {
        this.searchType = searchType;
    }
    
    public void setSearchValue(final String searchValue) {
        this.searchValue = searchValue;
    }
}
