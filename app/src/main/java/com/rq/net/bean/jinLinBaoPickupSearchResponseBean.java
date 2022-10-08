package com.rq.net.bean;

import java.util.*;

public class jinLinBaoPickupSearchResponseBean
{
    private List<Body> body;
    private int code;
    private String msg;
    
    public List<Body> getBody() {
        return this.body;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setBody(final List<Body> body) {
        this.body = body;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public class Body
    {
        private Charge_info charge_info;
        private long id;
        private String note;
        
        public Charge_info getCharge_info() {
            return this.charge_info;
        }
        
        public long getId() {
            return this.id;
        }
        
        public String getNote() {
            return this.note;
        }
        
        public void setCharge_info(final Charge_info charge_info) {
            this.charge_info = charge_info;
        }
        
        public void setId(final long id) {
            this.id = id;
        }
        
        public void setNote(final String note) {
            this.note = note;
        }
        
        public class Charge_info
        {
            private int amount;
            
            public int getAmount() {
                return this.amount;
            }
            
            public void setAmount(final int amount) {
                this.amount = amount;
            }
        }
    }
}
