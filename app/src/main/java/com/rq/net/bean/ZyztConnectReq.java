package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/ZyztConnectReq;", "", "data", "", "sign", "(Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getSign", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class ZyztConnectReq
{
    private final String data;
    private final String sign;
    
    public ZyztConnectReq(final String data, final String sign) {
        //Intrinsics.checkParameterIsNotNull(data, "data");
        //Intrinsics.checkParameterIsNotNull(sign, "sign");
        this.data = data;
        this.sign = sign;
    }
    
    public final String component1() {
        return this.data;
    }
    
    public final String component2() {
        return this.sign;
    }
    
    public final ZyztConnectReq copy(final String s, final String s2) {
        //Intrinsics.checkParameterIsNotNull(s, "data");
        //Intrinsics.checkParameterIsNotNull(s2, "sign");
        return new ZyztConnectReq(s, s2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof ZyztConnectReq) {
                final ZyztConnectReq zyztConnectReq = (ZyztConnectReq)o;
                if (Intrinsics.areEqual(this.data, zyztConnectReq.data) && Intrinsics.areEqual(this.sign, zyztConnectReq.sign)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getData() {
        return this.data;
    }
    
    public final String getSign() {
        return this.sign;
    }
    
    @Override
    public int hashCode() {
        final String data = this.data;
        int hashCode = 0;
        int hashCode2;
        if (data != null) {
            hashCode2 = data.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String sign = this.sign;
        if (sign != null) {
            hashCode = sign.hashCode();
        }
        return hashCode2 * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ZyztConnectReq(data=");
        sb.append(this.data);
        sb.append(", sign=");
        sb.append(this.sign);
        sb.append(")");
        return sb.toString();
    }
}
