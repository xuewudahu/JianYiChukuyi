package com.rq.net.bean;

import java.util.*;

public class SiteListBean
{
    private int count;
    private List<SiteInformation> results;
    
    public int getCount() {
        return this.count;
    }
    
    public List<SiteInformation> getResults() {
        return this.results;
    }
    
    public void setCount(final int count) {
        this.count = count;
    }
    
    public void setResults(final List<SiteInformation> results) {
        this.results = results;
    }
    
    public class SiteInformation
    {
        private String contact_name;
        private int id;
        private String name;
        
        public String getContact_name() {
            return this.contact_name;
        }
        
        public int getId() {
            return this.id;
        }
        
        public String getName() {
            return this.name;
        }
        
        public void setContact_name(final String contact_name) {
            this.contact_name = contact_name;
        }
        
        public void setId(final int id) {
            this.id = id;
        }
        
        public void setName(final String name) {
            this.name = name;
        }
    }
}
