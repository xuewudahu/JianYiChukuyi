package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/ZyztLoginReq;", "", "V_MARK", "", "V_JGBH", "(Ljava/lang/String;Ljava/lang/String;)V", "getV_JGBH", "()Ljava/lang/String;", "getV_MARK", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class ZyztLoginReq
{
    private final String V_JGBH;
    private final String V_MARK;
    
    public ZyztLoginReq(final String v_MARK, final String v_JGBH) {
        //Intrinsics.checkParameterIsNotNull(v_MARK, "V_MARK");
        //Intrinsics.checkParameterIsNotNull(v_JGBH, "V_JGBH");
        this.V_MARK = v_MARK;
        this.V_JGBH = v_JGBH;
    }
    
    public final String component1() {
        return this.V_MARK;
    }
    
    public final String component2() {
        return this.V_JGBH;
    }
    
    public final ZyztLoginReq copy(final String s, final String s2) {
        //Intrinsics.checkParameterIsNotNull(s, "V_MARK");
        //Intrinsics.checkParameterIsNotNull(s2, "V_JGBH");
        return new ZyztLoginReq(s, s2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof ZyztLoginReq) {
                final ZyztLoginReq zyztLoginReq = (ZyztLoginReq)o;
                if (Intrinsics.areEqual(this.V_MARK, zyztLoginReq.V_MARK) && Intrinsics.areEqual(this.V_JGBH, zyztLoginReq.V_JGBH)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getV_JGBH() {
        return this.V_JGBH;
    }
    
    public final String getV_MARK() {
        return this.V_MARK;
    }
    
    @Override
    public int hashCode() {
        final String v_MARK = this.V_MARK;
        int hashCode = 0;
        int hashCode2;
        if (v_MARK != null) {
            hashCode2 = v_MARK.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String v_JGBH = this.V_JGBH;
        if (v_JGBH != null) {
            hashCode = v_JGBH.hashCode();
        }
        return hashCode2 * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ZyztLoginReq(V_MARK=");
        sb.append(this.V_MARK);
        sb.append(", V_JGBH=");
        sb.append(this.V_JGBH);
        sb.append(")");
        return sb.toString();
    }
}
