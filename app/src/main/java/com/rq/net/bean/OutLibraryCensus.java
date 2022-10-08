package com.rq.net.bean;

import java.util.*;

public class OutLibraryCensus
{
    private String count_date;
    private List<DataBean> sd;
    private String sign;
    private String sn;
    private String timestamp;
    
    public String getCount_date() {
        return this.count_date;
    }
    
    public List<DataBean> getSd() {
        return this.sd;
    }
    
    public String getSign() {
        return this.sign;
    }
    
    public String getSn() {
        return this.sn;
    }
    
    public String getTimestamp() {
        return this.timestamp;
    }
    
    public void setCount_date(final String count_date) {
        this.count_date = count_date;
    }
    
    public void setSd(final List<DataBean> sd) {
        this.sd = sd;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setSn(final String sn) {
        this.sn = sn;
    }
    
    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }
    
    public class DataBean
    {
        private int counts;
        private String station_code;
        
        public int getCounts() {
            return this.counts;
        }
        
        public String getStation_code() {
            return this.station_code;
        }
        
        public void setCounts(final int counts) {
            this.counts = counts;
        }
        
        public void setStation_code(final String station_code) {
            this.station_code = station_code;
        }
    }
}
