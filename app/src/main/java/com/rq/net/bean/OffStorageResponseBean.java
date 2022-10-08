package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/OffStorageResponseBean;", "", "code", "", "msg", "data", "Lcom/yunpan/cobaaidlservice/bean/PackageDataBean;", "(Ljava/lang/String;Ljava/lang/String;Lcom/yunpan/cobaaidlservice/bean/PackageDataBean;)V", "getCode", "()Ljava/lang/String;", "getData", "()Lcom/yunpan/cobaaidlservice/bean/PackageDataBean;", "getMsg", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class OffStorageResponseBean
{
    private final String code;
    private final PackageDataBean data;
    private final String msg;
    
    public OffStorageResponseBean(final String code, final String msg, final PackageDataBean data) {
        //Intrinsics.checkParameterIsNotNull(code, "code");
        //Intrinsics.checkParameterIsNotNull(msg, "msg");
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    public final String component1() {
        return this.code;
    }
    
    public final String component2() {
        return this.msg;
    }
    
    public final PackageDataBean component3() {
        return this.data;
    }
    
    public final OffStorageResponseBean copy(final String s, final String s2, final PackageDataBean packageDataBean) {
        //Intrinsics.checkParameterIsNotNull(s, "code");
        //Intrinsics.checkParameterIsNotNull(s2, "msg");
        return new OffStorageResponseBean(s, s2, packageDataBean);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof OffStorageResponseBean) {
                final OffStorageResponseBean offStorageResponseBean = (OffStorageResponseBean)o;
                if (Intrinsics.areEqual(this.code, offStorageResponseBean.code) && Intrinsics.areEqual(this.msg, offStorageResponseBean.msg) && Intrinsics.areEqual(this.data, offStorageResponseBean.data)) {
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
    
    public final PackageDataBean getData() {
        return this.data;
    }
    
    public final String getMsg() {
        return this.msg;
    }
    
    @Override
    public int hashCode() {
        final String code = this.code;
        int hashCode = 0;
        int hashCode2;
        if (code != null) {
            hashCode2 = code.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String msg = this.msg;
        int hashCode3;
        if (msg != null) {
            hashCode3 = msg.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final PackageDataBean data = this.data;
        if (data != null) {
            hashCode = data.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("OffStorageResponseBean(code=");
        sb.append(this.code);
        sb.append(", msg=");
        sb.append(this.msg);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(")");
        return sb.toString();
    }
}
