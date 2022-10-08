package com.rq.net.bean;


import org.litepal.annotation.*;

public class ScanBarcodeBean extends BaseDataSupport
{
    @Column(defaultValue = "unknown", unique = true)
    private String barcode;
    private int height;
    private int length;
    private String weight;
    private int width;
    
    public ScanBarcodeBean() {
        this.length = 0;
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
    
    public String getWeight() {
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
    
    public void setWeight(final String weight) {
        this.weight = weight;
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
}
