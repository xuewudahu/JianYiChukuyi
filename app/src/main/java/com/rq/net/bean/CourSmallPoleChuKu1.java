package com.rq.net.bean;

public class CourSmallPoleChuKu1
{
    private int code;
    private DataBean data;
    private String message;
    
    public int getCode() {
        return this.code;
    }
    
    public DataBean getData() {
        return this.data;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setData(final DataBean data) {
        this.data = data;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public class DataBean
    {
        private String eid;
        private String rid;
        private int type;
        
        public String getEid() {
            return this.eid;
        }
        
        public String getRid() {
            return this.rid;
        }
        
        public int getType() {
            return this.type;
        }
        
        public void setEid(final String eid) {
            this.eid = eid;
        }
        
        public void setRid(final String rid) {
            this.rid = rid;
        }
        
        public void setType(final int type) {
            this.type = type;
        }
    }
}
