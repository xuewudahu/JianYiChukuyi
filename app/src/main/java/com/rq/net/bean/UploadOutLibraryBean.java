package com.rq.net.bean;

public class UploadOutLibraryBean
{
    private String express_no;
    private String pic_list;
    private String sign;
    private String time;
    
    public UploadOutLibraryBean() {
        this.pic_list = "";
    }
    
    public UploadOutLibraryBean(final String express_no) {
        this.pic_list = "";
        this.express_no = express_no;
    }
    
    public String getExpress_no() {
        return this.express_no;
    }
    
    public String getPic_list() {
        return this.pic_list;
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
    
    public void setPic_list(final String pic_list) {
        this.pic_list = pic_list;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setTime(final String time) {
        this.time = time;
    }
}
