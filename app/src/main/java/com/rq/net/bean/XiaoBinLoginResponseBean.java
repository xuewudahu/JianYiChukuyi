package com.rq.net.bean;

public class XiaoBinLoginResponseBean
{
    private boolean code;
    private DataBean data;
    private String msg;
    
    public DataBean getData() {
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
    
    public void setData(final DataBean data) {
        this.data = data;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public static class DataBean
    {
        private String appKey;
        private int id;
        private LocalContactBean localContact;
        private String role;
        private int sign_auto;
        private String sub_id;
        private String token;
        
        public String getAppKey() {
            return this.appKey;
        }
        
        public int getId() {
            return this.id;
        }
        
        public LocalContactBean getLocalContact() {
            return this.localContact;
        }
        
        public String getRole() {
            return this.role;
        }
        
        public int getSign_auto() {
            return this.sign_auto;
        }
        
        public String getSub_id() {
            return this.sub_id;
        }
        
        public String getToken() {
            return this.token;
        }
        
        public void setAppKey(final String appKey) {
            this.appKey = appKey;
        }
        
        public void setId(final int id) {
            this.id = id;
        }
        
        public void setLocalContact(final LocalContactBean localContact) {
            this.localContact = localContact;
        }
        
        public void setRole(final String role) {
            this.role = role;
        }
        
        public void setSign_auto(final int sign_auto) {
            this.sign_auto = sign_auto;
        }
        
        public void setSub_id(final String sub_id) {
            this.sub_id = sub_id;
        }
        
        public void setToken(final String token) {
            this.token = token;
        }
        
        public static class LocalContactBean
        {
            private String qq_courier;
            private String qq_courier_key;
            private String qq_station;
            private String qq_station_key;
            private String tel;
            private String wx;
            
            public String getQq_courier() {
                return this.qq_courier;
            }
            
            public String getQq_courier_key() {
                return this.qq_courier_key;
            }
            
            public String getQq_station() {
                return this.qq_station;
            }
            
            public String getQq_station_key() {
                return this.qq_station_key;
            }
            
            public String getTel() {
                return this.tel;
            }
            
            public String getWx() {
                return this.wx;
            }
            
            public void setQq_courier(final String qq_courier) {
                this.qq_courier = qq_courier;
            }
            
            public void setQq_courier_key(final String qq_courier_key) {
                this.qq_courier_key = qq_courier_key;
            }
            
            public void setQq_station(final String qq_station) {
                this.qq_station = qq_station;
            }
            
            public void setQq_station_key(final String qq_station_key) {
                this.qq_station_key = qq_station_key;
            }
            
            public void setTel(final String tel) {
                this.tel = tel;
            }
            
            public void setWx(final String wx) {
                this.wx = wx;
            }
        }
    }
}
