package com.rq.net.bean;

import java.util.*;

public class BlueShopLoginRequestBean
{
    private DataRow row;
    private int status;
    
    public DataRow getRow() {
        return this.row;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public void setRow(final DataRow row) {
        this.row = row;
    }
    
    public void setStatus(final int status) {
        this.status = status;
    }
    
    public class DataRow
    {
        private List<Integer> tags;
        
        public List<Integer> getTags() {
            return this.tags;
        }
        
        public void setTags(final List<Integer> tags) {
            this.tags = tags;
        }
    }
}
