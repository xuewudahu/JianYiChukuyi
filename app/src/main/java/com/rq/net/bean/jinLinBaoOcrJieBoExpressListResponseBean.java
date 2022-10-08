package com.rq.net.bean;

import java.util.*;

public class jinLinBaoOcrJieBoExpressListResponseBean
{
    private List<ExpressListBodyBean> body;
    private int code;
    private String msg;
    
    public List<ExpressListBodyBean> getBody() {
        return this.body;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setBody(final List<ExpressListBodyBean> body) {
        this.body = body;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public static class ExpressListBodyBean
    {
        private String address;
        private String cainiao_code;
        private int cainiao_flag;
        private int can_electronic;
        private String create_time;
        private int create_user;
        private int display;
        private String exp100_code;
        private String exp_rule;
        private int id;
        private String img;
        private int is_sym_eshop;
        private String kdniao_code;
        private int level;
        private String name;
        private int scope;
        private int sort;
        private int status;
        private String telephone;
        private String template_type;
        private String update_time;
        private int update_user;
        private int work_mode;
        
        public String getAddress() {
            return this.address;
        }
        
        public String getCainiao_code() {
            return this.cainiao_code;
        }
        
        public int getCainiao_flag() {
            return this.cainiao_flag;
        }
        
        public int getCan_electronic() {
            return this.can_electronic;
        }
        
        public String getCreate_time() {
            return this.create_time;
        }
        
        public int getCreate_user() {
            return this.create_user;
        }
        
        public int getDisplay() {
            return this.display;
        }
        
        public String getExp100_code() {
            return this.exp100_code;
        }
        
        public String getExp_rule() {
            return this.exp_rule;
        }
        
        public int getId() {
            return this.id;
        }
        
        public String getImg() {
            return this.img;
        }
        
        public int getIs_sym_eshop() {
            return this.is_sym_eshop;
        }
        
        public String getKdniao_code() {
            return this.kdniao_code;
        }
        
        public int getLevel() {
            return this.level;
        }
        
        public String getName() {
            return this.name;
        }
        
        public int getScope() {
            return this.scope;
        }
        
        public int getSort() {
            return this.sort;
        }
        
        public int getStatus() {
            return this.status;
        }
        
        public String getTelephone() {
            return this.telephone;
        }
        
        public String getTemplate_type() {
            return this.template_type;
        }
        
        public String getUpdate_time() {
            return this.update_time;
        }
        
        public int getUpdate_user() {
            return this.update_user;
        }
        
        public int getWork_mode() {
            return this.work_mode;
        }
        
        public void setAddress(final String address) {
            this.address = address;
        }
        
        public void setCainiao_code(final String cainiao_code) {
            this.cainiao_code = cainiao_code;
        }
        
        public void setCainiao_flag(final int cainiao_flag) {
            this.cainiao_flag = cainiao_flag;
        }
        
        public void setCan_electronic(final int can_electronic) {
            this.can_electronic = can_electronic;
        }
        
        public void setCreate_time(final String create_time) {
            this.create_time = create_time;
        }
        
        public void setCreate_user(final int create_user) {
            this.create_user = create_user;
        }
        
        public void setDisplay(final int display) {
            this.display = display;
        }
        
        public void setExp100_code(final String exp100_code) {
            this.exp100_code = exp100_code;
        }
        
        public void setExp_rule(final String exp_rule) {
            this.exp_rule = exp_rule;
        }
        
        public void setId(final int id) {
            this.id = id;
        }
        
        public void setImg(final String img) {
            this.img = img;
        }
        
        public void setIs_sym_eshop(final int is_sym_eshop) {
            this.is_sym_eshop = is_sym_eshop;
        }
        
        public void setKdniao_code(final String kdniao_code) {
            this.kdniao_code = kdniao_code;
        }
        
        public void setLevel(final int level) {
            this.level = level;
        }
        
        public void setName(final String name) {
            this.name = name;
        }
        
        public void setScope(final int scope) {
            this.scope = scope;
        }
        
        public void setSort(final int sort) {
            this.sort = sort;
        }
        
        public void setStatus(final int status) {
            this.status = status;
        }
        
        public void setTelephone(final String telephone) {
            this.telephone = telephone;
        }
        
        public void setTemplate_type(final String template_type) {
            this.template_type = template_type;
        }
        
        public void setUpdate_time(final String update_time) {
            this.update_time = update_time;
        }
        
        public void setUpdate_user(final int update_user) {
            this.update_user = update_user;
        }
        
        public void setWork_mode(final int work_mode) {
            this.work_mode = work_mode;
        }
    }
}
