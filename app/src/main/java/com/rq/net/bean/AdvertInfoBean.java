package com.rq.net.bean;

public class AdvertInfoBean
{
    private int categoty;
    private String deadline;
    private String record_number;
    private int second;
    private String url;
    private int weight;
    
    public int getCategoty() {
        return this.categoty;
    }
    
    public String getDeadline() {
        return this.deadline;
    }
    
    public String getRecord_number() {
        return this.record_number;
    }
    
    public int getSecond() {
        return this.second;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public void setCategoty(final int categoty) {
        this.categoty = categoty;
    }
    
    public void setDeadline(final String deadline) {
        this.deadline = deadline;
    }
    
    public void setRecord_number(final String record_number) {
        this.record_number = record_number;
    }
    
    public void setSecond(final int second) {
        this.second = second;
    }
    
    public void setUrl(final String url) {
        this.url = url;
    }
    
    public void setWeight(final int weight) {
        this.weight = weight;
    }
}
