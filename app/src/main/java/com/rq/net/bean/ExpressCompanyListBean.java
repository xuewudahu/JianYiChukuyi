package com.rq.net.bean;

import java.util.*;

public class ExpressCompanyListBean
{
    private int count;
    private List<ExpressCompany> results;
    
    public int getCount() {
        return this.count;
    }
    
    public List<ExpressCompany> getResults() {
        return this.results;
    }
    
    public void setCount(final int count) {
        this.count = count;
    }
    
    public void setResults(final List<ExpressCompany> results) {
        this.results = results;
    }
    
    public static class ExpressCompany
    {
        private int id;
        private String img_url;
        private String name;
        
        public int getId() {
            return this.id;
        }
        
        public String getImg_url() {
            return this.img_url;
        }
        
        public String getName() {
            return this.name;
        }
        
        public void setId(final int id) {
            this.id = id;
        }
        
        public void setImg_url(final String img_url) {
            this.img_url = img_url;
        }
        
        public void setName(final String name) {
            this.name = name;
        }
    }
}
