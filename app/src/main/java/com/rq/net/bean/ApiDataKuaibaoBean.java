package com.rq.net.bean;


public class ApiDataKuaibaoBean<T> {
    private int code;
    private T data;
    private String msg;

    public ApiDataKuaibaoBean() {
    }

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int var1) {
        this.code = var1;
    }

    public void setData(T var1) {
        this.data = var1;
    }

    public void setMsg(String var1) {
        this.msg = var1;
    }
}

