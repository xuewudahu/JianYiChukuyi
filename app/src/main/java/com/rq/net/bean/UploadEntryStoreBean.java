package com.rq.net.bean;

public class UploadEntryStoreBean
{
    private int ex_com_id;
    private String express_no;
    private String pick_code;
    private String receive_name;
    private String receive_phone;
    private String sign;
    private String time;
    
    public UploadEntryStoreBean() {
    }
    
    public UploadEntryStoreBean(final String express_no, final int ex_com_id, final String receive_name, final String receive_phone, final String pick_code) {
        this.express_no = express_no;
        this.ex_com_id = ex_com_id;
        this.receive_name = receive_name;
        this.receive_phone = receive_phone;
        this.pick_code = pick_code;
    }
    
    public int getEx_com_id() {
        return this.ex_com_id;
    }
    
    public String getExpress_no() {
        return this.express_no;
    }
    
    public String getPick_code() {
        return this.pick_code;
    }
    
    public String getReceive_name() {
        return this.receive_name;
    }
    
    public String getReceive_phone() {
        return this.receive_phone;
    }
    
    public String getSign() {
        return this.sign;
    }
    
    public String getTime() {
        return this.time;
    }
    
    public void setEx_com_id(final int ex_com_id) {
        this.ex_com_id = ex_com_id;
    }
    
    public void setExpress_no(final String express_no) {
        this.express_no = express_no;
    }
    
    public void setPick_code(final String pick_code) {
        this.pick_code = pick_code;
    }
    
    public void setReceive_name(final String receive_name) {
        this.receive_name = receive_name;
    }
    
    public void setReceive_phone(final String receive_phone) {
        this.receive_phone = receive_phone;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setTime(final String time) {
        this.time = time;
    }
}
