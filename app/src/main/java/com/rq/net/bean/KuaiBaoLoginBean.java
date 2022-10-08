package com.rq.net.bean;

public class KuaiBaoLoginBean extends KuaiBaoBaseBean
{
    private String data;

    private String pass;
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getData() {
        return this.data;
    }
    
    public void setData(final String data) {
        this.data = data;
    }
    
    public static class LoginData
    {
        private String pass;
        private String phone;
        
        public LoginData(final String phone, final String pass) {
            this.phone = phone;
            this.pass = pass;
        }
        public LoginData() {
        }
        public String getPass() {
            return this.pass;
        }
        
        public String getPhone() {
            return this.phone;
        }
        
        public void setPass(final String pass) {
            this.pass = pass;
        }
        
        public void setPhone(final String phone) {
            this.phone = phone;
        }
    }
}
