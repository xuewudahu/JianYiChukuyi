package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/YshouFaLoginResponseBean;", "", "code", "", "msg", "", "data", "Lcom/yunpan/cobaaidlservice/bean/YshouFaLoginResDataBean;", "(ILjava/lang/String;Lcom/yunpan/cobaaidlservice/bean/YshouFaLoginResDataBean;)V", "getCode", "()I", "getData", "()Lcom/yunpan/cobaaidlservice/bean/YshouFaLoginResDataBean;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class YshouFaLoginResponseBean
{
    private final int code;
    private final YshouFaLoginResDataBean data;
    private final String msg;
    
    public YshouFaLoginResponseBean(final int code, final String msg, final YshouFaLoginResDataBean data) {
        //Intrinsics.checkParameterIsNotNull(msg, "msg");
        //Intrinsics.checkParameterIsNotNull(data, "data");
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    public final int component1() {
        return this.code;
    }
    
    public final String component2() {
        return this.msg;
    }
    
    public final YshouFaLoginResDataBean component3() {
        return this.data;
    }
    
    public final YshouFaLoginResponseBean copy(final int n, final String s, final YshouFaLoginResDataBean yshouFaLoginResDataBean) {
        //Intrinsics.checkParameterIsNotNull(s, "msg");
        //Intrinsics.checkParameterIsNotNull(yshouFaLoginResDataBean, "data");
        return new YshouFaLoginResponseBean(n, s, yshouFaLoginResDataBean);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof YshouFaLoginResponseBean) {
                final YshouFaLoginResponseBean yshouFaLoginResponseBean = (YshouFaLoginResponseBean)o;
                if (this.code == yshouFaLoginResponseBean.code && Intrinsics.areEqual(this.msg, yshouFaLoginResponseBean.msg) && Intrinsics.areEqual(this.data, yshouFaLoginResponseBean.data)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final int getCode() {
        return this.code;
    }
    
    public final YshouFaLoginResDataBean getData() {
        return this.data;
    }
    
    public final String getMsg() {
        return this.msg;
    }
    
    @Override
    public int hashCode() {
        final int code = this.code;
        final String msg = this.msg;
        int hashCode = 0;
        int hashCode2;
        if (msg != null) {
            hashCode2 = msg.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final YshouFaLoginResDataBean data = this.data;
        if (data != null) {
            hashCode = data.hashCode();
        }
        return (code * 31 + hashCode2) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("YshouFaLoginResponseBean(code=");
        sb.append(this.code);
        sb.append(", msg=");
        sb.append(this.msg);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(")");
        return sb.toString();
    }
}
