package com.rq.net.bean;

public class CourierSmallPoleLogin
{
    private int code;
    private BeanData data;
    private String message;
    
    public int getCode() {
        return this.code;
    }
    
    public BeanData getData() {
        return this.data;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setData(final BeanData data) {
        this.data = data;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CourierSmallPoleLogin{code=");
        sb.append(this.code);
        sb.append(", message='");
        sb.append(this.message);
        sb.append('\'');
        sb.append(", data=");
        sb.append(this.data);
        sb.append('}');
        return sb.toString();
    }
    
    public class BeanData
    {
        private int accountType;
        private DataInfo info;
        private SettingData notice_setting;
        private String token;
        private String uid;
        
        public int getAccountType() {
            return this.accountType;
        }
        
        public DataInfo getInfo() {
            return this.info;
        }
        
        public SettingData getNotice_setting() {
            return this.notice_setting;
        }
        
        public String getToken() {
            return this.token;
        }
        
        public String getUid() {
            return this.uid;
        }
        
        public void setAccountType(final int accountType) {
            this.accountType = accountType;
        }
        
        public void setInfo(final DataInfo info) {
            this.info = info;
        }
        
        public void setNotice_setting(final SettingData notice_setting) {
            this.notice_setting = notice_setting;
        }
        
        public void setToken(final String token) {
            this.token = token;
        }
        
        public void setUid(final String uid) {
            this.uid = uid;
        }
        
        public class DataInfo
        {
        }
        
        public class SettingData
        {
            public int account_switch;
            public int activity_switch;
            public int examine_switch;
            public int reply_switch;
            public int system_switch;
            
            public int getAccount_switch() {
                return this.account_switch;
            }
            
            public int getActivity_switch() {
                return this.activity_switch;
            }
            
            public int getExamine_switch() {
                return this.examine_switch;
            }
            
            public int getReply_switch() {
                return this.reply_switch;
            }
            
            public int getSystem_switch() {
                return this.system_switch;
            }
            
            public void setAccount_switch(final int account_switch) {
                this.account_switch = account_switch;
            }
            
            public void setActivity_switch(final int activity_switch) {
                this.activity_switch = activity_switch;
            }
            
            public void setExamine_switch(final int examine_switch) {
                this.examine_switch = examine_switch;
            }
            
            public void setReply_switch(final int reply_switch) {
                this.reply_switch = reply_switch;
            }
            
            public void setSystem_switch(final int system_switch) {
                this.system_switch = system_switch;
            }
        }
    }
}
