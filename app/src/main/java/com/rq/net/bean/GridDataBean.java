package com.rq.net.bean;

public class GridDataBean
{
    private String imagePath;
    private String name;
    
    public GridDataBean(final String name, final String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }
    
    public String getImagePath() {
        return this.imagePath;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setImagePath(final String imagePath) {
        this.imagePath = imagePath;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
}
