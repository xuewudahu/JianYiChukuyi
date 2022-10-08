package com.rq.net.bean;

//import com.kuaidihelp.posthouse.sqlite.bean.*;
import org.litepal.annotation.*;

public class ScanDispatchPieceTableBean extends BaseDataSupport
{
    @Column(defaultValue = "unknown", unique = true)
    private String barcode;
    private int height;
    private int length;
    private int next_site_id;
    private int weight;
    private int width;
    
    public ScanDispatchPieceTableBean(final String barcode, final int next_site_id, final String timestamp, final String sign) {
        this.barcode = barcode;
        this.next_site_id = next_site_id;
        this.timestamp = timestamp;
        this.sign = sign;
    }
    
    public String getBarcode() {
        return this.barcode;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public int getNext_site_id() {
        return this.next_site_id;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setBarcode(final String barcode) {
        this.barcode = barcode;
    }
    
    public void setHeight(final int height) {
        this.height = height;
    }
    
    public void setLength(final int length) {
        this.length = length;
    }
    
    public void setNext_site_id(final int next_site_id) {
        this.next_site_id = next_site_id;
    }
    
    public void setWeight(final int weight) {
        this.weight = weight;
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
}
