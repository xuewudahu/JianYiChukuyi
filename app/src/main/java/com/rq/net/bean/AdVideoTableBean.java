package com.rq.net.bean;

import org.litepal.crud.*;
import org.litepal.annotation.*;

public class AdVideoTableBean/* extends DataSupport*/
{
    @Column(defaultValue = "unknown", unique = true)
    private String imagUrl;
    private String localImagePath;
    private String ossImageUrl;
    
    public AdVideoTableBean(final String imagUrl, final String ossImageUrl, final String localImagePath) {
        this.imagUrl = imagUrl;
        this.ossImageUrl = ossImageUrl;
        this.localImagePath = localImagePath;
    }
    
    public String getImagUrl() {
        return this.imagUrl;
    }
    
    public String getLocalImagePath() {
        return this.localImagePath;
    }
    
    public String getOssImageUrl() {
        return this.ossImageUrl;
    }
    
    public void setImagUrl(final String imagUrl) {
        this.imagUrl = imagUrl;
    }
    
    public void setLocalImagePath(final String localImagePath) {
        this.localImagePath = localImagePath;
    }
    
    public void setOssImageUrl(final String ossImageUrl) {
        this.ossImageUrl = ossImageUrl;
    }
}
