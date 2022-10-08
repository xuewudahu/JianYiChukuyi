package com.rq.net.bean;

import androidx.fragment.app.*;

public class SettingBean
{
    private int code;
    private Fragment fragmentClass;
    private String name;
    private int res;
    
    public SettingBean(final int code, final int res, final String name, final Fragment fragmentClass) {
        this.code = code;
        this.res = res;
        this.name = name;
        this.fragmentClass = fragmentClass;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public Fragment getFragmentClass() {
        return this.fragmentClass;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getRes() {
        return this.res;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setFragmentClass(final Fragment fragmentClass) {
        this.fragmentClass = fragmentClass;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setRes(final int res) {
        this.res = res;
    }
}
