package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001b" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/BatchsignVersionResponseBean;", "", "code", "", "data", "Lcom/yunpan/cobaaidlservice/bean/YshouFaVersionBean;", "total", "msg", "", "(ILcom/yunpan/cobaaidlservice/bean/YshouFaVersionBean;ILjava/lang/String;)V", "getCode", "()I", "getData", "()Lcom/yunpan/cobaaidlservice/bean/YshouFaVersionBean;", "getMsg", "()Ljava/lang/String;", "getTotal", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class BatchsignVersionResponseBean
{
    private final int code;
    private final YshouFaVersionBean data;
    private final String msg;
    private final int total;
    
    public BatchsignVersionResponseBean(final int code, final YshouFaVersionBean data, final int total, final String msg) {
        //Intrinsics.checkParameterIsNotNull(data, "data");
        //Intrinsics.checkParameterIsNotNull(msg, "msg");
        this.code = code;
        this.data = data;
        this.total = total;
        this.msg = msg;
    }
    
    public final int component1() {
        return this.code;
    }
    
    public final YshouFaVersionBean component2() {
        return this.data;
    }
    
    public final int component3() {
        return this.total;
    }
    
    public final String component4() {
        return this.msg;
    }
    
    public final BatchsignVersionResponseBean copy(final int n, final YshouFaVersionBean yshouFaVersionBean, final int n2, final String s) {
        //Intrinsics.checkParameterIsNotNull(yshouFaVersionBean, "data");
        //Intrinsics.checkParameterIsNotNull(s, "msg");
        return new BatchsignVersionResponseBean(n, yshouFaVersionBean, n2, s);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof BatchsignVersionResponseBean) {
                final BatchsignVersionResponseBean batchsignVersionResponseBean = (BatchsignVersionResponseBean)o;
                if (this.code == batchsignVersionResponseBean.code && Intrinsics.areEqual(this.data, batchsignVersionResponseBean.data) && this.total == batchsignVersionResponseBean.total && Intrinsics.areEqual(this.msg, batchsignVersionResponseBean.msg)) {
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
    
    public final YshouFaVersionBean getData() {
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
        final YshouFaVersionBean data = this.data;
        int hashCode = 0;
        int hashCode2;
        if (data != null) {
            hashCode2 = data.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final int total = this.total;
        final String msg = this.msg;
        if (msg != null) {
            hashCode = msg.hashCode();
        }
        return ((code * 31 + hashCode2) * 31 + total) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BatchsignVersionResponseBean(code=");
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
