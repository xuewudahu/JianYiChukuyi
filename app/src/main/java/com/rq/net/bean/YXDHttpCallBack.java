package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00018\u0000H\u00c6\u0003¢\u0006\u0002\u0010\u000eJN\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000H\u00c6\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0006H\u00d6\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006 " }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/YXDHttpCallBack;", "T", "", "success", "", "msg", "", "code", "traceCode", "data", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getCode", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMsg", "getSuccess", "()Z", "getTraceCode", "component1", "component2", "component3", "component4", "component5", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/yunpan/cobaaidlservice/bean/YXDHttpCallBack;", "equals", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class YXDHttpCallBack<T>
{
    private final String code;
    private final T data;
    private final String msg;
    private final boolean success;
    private final String traceCode;
    
    public YXDHttpCallBack(final boolean success, final String msg, final String code, final String traceCode, final T data) {
        this.success = success;
        this.msg = msg;
        this.code = code;
        this.traceCode = traceCode;
        this.data = data;
    }
    
    public final boolean component1() {
        return this.success;
    }
    
    public final String component2() {
        return this.msg;
    }
    
    public final String component3() {
        return this.code;
    }
    
    public final String component4() {
        return this.traceCode;
    }
    
    public final T component5() {
        return this.data;
    }
    
    public final YXDHttpCallBack<T> copy(final boolean b, final String s, final String s2, final String s3, final T t) {
        return new YXDHttpCallBack<T>(b, s, s2, s3, t);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof YXDHttpCallBack) {
                final YXDHttpCallBack yxdHttpCallBack = (YXDHttpCallBack)o;
                if (this.success == yxdHttpCallBack.success && Intrinsics.areEqual(this.msg, yxdHttpCallBack.msg) && Intrinsics.areEqual(this.code, yxdHttpCallBack.code) && Intrinsics.areEqual(this.traceCode, yxdHttpCallBack.traceCode) && Intrinsics.areEqual(this.data, yxdHttpCallBack.data)) {
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
    
    public final T getData() {
        return this.data;
    }
    
    public final String getMsg() {
        return this.msg;
    }
    
    public final boolean getSuccess() {
        return this.success;
    }
    
    public final String getTraceCode() {
        return this.traceCode;
    }
    
    @Override
    public int hashCode() {
        return 0;
        //throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("YXDHttpCallBack(success=");
        sb.append(this.success);
        sb.append(", msg=");
        sb.append(this.msg);
        sb.append(", code=");
        sb.append(this.code);
        sb.append(", traceCode=");
        sb.append(this.traceCode);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(")");
        return sb.toString();
    }
}
