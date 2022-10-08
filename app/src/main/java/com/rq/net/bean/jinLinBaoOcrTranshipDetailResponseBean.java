package com.rq.net.bean;

import java.util.*;

public class jinLinBaoOcrTranshipDetailResponseBean
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
        private boolean allow_phone_empty;
        private String batch_date;
        private long batch_id;
        private String consignee_phone;
        private long consignee_uid;
        private int express_id;
        private String express_name;
        private long id;
        private int logis_id;
        private int payment;
        private int problem_type;
        private int region_id;
        private int seq_no;
        private int status;
        
        public String getBatch_date() {
            return this.batch_date;
        }
        
        public long getBatch_id() {
            return this.batch_id;
        }
        
        public String getConsignee_phone() {
            return this.consignee_phone;
        }
        
        public long getConsignee_uid() {
            return this.consignee_uid;
        }
        
        public int getExpress_id() {
            return this.express_id;
        }
        
        public String getExpress_name() {
            return this.express_name;
        }
        
        public long getId() {
            return this.id;
        }
        
        public int getLogis_id() {
            return this.logis_id;
        }
        
        public int getPayment() {
            return this.payment;
        }
        
        public int getProblem_type() {
            return this.problem_type;
        }
        
        public int getRegion_id() {
            return this.region_id;
        }
        
        public int getSeq_no() {
            return this.seq_no;
        }
        
        public int getStatus() {
            return this.status;
        }
        
        public boolean isAllow_phone_empty() {
            return this.allow_phone_empty;
        }
        
        public void setAllow_phone_empty(final boolean allow_phone_empty) {
            this.allow_phone_empty = allow_phone_empty;
        }
        
        public void setBatch_date(final String batch_date) {
            this.batch_date = batch_date;
        }
        
        public void setBatch_id(final long batch_id) {
            this.batch_id = batch_id;
        }
        
        public void setConsignee_phone(final String consignee_phone) {
            this.consignee_phone = consignee_phone;
        }
        
        public void setConsignee_uid(final long consignee_uid) {
            this.consignee_uid = consignee_uid;
        }
        
        public void setExpress_id(final int express_id) {
            this.express_id = express_id;
        }
        
        public void setExpress_name(final String express_name) {
            this.express_name = express_name;
        }
        
        public void setId(final long id) {
            this.id = id;
        }
        
        public void setLogis_id(final int logis_id) {
            this.logis_id = logis_id;
        }
        
        public void setPayment(final int payment) {
            this.payment = payment;
        }
        
        public void setProblem_type(final int problem_type) {
            this.problem_type = problem_type;
        }
        
        public void setRegion_id(final int region_id) {
            this.region_id = region_id;
        }
        
        public void setSeq_no(final int seq_no) {
            this.seq_no = seq_no;
        }
        
        public void setStatus(final int status) {
            this.status = status;
        }
    }
}
