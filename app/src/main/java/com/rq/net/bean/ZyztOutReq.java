package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/ZyztOutReq;", "", "V_MARK", "", "V_YJHM", "V_MDQZZ", "V_RLSBZB", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getV_MARK", "()Ljava/lang/String;", "getV_MDQZZ", "getV_RLSBZB", "getV_YJHM", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class ZyztOutReq
{
    private final String V_MARK;
    private final String V_MDQZZ;
    private final String V_RLSBZB;
    private final String V_YJHM;
    
    public ZyztOutReq(final String v_MARK, final String v_YJHM, final String v_MDQZZ, final String v_RLSBZB) {
        //Intrinsics.checkParameterIsNotNull(v_MARK, "V_MARK");
        //Intrinsics.checkParameterIsNotNull(v_YJHM, "V_YJHM");
        //Intrinsics.checkParameterIsNotNull(v_MDQZZ, "V_MDQZZ");
        //Intrinsics.checkParameterIsNotNull(v_RLSBZB, "V_RLSBZB");
        this.V_MARK = v_MARK;
        this.V_YJHM = v_YJHM;
        this.V_MDQZZ = v_MDQZZ;
        this.V_RLSBZB = v_RLSBZB;
    }
    
    public final String component1() {
        return this.V_MARK;
    }
    
    public final String component2() {
        return this.V_YJHM;
    }
    
    public final String component3() {
        return this.V_MDQZZ;
    }
    
    public final String component4() {
        return this.V_RLSBZB;
    }
    
    public final ZyztOutReq copy(final String s, final String s2, final String s3, final String s4) {
        //Intrinsics.checkParameterIsNotNull(s, "V_MARK");
        //Intrinsics.checkParameterIsNotNull(s2, "V_YJHM");
        //Intrinsics.checkParameterIsNotNull(s3, "V_MDQZZ");
        //Intrinsics.checkParameterIsNotNull(s4, "V_RLSBZB");
        return new ZyztOutReq(s, s2, s3, s4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof ZyztOutReq) {
                final ZyztOutReq zyztOutReq = (ZyztOutReq)o;
                if (Intrinsics.areEqual(this.V_MARK, zyztOutReq.V_MARK) && Intrinsics.areEqual(this.V_YJHM, zyztOutReq.V_YJHM) && Intrinsics.areEqual(this.V_MDQZZ, zyztOutReq.V_MDQZZ) && Intrinsics.areEqual(this.V_RLSBZB, zyztOutReq.V_RLSBZB)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getV_MARK() {
        return this.V_MARK;
    }
    
    public final String getV_MDQZZ() {
        return this.V_MDQZZ;
    }
    
    public final String getV_RLSBZB() {
        return this.V_RLSBZB;
    }
    
    public final String getV_YJHM() {
        return this.V_YJHM;
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
        final String v_YJHM = this.V_YJHM;
        int hashCode3;
        if (v_YJHM != null) {
            hashCode3 = v_YJHM.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String v_MDQZZ = this.V_MDQZZ;
        int hashCode4;
        if (v_MDQZZ != null) {
            hashCode4 = v_MDQZZ.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String v_RLSBZB = this.V_RLSBZB;
        if (v_RLSBZB != null) {
            hashCode = v_RLSBZB.hashCode();
        }
        return ((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ZyztOutReq(V_MARK=");
        sb.append(this.V_MARK);
        sb.append(", V_YJHM=");
        sb.append(this.V_YJHM);
        sb.append(", V_MDQZZ=");
        sb.append(this.V_MDQZZ);
        sb.append(", V_RLSBZB=");
        sb.append(this.V_RLSBZB);
        sb.append(")");
        return sb.toString();
    }
}
