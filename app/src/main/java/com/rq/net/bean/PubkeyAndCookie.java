package com.rq.net.bean;

public class PubkeyAndCookie
{
    private String cookie;
    private String publicKey;
    
    public PubkeyAndCookie(final String publicKey, final String cookie) {
        this.publicKey = publicKey;
        this.cookie = cookie;
    }
    
    public String getCookie() {
        return this.cookie;
    }
    
    public String getPublicKey() {
        return this.publicKey;
    }
    
    public void setCookie(final String cookie) {
        this.cookie = cookie;
    }
    
    public void setPublicKey(final String publicKey) {
        this.publicKey = publicKey;
    }
}
