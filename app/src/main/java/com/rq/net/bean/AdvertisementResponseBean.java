package com.rq.net.bean;

public class AdvertisementResponseBean
{
    private String image_url;
    private int sort;
    private int source;
    private int type;
    private String update_date;
    
    public String getImage_url() {
        return this.image_url;
    }
    
    public int getSort() {
        return this.sort;
    }
    
    public int getSource() {
        return this.source;
    }
    
    public int getType() {
        return this.type;
    }
    
    public String getUpdate_date() {
        return this.update_date;
    }
    
    public void setImage_url(final String image_url) {
        this.image_url = image_url;
    }
    
    public void setSort(final int sort) {
        this.sort = sort;
    }
    
    public void setSource(final int source) {
        this.source = source;
    }
    
    public void setType(final int type) {
        this.type = type;
    }
    
    public void setUpdate_date(final String update_date) {
        this.update_date = update_date;
    }
}
