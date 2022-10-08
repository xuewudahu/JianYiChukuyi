package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/ZhongYouUploadWeightResponseBean;", "", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class ZhongYouUploadWeightResponseBean
{
    private final int code;
    private final String message;
    
    public ZhongYouUploadWeightResponseBean(final int code, final String message) {
        //Intrinsics.checkParameterIsNotNull(message, "message");
        this.code = code;
        this.message = message;
    }
    
    public final int component1() {
        return this.code;
    }
    
    public final String component2() {
        return this.message;
    }
    
    public final ZhongYouUploadWeightResponseBean copy(final int n, final String s) {
        //Intrinsics.checkParameterIsNotNull(s, "message");
        return new ZhongYouUploadWeightResponseBean(n, s);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof ZhongYouUploadWeightResponseBean) {
                final ZhongYouUploadWeightResponseBean zhongYouUploadWeightResponseBean = (ZhongYouUploadWeightResponseBean)o;
                if (this.code == zhongYouUploadWeightResponseBean.code && Intrinsics.areEqual(this.message, zhongYouUploadWeightResponseBean.message)) {
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
    
    public final String getMessage() {
        return this.message;
    }
    
    @Override
    public int hashCode() {
        final int code = this.code;
        final String message = this.message;
        int hashCode;
        if (message != null) {
            hashCode = message.hashCode();
        }
        else {
            hashCode = 0;
        }
        return code * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ZhongYouUploadWeightResponseBean(code=");
        sb.append(this.code);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(")");
        return sb.toString();
    }
}
