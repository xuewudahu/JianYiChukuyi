package com.rq.net.bean;

import java.util.*;

public class MaMaLoginResponseBean
{
    private String empCode;
    private String isAudit;
    private String key;
    private List<MenusBean> menus;
    private String mobile;
    private String orgCode;
    private String realname;
    private String role;
    private String stationCode;
    private String token;
    private String userName;
    
    public String getEmpCode() {
        return this.empCode;
    }
    
    public String getIsAudit() {
        return this.isAudit;
    }
    
    public String getKey() {
        return this.key;
    }
    
    public List<MenusBean> getMenus() {
        return this.menus;
    }
    
    public String getMobile() {
        return this.mobile;
    }
    
    public String getOrgCode() {
        return this.orgCode;
    }
    
    public String getRealname() {
        return this.realname;
    }
    
    public String getRole() {
        return this.role;
    }
    
    public String getStationCode() {
        return this.stationCode;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setEmpCode(final String empCode) {
        this.empCode = empCode;
    }
    
    public void setIsAudit(final String isAudit) {
        this.isAudit = isAudit;
    }
    
    public void setKey(final String key) {
        this.key = key;
    }
    
    public void setMenus(final List<MenusBean> menus) {
        this.menus = menus;
    }
    
    public void setMobile(final String mobile) {
        this.mobile = mobile;
    }
    
    public void setOrgCode(final String orgCode) {
        this.orgCode = orgCode;
    }
    
    public void setRealname(final String realname) {
        this.realname = realname;
    }
    
    public void setRole(final String role) {
        this.role = role;
    }
    
    public void setStationCode(final String stationCode) {
        this.stationCode = stationCode;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }
    
    public void setUserName(final String userName) {
        this.userName = userName;
    }
    
    public static class MenusBean
    {
        private String description;
        private String enable;
        private String firstPage;
        private String id;
        private int menuId;
        private String name;
        private String type;
        private String url;
        
        public String getDescription() {
            return this.description;
        }
        
        public String getEnable() {
            return this.enable;
        }
        
        public String getFirstPage() {
            return this.firstPage;
        }
        
        public String getId() {
            return this.id;
        }
        
        public int getMenuId() {
            return this.menuId;
        }
        
        public String getName() {
            return this.name;
        }
        
        public String getType() {
            return this.type;
        }
        
        public String getUrl() {
            return this.url;
        }
        
        public void setDescription(final String description) {
            this.description = description;
        }
        
        public void setEnable(final String enable) {
            this.enable = enable;
        }
        
        public void setFirstPage(final String firstPage) {
            this.firstPage = firstPage;
        }
        
        public void setId(final String id) {
            this.id = id;
        }
        
        public void setMenuId(final int menuId) {
            this.menuId = menuId;
        }
        
        public void setName(final String name) {
            this.name = name;
        }
        
        public void setType(final String type) {
            this.type = type;
        }
        
        public void setUrl(final String url) {
            this.url = url;
        }
    }
}
