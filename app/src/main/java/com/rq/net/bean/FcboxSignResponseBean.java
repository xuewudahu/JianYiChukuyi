package com.rq.net.bean;

public class FcboxSignResponseBean
{
    private int code;
    private String expressNo;
    private String msg;
    private int postId;
    private boolean success;
    
    public int getCode() {
        return this.code;
    }
    
    public String getExpressNo() {
        return this.expressNo;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public int getPostId() {
        return this.postId;
    }
    
    public boolean isSuccess() {
        return this.success;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setExpressNo(final String expressNo) {
        this.expressNo = expressNo;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public void setPostId(final int postId) {
        this.postId = postId;
    }
    
    public void setSuccess(final boolean success) {
        this.success = success;
    }
}
