package com.rq.net.bean;

public class CourSmallPoleChuKuBean
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
    
    public static class DataBean
    {
        private DataFig config;
        
        public DataFig getConfig() {
            return this.config;
        }
        
        public void setConfig(final DataFig config) {
            this.config = config;
        }
        
        public static class DataFig
        {
            private String accessid;
            private String callback;
            private String dir;
            private String host;
            private String policy;
            private String savefile;
            private String signature;
            
            public String getAccessid() {
                return this.accessid;
            }
            
            public String getCallback() {
                return this.callback;
            }
            
            public String getDir() {
                return this.dir;
            }
            
            public String getHost() {
                return this.host;
            }
            
            public String getPolicy() {
                return this.policy;
            }
            
            public String getSavefile() {
                return this.savefile;
            }
            
            public String getSignature() {
                return this.signature;
            }
            
            public void setAccessid(final String accessid) {
                this.accessid = accessid;
            }
            
            public void setCallback(final String callback) {
                this.callback = callback;
            }
            
            public void setDir(final String dir) {
                this.dir = dir;
            }
            
            public void setHost(final String host) {
                this.host = host;
            }
            
            public void setPolicy(final String policy) {
                this.policy = policy;
            }
            
            public void setSavefile(final String savefile) {
                this.savefile = savefile;
            }
            
            public void setSignature(final String signature) {
                this.signature = signature;
            }
        }
    }
}
