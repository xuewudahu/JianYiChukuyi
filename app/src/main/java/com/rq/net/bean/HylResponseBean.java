package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/HylResponseBean;", "", "result", "", "reason", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getReason", "getResult", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class HylResponseBean
{
    private final String code;
    private final String reason;
    private final String result;
    
    public HylResponseBean(final String result, final String reason, final String code) {
        //Intrinsics.checkParameterIsNotNull(result, "result");
        //Intrinsics.checkParameterIsNotNull(reason, "reason");
        //Intrinsics.checkParameterIsNotNull(code, "code");
        this.result = result;
        this.reason = reason;
        this.code = code;
    }
    
    public final String component1() {
        return this.result;
    }
    
    public final String component2() {
        return this.reason;
    }
    
    public final String component3() {
        return this.code;
    }
    
    public final HylResponseBean copy(final String s, final String s2, final String s3) {
        //Intrinsics.checkParameterIsNotNull(s, "result");
        //Intrinsics.checkParameterIsNotNull(s2, "reason");
        //Intrinsics.checkParameterIsNotNull(s3, "code");
        return new HylResponseBean(s, s2, s3);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof HylResponseBean) {
                final HylResponseBean hylResponseBean = (HylResponseBean)o;
                if (Intrinsics.areEqual(this.result, hylResponseBean.result) && Intrinsics.areEqual(this.reason, hylResponseBean.reason) && Intrinsics.areEqual(this.code, hylResponseBean.code)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getCode() {
        return this.code;
    }
    
    public final String getReason() {
        return this.reason;
    }
    
    public final String getResult() {
        return this.result;
    }
    
    @Override
    public int hashCode() {
        final String result = this.result;
        int hashCode = 0;
        int hashCode2;
        if (result != null) {
            hashCode2 = result.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String reason = this.reason;
        int hashCode3;
        if (reason != null) {
            hashCode3 = reason.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String code = this.code;
        if (code != null) {
            hashCode = code.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("HylResponseBean(result=");
        sb.append(this.result);
        sb.append(", reason=");
        sb.append(this.reason);
        sb.append(", code=");
        sb.append(this.code);
        sb.append(")");
        return sb.toString();
    }
}
