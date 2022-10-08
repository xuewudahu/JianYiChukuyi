package com.rq.net.bean;

import java.util.*;

public class SendInformationBean
{
    private int count;
    private List<SendInformationTableBean> results;
    
    public int getCount() {
        return this.count;
    }
    
    public List<SendInformationTableBean> getResults() {
        return this.results;
    }
    
    public void setCount(final int count) {
        this.count = count;
    }
    
    public void setResults(final List<SendInformationTableBean> results) {
        this.results = results;
    }
}
