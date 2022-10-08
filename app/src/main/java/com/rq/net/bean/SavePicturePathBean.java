package com.rq.net.bean;

public class SavePicturePathBean
{
    private String dirName;
    private String dirTitle;
    
    public SavePicturePathBean(final String dirName, final String dirTitle) {
        this.dirName = dirName;
        this.dirTitle = dirTitle;
    }
    
    public String getDirName() {
        return this.dirName;
    }
    
    public String getDirTitle() {
        return this.dirTitle;
    }
    
    public void setDirName(final String dirName) {
        this.dirName = dirName;
    }
    
    public void setDirTitle(final String dirTitle) {
        this.dirTitle = dirTitle;
    }
}
