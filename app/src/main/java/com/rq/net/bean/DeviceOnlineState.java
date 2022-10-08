package com.rq.net.bean;

import java.util.*;

public class DeviceOnlineState
{
    private List<InformationBean> fd;
    private String ft;
    private String fz;
    private String inip;
    private int is_first;
    private String sign;
    private String sn;
    private String timestamp;
    private String vs;
    
    public DeviceOnlineState() {
        this.fz = "0";
        this.fd = new ArrayList<InformationBean>();
        this.is_first = 1;
    }
    
    public List<InformationBean> getFd() {
        return this.fd;
    }
    
    public String getFt() {
        return this.ft;
    }
    
    public String getFz() {
        return this.fz;
    }
    
    public String getInip() {
        return this.inip;
    }
    
    public int getIs_first() {
        return this.is_first;
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
    
    public String getVs() {
        return this.vs;
    }
    
    public void setFd(final List<InformationBean> fd) {
        this.fd = fd;
    }
    
    public void setFt(final String ft) {
        this.ft = ft;
    }
    
    public void setFz(final String fz) {
        this.fz = fz;
    }
    
    public void setInip(final String inip) {
        this.inip = inip;
    }
    
    public void setIs_first(final int is_first) {
        this.is_first = is_first;
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
    
    public void setVs(final String vs) {
        this.vs = vs;
    }
    
    public static class InformationBean
    {
        private String barcode;
        private String express;
        private String picture;
        private String remark;
        private String scan_date;
        private int size;
        private String station;
        private String volume;
        private int weight;
        
        public InformationBean() {
            this.express = "";
            this.station = "";
            this.barcode = "";
            this.picture = "";
            this.size = 0;
            this.remark = "";
            this.weight = 0;
            this.volume = "";
            this.scan_date = "";
        }
        
        public String getBarcode() {
            return this.barcode;
        }
        
        public String getExpress() {
            return this.express;
        }
        
        public String getPicture() {
            return this.picture;
        }
        
        public String getRemark() {
            return this.remark;
        }
        
        public String getScan_date() {
            return this.scan_date;
        }
        
        public int getSize() {
            return this.size;
        }
        
        public String getStation() {
            return this.station;
        }
        
        public String getVolume() {
            return this.volume;
        }
        
        public int getWeight() {
            return this.weight;
        }
        
        public void setBarcode(final String barcode) {
            this.barcode = barcode;
        }
        
        public void setExpress(final String express) {
            this.express = express;
        }
        
        public void setPicture(final String picture) {
            this.picture = picture;
        }
        
        public void setRemark(final String remark) {
            this.remark = remark;
        }
        
        public void setScan_date(final String scan_date) {
            this.scan_date = scan_date;
        }
        
        public void setSize(final int size) {
            this.size = size;
        }
        
        public void setStation(final String station) {
            this.station = station;
        }
        
        public void setVolume(final String volume) {
            this.volume = volume;
        }
        
        public void setWeight(final int weight) {
            this.weight = weight;
        }
    }
}
