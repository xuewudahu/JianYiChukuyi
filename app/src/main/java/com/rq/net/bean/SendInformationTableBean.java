package com.rq.net.bean;

import org.litepal.crud.*;
import org.litepal.annotation.*;

public class SendInformationTableBean /*extends DataSupport*/{
    private String contact;
    private int express_company;
    private String express_company_name;
    private String express_no;
    @Column(defaultValue = "unknown", unique = true)
    private int id;
    private boolean is_delete;
    private boolean is_print;
    private int number;
    private String operator;
    private int package_type;
    private int price;
    private String receive_address;
    private String receive_name;
    private String receive_phone;
    private String send_address;
    private String send_name;
    private String send_phone;
    private String time;
    private int weight;
    
    public String getContact() {
        return this.contact;
    }
    
    public int getExpress_company() {
        return this.express_company;
    }
    
    public String getExpress_company_name() {
        return this.express_company_name;
    }
    
    public String getExpress_no() {
        return this.express_no;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public String getOperator() {
        return this.operator;
    }
    
    public int getPackage_type() {
        return this.package_type;
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
    
    public String getTime() {
        return this.time;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public boolean isIs_delete() {
        return this.is_delete;
    }
    
    public boolean isIs_print() {
        return this.is_print;
    }
    
    public void setContact(final String contact) {
        this.contact = contact;
    }
    
    public void setExpress_company(final int express_company) {
        this.express_company = express_company;
    }
    
    public void setExpress_company_name(final String express_company_name) {
        this.express_company_name = express_company_name;
    }
    
    public void setExpress_no(final String express_no) {
        this.express_no = express_no;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public void setIs_delete(final boolean is_delete) {
        this.is_delete = is_delete;
    }
    
    public void setIs_print(final boolean is_print) {
        this.is_print = is_print;
    }
    
    public void setNumber(final int number) {
        this.number = number;
    }
    
    public void setOperator(final String operator) {
        this.operator = operator;
    }
    
    public void setPackage_type(final int package_type) {
        this.package_type = package_type;
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
    
    public void setTime(final String time) {
        this.time = time;
    }
    
    public void setWeight(final int weight) {
        this.weight = weight;
    }
}
