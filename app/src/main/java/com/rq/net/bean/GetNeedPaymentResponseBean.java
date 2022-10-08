package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/GetNeedPaymentResponseBean;", "", "code", "", "data", "total", "msg", "", "(IIILjava/lang/String;)V", "getCode", "()I", "getData", "getMsg", "()Ljava/lang/String;", "getTotal", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class GetNeedPaymentResponseBean
{
    private final int code;
    private final int data;
    private final String msg;
    private final int total;
    
    public GetNeedPaymentResponseBean(final int code, final int data, final int total, final String msg) {
        //Intrinsics.checkParameterIsNotNull(msg, "msg");
        this.code = code;
        this.data = data;
        this.total = total;
        this.msg = msg;
    }
    
    public final int component1() {
        return this.code;
    }
    
    public final int component2() {
        return this.data;
    }
    
    public final int component3() {
        return this.total;
    }
    
    public final String component4() {
        return this.msg;
    }
    
    public final GetNeedPaymentResponseBean copy(final int n, final int n2, final int n3, final String s) {
        //Intrinsics.checkParameterIsNotNull(s, "msg");
        return new GetNeedPaymentResponseBean(n, n2, n3, s);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof GetNeedPaymentResponseBean) {
                final GetNeedPaymentResponseBean getNeedPaymentResponseBean = (GetNeedPaymentResponseBean)o;
                if (this.code == getNeedPaymentResponseBean.code && this.data == getNeedPaymentResponseBean.data && this.total == getNeedPaymentResponseBean.total && Intrinsics.areEqual(this.msg, getNeedPaymentResponseBean.msg)) {
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
    
    public final int getData() {
        return this.data;
    }
    
    public final String getMsg() {
        return this.msg;
    }
    
    public final int getTotal() {
        return this.total;
    }
    
    @Override
    public int hashCode() {
        final int code = this.code;
        final int data = this.data;
        final int total = this.total;
        final String msg = this.msg;
        int hashCode;
        if (msg != null) {
            hashCode = msg.hashCode();
        }
        else {
            hashCode = 0;
        }
        return ((code * 31 + data) * 31 + total) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GetNeedPaymentResponseBean(code=");
        sb.append(this.code);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", total=");
        sb.append(this.total);
        sb.append(", msg=");
        sb.append(this.msg);
        sb.append(")");
        return sb.toString();
    }
}
