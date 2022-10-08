package com.rq.net.bean;

import java.util.*;

public class jinLinBaoPickupBatchPickupResponseBean
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
        private int code;
        private String desc;
        private String exp_code;
        private String status;
        
        public int getCode() {
            return this.code;
        }
        
        public String getDesc() {
            return this.desc;
        }
        
        public String getExp_code() {
            return this.exp_code;
        }
        
        public String getStatus() {
            return this.status;
        }
        
        public void setCode(final int code) {
            this.code = code;
        }
        
        public void setDesc(final String desc) {
            this.desc = desc;
        }
        
        public void setExp_code(final String exp_code) {
            this.exp_code = exp_code;
        }
        
        public void setStatus(final String status) {
            this.status = status;
        }
    }
}
