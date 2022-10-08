package com.rq.net.bean;

import java.util.*;

public class MaMaCheckHuoJiaResponseBean
{
    private String accept;
    private List<DataBean> data;
    private String errorCode;
    private Object errorMsg;
    
    public String getAccept() {
        return this.accept;
    }
    
    public List<DataBean> getData() {
        return this.data;
    }
    
    public String getErrorCode() {
        return this.errorCode;
    }
    
    public Object getErrorMsg() {
        return this.errorMsg;
    }
    
    public void setAccept(final String accept) {
        this.accept = accept;
    }
    
    public void setData(final List<DataBean> data) {
        this.data = data;
    }
    
    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }
    
    public void setErrorMsg(final Object errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MaMaCheckHuoJiaResponseBean{accept='");
        sb.append(this.accept);
        sb.append('\'');
        sb.append(", errorCode='");
        sb.append(this.errorCode);
        sb.append('\'');
        sb.append(", errorMsg=");
        sb.append(this.errorMsg);
        sb.append(", data=");
        sb.append(this.data);
        sb.append('}');
        return sb.toString();
    }
    
    public static class DataBean
    {
        private String extend;
        private String key;
        private String value;
        
        public String getExtend() {
            return this.extend;
        }
        
        public String getKey() {
            return this.key;
        }
        
        public String getValue() {
            return this.value;
        }
        
        public void setExtend(final String extend) {
            this.extend = extend;
        }
        
        public void setKey(final String key) {
            this.key = key;
        }
        
        public void setValue(final String value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("DataBean{key='");
            sb.append(this.key);
            sb.append('\'');
            sb.append(", value='");
            sb.append(this.value);
            sb.append('\'');
            sb.append(", extend='");
            sb.append(this.extend);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
