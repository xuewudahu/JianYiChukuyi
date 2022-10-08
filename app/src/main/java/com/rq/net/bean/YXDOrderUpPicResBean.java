package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/YXDOrderUpPicResBean;", "", "cosKey", "", "cosUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getCosKey", "()Ljava/lang/String;", "getCosUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class YXDOrderUpPicResBean
{
    private final String cosKey;
    private final String cosUrl;
    
    public YXDOrderUpPicResBean(final String cosKey, final String cosUrl) {
        //Intrinsics.checkParameterIsNotNull(cosKey, "cosKey");
        //Intrinsics.checkParameterIsNotNull(cosUrl, "cosUrl");
        this.cosKey = cosKey;
        this.cosUrl = cosUrl;
    }
    
    public final String component1() {
        return this.cosKey;
    }
    
    public final String component2() {
        return this.cosUrl;
    }
    
    public final YXDOrderUpPicResBean copy(final String s, final String s2) {
        //Intrinsics.checkParameterIsNotNull(s, "cosKey");
        //Intrinsics.checkParameterIsNotNull(s2, "cosUrl");
        return new YXDOrderUpPicResBean(s, s2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof YXDOrderUpPicResBean) {
                final YXDOrderUpPicResBean yxdOrderUpPicResBean = (YXDOrderUpPicResBean)o;
                if (Intrinsics.areEqual(this.cosKey, yxdOrderUpPicResBean.cosKey) && Intrinsics.areEqual(this.cosUrl, yxdOrderUpPicResBean.cosUrl)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getCosKey() {
        return this.cosKey;
    }
    
    public final String getCosUrl() {
        return this.cosUrl;
    }
    
    @Override
    public int hashCode() {
        final String cosKey = this.cosKey;
        int hashCode = 0;
        int hashCode2;
        if (cosKey != null) {
            hashCode2 = cosKey.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String cosUrl = this.cosUrl;
        if (cosUrl != null) {
            hashCode = cosUrl.hashCode();
        }
        return hashCode2 * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("YXDOrderUpPicResBean(cosKey=");
        sb.append(this.cosKey);
        sb.append(", cosUrl=");
        sb.append(this.cosUrl);
        sb.append(")");
        return sb.toString();
    }
}
