package com.rq.net.bean;

import java.util.*;

public class JinLinBaoJieBoBatchListResponseBean
{
    private List<BodyBean> body;
    private int code;
    private String msg;
    
    public List<BodyBean> getBody() {
        return this.body;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setBody(final List<BodyBean> body) {
        this.body = body;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public static class BodyBean
    {
        private String batch_date;
        private int exp_count;
        private long id;
        private int scan_count;
        private int seq_no;
        private int total_size;
        
        public String getBatch_date() {
            return this.batch_date;
        }
        
        public int getExp_count() {
            return this.exp_count;
        }
        
        public long getId() {
            return this.id;
        }
        
        public int getScan_count() {
            return this.scan_count;
        }
        
        public int getSeq_no() {
            return this.seq_no;
        }
        
        public int getTotal_size() {
            return this.total_size;
        }
        
        public void setBatch_date(final String batch_date) {
            this.batch_date = batch_date;
        }
        
        public void setExp_count(final int exp_count) {
            this.exp_count = exp_count;
        }
        
        public void setId(final long id) {
            this.id = id;
        }
        
        public void setScan_count(final int scan_count) {
            this.scan_count = scan_count;
        }
        
        public void setSeq_no(final int seq_no) {
            this.seq_no = seq_no;
        }
        
        public void setTotal_size(final int total_size) {
            this.total_size = total_size;
        }
    }
}
