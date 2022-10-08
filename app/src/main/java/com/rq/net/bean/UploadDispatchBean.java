package com.rq.net.bean;

public class UploadDispatchBean
{
    private String express_no;
    private int next_site_id;
    private String sign;
    private String time;
    
    public UploadDispatchBean() {
    }
    
    public UploadDispatchBean(final String express_no, final int next_site_id) {
        this.express_no = express_no;
        this.next_site_id = next_site_id;
    }
    
    public String getExpress_no() {
        return this.express_no;
    }
    
    public int getNext_site_id() {
        return this.next_site_id;
    }
    
    public String getSign() {
        return this.sign;
    }
    
    public String getTime() {
        return this.time;
    }
    
    public void setExpress_no(final String express_no) {
        this.express_no = express_no;
    }
    
    public void setNext_site_id(final int next_site_id) {
        this.next_site_id = next_site_id;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setTime(final String time) {
        this.time = time;
    }
}
