package com.rq.net.bean;

public class GetSoftUpdateVersionBean
{
    private String icon;
    private String link;
    private boolean must_upgrade;
    private String name;
    private String update_info;
    private String version;
    
    public String getIcon() {
        return this.icon;
    }
    
    public String getLink() {
        return this.link;
    }
    
    public boolean getMust_upgrade() {
        return this.must_upgrade;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getUpdate_info() {
        return this.update_info;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public void setIcon(final String icon) {
        this.icon = icon;
    }
    
    public void setLink(final String link) {
        this.link = link;
    }
    
    public void setMust_upgrade(final boolean must_upgrade) {
        this.must_upgrade = must_upgrade;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setUpdate_info(final String update_info) {
        this.update_info = update_info;
    }
    
    public void setVersion(final String version) {
        this.version = version;
    }
}
