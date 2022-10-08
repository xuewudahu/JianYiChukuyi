package com.rq.net.bean;

public class DeviceActivationBodyBean
{
    private String city;
    private String city_code;
    private String county;
    private String county_code;
    private String detail;
    private String first_name;
    private String intranet_ip;
    private String mobile;
    private String province;
    private String province_code;
    private String serial_number;
    private String sign;
    private String smscode;
    private String timestamp;
    private String town;
    private String town_code;
    private String version;
    
    public DeviceActivationBodyBean() {
        this.serial_number = "";
        this.first_name = "";
        this.mobile = "";
        this.smscode = "";
        this.province_code = "";
        this.province = "";
        this.city_code = "";
        this.city = "";
        this.county_code = "";
        this.county = "";
        this.town_code = "";
        this.town = "";
        this.detail = "";
        this.intranet_ip = "";
        this.version = "";
        this.timestamp = "";
        this.sign = "";
    }
    
    public String getCity() {
        return this.city;
    }
    
    public String getCity_code() {
        return this.city_code;
    }
    
    public String getCounty() {
        return this.county;
    }
    
    public String getCounty_code() {
        return this.county_code;
    }
    
    public String getDetail() {
        return this.detail;
    }
    
    public String getFirst_name() {
        return this.first_name;
    }
    
    public String getIntranet_ip() {
        return this.intranet_ip;
    }
    
    public String getMobile() {
        return this.mobile;
    }
    
    public String getProvince() {
        return this.province;
    }
    
    public String getProvince_code() {
        return this.province_code;
    }
    
    public String getSerial_number() {
        return this.serial_number;
    }
    
    public String getSign() {
        return this.sign;
    }
    
    public String getSmscode() {
        return this.smscode;
    }
    
    public String getTimestamp() {
        return this.timestamp;
    }
    
    public String getTown() {
        return this.town;
    }
    
    public String getTown_code() {
        return this.town_code;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public void setCity(final String city) {
        this.city = city;
    }
    
    public void setCity_code(final String city_code) {
        this.city_code = city_code;
    }
    
    public void setCounty(final String county) {
        this.county = county;
    }
    
    public void setCounty_code(final String county_code) {
        this.county_code = county_code;
    }
    
    public void setDetail(final String detail) {
        this.detail = detail;
    }
    
    public void setFirst_name(final String first_name) {
        this.first_name = first_name;
    }
    
    public void setIntranet_ip(final String intranet_ip) {
        this.intranet_ip = intranet_ip;
    }
    
    public void setMobile(final String mobile) {
        this.mobile = mobile;
    }
    
    public void setProvince(final String province) {
        this.province = province;
    }
    
    public void setProvince_code(final String province_code) {
        this.province_code = province_code;
    }
    
    public void setSerial_number(final String serial_number) {
        this.serial_number = serial_number;
    }
    
    public void setSign(final String sign) {
        this.sign = sign;
    }
    
    public void setSmscode(final String smscode) {
        this.smscode = smscode;
    }
    
    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }
    
    public void setTown(final String town) {
        this.town = town;
    }
    
    public void setTown_code(final String town_code) {
        this.town_code = town_code;
    }
    
    public void setVersion(final String version) {
        this.version = version;
    }
}
