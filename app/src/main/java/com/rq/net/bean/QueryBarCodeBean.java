package com.rq.net.bean;

import java.util.*;

public class QueryBarCodeBean
{
    private List<DataBean> datas;
    
    public List<DataBean> getDatas() {
        return this.datas;
    }
    
    public void setDatas(final List<DataBean> datas) {
        this.datas = datas;
    }
    
    public class DataBean
    {
        private String checkCode;
        private DataStatus expressStatus;
        private long id;
        private String receiverMobile;
        
        public String getCheckCode() {
            return this.checkCode;
        }
        
        public DataStatus getExpressStatus() {
            return this.expressStatus;
        }
        
        public long getId() {
            return this.id;
        }
        
        public String getReceiverMobile() {
            return this.receiverMobile;
        }
        
        public void setCheckCode(final String checkCode) {
            this.checkCode = checkCode;
        }
        
        public void setExpressStatus(final DataStatus expressStatus) {
            this.expressStatus = expressStatus;
        }
        
        public void setId(final long id) {
            this.id = id;
        }
        
        public void setReceiverMobile(final String receiverMobile) {
            this.receiverMobile = receiverMobile;
        }
        
        public class DataStatus
        {
            private DataBeanStatus expressStatus;
            private DatanOticeStatus noticeStatus;
            
            public DataBeanStatus getExpressStatus() {
                return this.expressStatus;
            }
            
            public DatanOticeStatus getNoticeStatus() {
                return this.noticeStatus;
            }
            
            public void setExpressStatus(final DataBeanStatus expressStatus) {
                this.expressStatus = expressStatus;
            }
            
            public void setNoticeStatus(final DatanOticeStatus noticeStatus) {
                this.noticeStatus = noticeStatus;
            }
            
            public class DataBeanStatus
            {
                private String key;
                private String value;
                
                public String getKey() {
                    return this.key;
                }
                
                public String getValue() {
                    return this.value;
                }
                
                public void setKey(final String key) {
                    this.key = key;
                }
                
                public void setValue(final String value) {
                    this.value = value;
                }
            }
            
            public class DatanOticeStatus
            {
                private String key;
                private String value;
                
                public String getKey() {
                    return this.key;
                }
                
                public String getValue() {
                    return this.value;
                }
                
                public void setKey(final String key) {
                    this.key = key;
                }
                
                public void setValue(final String value) {
                    this.value = value;
                }
            }
        }
    }
}
