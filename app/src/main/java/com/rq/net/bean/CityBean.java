package com.rq.net.bean;

//import com.yunpan.common.adressselectorlib.*;

import com.rq.net.api.CityInterface;

public class CityBean implements CityInterface
{
    private String code;
    private String name;
    
    @Override
    public String getCityCode() {
        return this.code;
    }
    
    @Override
    public String getCityName() {
        return this.name;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setCode(final String code) {
        this.code = code;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
}
