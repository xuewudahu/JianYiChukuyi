package com.rq.net.bean;

import java.util.*;

public class jinLinBaoPickupUnPickupResponseBean
{
    private Body body;
    private int code;
    private String msg;
    
    public Body getBody() {
        return this.body;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setBody(final Body body) {
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
        private int count;
        private List<BarcodeInfo> list;
        
        public int getCount() {
            return this.count;
        }
        
        public List<BarcodeInfo> getList() {
            return this.list;
        }
        
        public void setCount(final int count) {
            this.count = count;
        }
        
        public void setList(final List<BarcodeInfo> list) {
            this.list = list;
        }
        
        public class BarcodeInfo
        {
            private String consignee_phone;
            private String create_time;
            private String exp_code;
            private int id;
            
            public String getConsignee_phone() {
                return this.consignee_phone;
            }
            
            public String getCreate_time() {
                return this.create_time;
            }
            
            public String getExp_code() {
                return this.exp_code;
            }
            
            public int getId() {
                return this.id;
            }
            
            public void setConsignee_phone(final String consignee_phone) {
                this.consignee_phone = consignee_phone;
            }
            
            public void setCreate_time(final String create_time) {
                this.create_time = create_time;
            }
            
            public void setExp_code(final String exp_code) {
                this.exp_code = exp_code;
            }
            
            public void setId(final int id) {
                this.id = id;
            }
        }
    }
}
