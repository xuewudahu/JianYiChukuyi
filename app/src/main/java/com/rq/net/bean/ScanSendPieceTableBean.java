package com.rq.net.bean;

//import com.kuaidihelp.posthouse.sqlite.bean.*;
import org.litepal.annotation.*;

public class ScanSendPieceTableBean extends BaseDataSupport
{
    @Column(defaultValue = "unknown", unique = true)
    private String barcode;
    private int express_company_id;
    private int height;
    private int id;
    private int length;
    private int number;
    private int package_type_id;
    private int price;
    private String receive_address;
    private String receive_name;
    private String receive_phone;
    private String send_address;
    private String send_name;
    private String send_phone;
    private int weight;
    private int width;
    
    public ScanSendPieceTableBean(final String barcode, final int weight, final String send_name, final String send_phone, final String send_address, final String receive_name, final String receive_address, final String receive_phone, final int express_company_id, final int package_type_id, final int number, final int price, final String timestamp, final String sign) {
        this.barcode = barcode;
        this.weight = weight;
        this.send_name = send_name;
        this.send_phone = send_phone;
        this.send_address = send_address;
        this.receive_name = receive_name;
        this.receive_address = receive_address;
        this.receive_phone = receive_phone;
        this.express_company_id = express_company_id;
        this.package_type_id = package_type_id;
        this.number = number;
        this.price = price;
        this.timestamp = timestamp;
        this.sign = sign;
    }
    
    public String getBarcode() {
        return this.barcode;
    }
    
    public int getExpress_company_id() {
        return this.express_company_id;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public int getPackage_type_id() {
        return this.package_type_id;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public String getReceive_address() {
        return this.receive_address;
    }
    
    public String getReceive_name() {
        return this.receive_name;
    }
    
    public String getReceive_phone() {
        return this.receive_phone;
    }
    
    public String getSend_address() {
        return this.send_address;
    }
    
    public String getSend_name() {
        return this.send_name;
    }
    
    public String getSend_phone() {
        return this.send_phone;
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
    
    public void setExpress_company_id(final int express_company_id) {
        this.express_company_id = express_company_id;
    }
    
    public void setHeight(final int height) {
        this.height = height;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public void setLength(final int length) {
        this.length = length;
    }
    
    public void setNumber(final int number) {
        this.number = number;
    }
    
    public void setPackage_type_id(final int package_type_id) {
        this.package_type_id = package_type_id;
    }
    
    public void setPrice(final int price) {
        this.price = price;
    }
    
    public void setReceive_address(final String receive_address) {
        this.receive_address = receive_address;
    }
    
    public void setReceive_name(final String receive_name) {
        this.receive_name = receive_name;
    }
    
    public void setReceive_phone(final String receive_phone) {
        this.receive_phone = receive_phone;
    }
    
    public void setSend_address(final String send_address) {
        this.send_address = send_address;
    }
    
    public void setSend_name(final String send_name) {
        this.send_name = send_name;
    }
    
    public void setSend_phone(final String send_phone) {
        this.send_phone = send_phone;
    }
    
    public void setWeight(final int weight) {
        this.weight = weight;
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
}
