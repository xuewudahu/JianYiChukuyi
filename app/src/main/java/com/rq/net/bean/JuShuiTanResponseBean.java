package com.rq.net.bean;

import java.util.*;

public class JuShuiTanResponseBean
{
    private int code;
    private List<DataBean> datas;
    private boolean issuccess;
    private String msg;
    
    public JuShuiTanResponseBean() {
        this.datas = null;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public List<DataBean> getDatas() {
        return this.datas;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public boolean isIssuccess() {
        return this.issuccess;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setDatas(final List<DataBean> datas) {
        this.datas = datas;
    }
    
    public void setIssuccess(final boolean issuccess) {
        this.issuccess = issuccess;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public class DataBean
    {
        private boolean is_success;
        private String l_id;
        private String lc_id;
        private String logistics_company;
        private String msg;
        private String receiver_city;
        private String receiver_district;
        private String receiver_state;
        private float weight;
        
        public String getL_id() {
            return this.l_id;
        }
        
        public String getLc_id() {
            return this.lc_id;
        }
        
        public String getLogistics_company() {
            return this.logistics_company;
        }
        
        public String getMsg() {
            return this.msg;
        }
        
        public String getReceiver_city() {
            return this.receiver_city;
        }
        
        public String getReceiver_district() {
            return this.receiver_district;
        }
        
        public String getReceiver_state() {
            return this.receiver_state;
        }
        
        public float getWeight() {
            return this.weight;
        }
        
        public boolean isIs_success() {
            return this.is_success;
        }
        
        public void setIs_success(final boolean is_success) {
            this.is_success = is_success;
        }
        
        public void setL_id(final String l_id) {
            this.l_id = l_id;
        }
        
        public void setLc_id(final String lc_id) {
            this.lc_id = lc_id;
        }
        
        public void setLogistics_company(final String logistics_company) {
            this.logistics_company = logistics_company;
        }
        
        public void setMsg(final String msg) {
            this.msg = msg;
        }
        
        public void setReceiver_city(final String receiver_city) {
            this.receiver_city = receiver_city;
        }
        
        public void setReceiver_district(final String receiver_district) {
            this.receiver_district = receiver_district;
        }
        
        public void setReceiver_state(final String receiver_state) {
            this.receiver_state = receiver_state;
        }
        
        public void setWeight(final float weight) {
            this.weight = weight;
        }
    }
}
