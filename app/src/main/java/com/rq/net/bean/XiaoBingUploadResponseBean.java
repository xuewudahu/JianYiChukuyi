package com.rq.net.bean;

public class XiaoBingUploadResponseBean
{
    private boolean code;
    private Object data;
    private String msg;
    
    public Object getData() {
        return this.data;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public boolean isCode() {
        return this.code;
    }
    
    public void setCode(final boolean code) {
        this.code = code;
    }
    
    public void setData(final Object data) {
        this.data = data;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public static class DataBean
    {
        private int floor;
        private String frame_code;
        private String number;
        private String rec_mobile;
        private String recipient_no;
        private String tail_no;
        private String take_code;
        private String take_code_final;
        
        public int getFloor() {
            return this.floor;
        }
        
        public String getFrame_code() {
            return this.frame_code;
        }
        
        public String getNumber() {
            return this.number;
        }
        
        public String getRec_mobile() {
            return this.rec_mobile;
        }
        
        public String getRecipient_no() {
            return this.recipient_no;
        }
        
        public String getTail_no() {
            return this.tail_no;
        }
        
        public String getTake_code() {
            return this.take_code;
        }
        
        public String getTake_code_final() {
            return this.take_code_final;
        }
        
        public void setFloor(final int floor) {
            this.floor = floor;
        }
        
        public void setFrame_code(final String frame_code) {
            this.frame_code = frame_code;
        }
        
        public void setNumber(final String number) {
            this.number = number;
        }
        
        public void setRec_mobile(final String rec_mobile) {
            this.rec_mobile = rec_mobile;
        }
        
        public void setRecipient_no(final String recipient_no) {
            this.recipient_no = recipient_no;
        }
        
        public void setTail_no(final String tail_no) {
            this.tail_no = tail_no;
        }
        
        public void setTake_code(final String take_code) {
            this.take_code = take_code;
        }
        
        public void setTake_code_final(final String take_code_final) {
            this.take_code_final = take_code_final;
        }
    }
}
