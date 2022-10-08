package com.rq.net.bean;


public class FactoryRegistrationBean {
    private String ICCID;
    private String IMEI;
    private String bluetooth;
    private String fisrt_name;
    private String register_date;
    private String serial_number;

    public FactoryRegistrationBean() {
    }

    public String getBluetooth() {
        return this.bluetooth;
    }

    public String getFisrt_name() {
        return this.fisrt_name;
    }

    public String getICCID() {
        return this.ICCID;
    }

    public String getIMEI() {
        return this.IMEI;
    }

    public String getRegister_date() {
        return this.register_date;
    }

    public String getSerial_number() {
        return this.serial_number;
    }

    public void setBluetooth(String var1) {
        this.bluetooth = var1;
    }

    public void setFisrt_name(String var1) {
        this.fisrt_name = var1;
    }

    public void setICCID(String var1) {
        this.ICCID = var1;
    }

    public void setIMEI(String var1) {
        this.IMEI = var1;
    }

    public void setRegister_date(String var1) {
        this.register_date = var1;
    }

    public void setSerial_number(String var1) {
        this.serial_number = var1;
    }
}
