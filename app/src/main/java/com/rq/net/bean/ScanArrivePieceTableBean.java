package com.rq.net.bean;

//import com.kuaidihelp.posthouse.sqlite.bean.*;
import org.litepal.annotation.*;

public class ScanArrivePieceTableBean extends BaseDataSupport
{
    @Column(defaultValue = "unknown", unique = true)
    private String barcode;
    private int ex_com_id;
    private int height;
    private int length;
    private String pick_code;
    private String receive_name;
    private String receive_phone;
    private int width;
    
    public ScanArrivePieceTableBean(final String barcode, final int ex_com_id, final String receive_name, final String receive_phone, final String pick_code, final String timestamp, final String sign) {
        this.barcode = barcode;
        this.ex_com_id = ex_com_id;
        this.receive_name = receive_name;
        this.receive_phone = receive_phone;
        this.pick_code = pick_code;
        this.timestamp = timestamp;
        this.sign = sign;
    }
    
    public String getBarcode() {
        return this.barcode;
    }
    
    public int getEx_com_id() {
        return this.ex_com_id;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getLength() {
        return this.length;
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
    
    public int getWidth() {
        return this.width;
    }
    
    public void setBarcode(final String barcode) {
        this.barcode = barcode;
    }
    
    public void setEx_com_id(final int ex_com_id) {
        this.ex_com_id = ex_com_id;
    }
    
    public void setHeight(final int height) {
        this.height = height;
    }
    
    public void setLength(final int length) {
        this.length = length;
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
    
    public void setWidth(final int width) {
        this.width = width;
    }
}
