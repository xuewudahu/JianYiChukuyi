package com.rq.net.bean;

import java.util.*;

public class CompanyListBean
{
    private int code;
    private DataBean data;
    private String message;
    
    public int getCode() {
        return this.code;
    }
    
    public DataBean getData() {
        return this.data;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setData(final DataBean data) {
        this.data = data;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public class DataBean
    {
        private List<NameAndEid> list;
        
        public List<NameAndEid> getList() {
            return this.list;
        }
        
        public void setList(final List<NameAndEid> list) {
            this.list = list;
        }
    }
    
    public class NameAndEid
    {
        private String eid;
        private String name;
        
        public String getEid() {
            return this.eid;
        }
        
        public String getName() {
            return this.name;
        }
        
        public void setEid(final String eid) {
            this.eid = eid;
        }
        
        public void setName(final String name) {
            this.name = name;
        }
    }
}
