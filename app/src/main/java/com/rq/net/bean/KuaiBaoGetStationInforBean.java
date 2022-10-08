package com.rq.net.bean;

public class KuaiBaoGetStationInforBean extends KuaiBaoBaseBean
{
    private String data;
    private String did;
    
    public KuaiBaoGetStationInforBean(final String did, final String data) {
        this.did = did;
        this.data = data;
    }
    
    public String getData() {
        return this.data;
    }
    
    public String getDid() {
        return this.did;
    }
    
    public void setData(final String data) {
        this.data = data;
    }
    
    public void setDid(final String did) {
        this.did = did;
    }
    
    public static class StationInforData
    {
        private String session_id;
        
        public StationInforData(final String session_id) {
            this.session_id = session_id;
        }
        
        public String getSession_id() {
            return this.session_id;
        }
        
        public void setSession_id(final String session_id) {
            this.session_id = session_id;
        }
    }
}
