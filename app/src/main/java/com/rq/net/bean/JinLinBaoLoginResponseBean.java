package com.rq.net.bean;

import java.util.*;

public class JinLinBaoLoginResponseBean
{
    private BodyBean body;
    private int code;
    private String msg;
    
    public BodyBean getBody() {
        return this.body;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setBody(final BodyBean body) {
        this.body = body;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public static class BodyBean
    {
        private int id;
        private int is_staff;
        private List<LogisListBean> logis_list;
        private String name;
        private String phone;
        private int position;
        private String real_name;
        private SessionBean session;
        private int staff_type;
        
        public int getId() {
            return this.id;
        }
        
        public int getIs_staff() {
            return this.is_staff;
        }
        
        public List<LogisListBean> getLogis_list() {
            return this.logis_list;
        }
        
        public String getName() {
            return this.name;
        }
        
        public String getPhone() {
            return this.phone;
        }
        
        public int getPosition() {
            return this.position;
        }
        
        public String getReal_name() {
            return this.real_name;
        }
        
        public SessionBean getSession() {
            return this.session;
        }
        
        public int getStaff_type() {
            return this.staff_type;
        }
        
        public void setId(final int id) {
            this.id = id;
        }
        
        public void setIs_staff(final int is_staff) {
            this.is_staff = is_staff;
        }
        
        public void setLogis_list(final List<LogisListBean> logis_list) {
            this.logis_list = logis_list;
        }
        
        public void setName(final String name) {
            this.name = name;
        }
        
        public void setPhone(final String phone) {
            this.phone = phone;
        }
        
        public void setPosition(final int position) {
            this.position = position;
        }
        
        public void setReal_name(final String real_name) {
            this.real_name = real_name;
        }
        
        public void setSession(final SessionBean session) {
            this.session = session;
        }
        
        public void setStaff_type(final int staff_type) {
            this.staff_type = staff_type;
        }
        
        public static class LogisListBean
        {
            private int check_phone;
            private int garden_id;
            private int id;
            private String name;
            
            public int getCheck_phone() {
                return this.check_phone;
            }
            
            public int getGarden_id() {
                return this.garden_id;
            }
            
            public int getId() {
                return this.id;
            }
            
            public String getName() {
                return this.name;
            }
            
            public void setCheck_phone(final int check_phone) {
                this.check_phone = check_phone;
            }
            
            public void setGarden_id(final int garden_id) {
                this.garden_id = garden_id;
            }
            
            public void setId(final int id) {
                this.id = id;
            }
            
            public void setName(final String name) {
                this.name = name;
            }
        }
        
        public static class SessionBean
        {
            private String sid;
            
            public String getSid() {
                return this.sid;
            }
            
            public void setSid(final String sid) {
                this.sid = sid;
            }
        }
    }
}
