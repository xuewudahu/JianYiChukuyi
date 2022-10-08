package com.rq.net.bean;

public class jinLinBaoOcrJieBoPreeAddResponseBean
{
    private BodyBean body;
    private int code;
    private String msg;
    
    public BodyBean getBody() {
        return this.body;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setBody(final BodyBean body) {
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
        private int next_seq_no;
        
        public String getBatch_date() {
            return this.batch_date;
        }
        
        public int getNext_seq_no() {
            return this.next_seq_no;
        }
        
        public void setBatch_date(final String batch_date) {
            this.batch_date = batch_date;
        }
        
        public void setNext_seq_no(final int next_seq_no) {
            this.next_seq_no = next_seq_no;
        }
    }
}
