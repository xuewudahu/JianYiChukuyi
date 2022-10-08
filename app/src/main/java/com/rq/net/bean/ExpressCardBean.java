package com.rq.net.bean;

public class ExpressCardBean
{
    private int iconId;
    private String iconName;
    
    public ExpressCardBean(final String iconName, final int iconId) {
        this.setIconName(iconName);
        this.setIconId(iconId);
    }
    
    public int getIconId() {
        return this.iconId;
    }
    
    public String getIconName() {
        return this.iconName;
    }
    
    public void setIconId(final int iconId) {
        this.iconId = iconId;
    }
    
    public void setIconName(final String iconName) {
        this.iconName = iconName;
    }
}
