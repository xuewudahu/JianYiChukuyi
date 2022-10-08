package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/ZyztCallBack;", "", "status", "", "statusCode", "", "message", "(ZLjava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getStatus", "()Z", "getStatusCode", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class ZyztCallBack
{
    private final String message;
    private final boolean status;
    private final String statusCode;
    
    public ZyztCallBack(final boolean status, final String statusCode, final String message) {
        //Intrinsics.checkParameterIsNotNull(statusCode, "statusCode");
        //Intrinsics.checkParameterIsNotNull(message, "message");
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
    }
    
    public final boolean component1() {
        return this.status;
    }
    
    public final String component2() {
        return this.statusCode;
    }
    
    public final String component3() {
        return this.message;
    }
    
    public final ZyztCallBack copy(final boolean b, final String s, final String s2) {
        //Intrinsics.checkParameterIsNotNull(s, "statusCode");
        //Intrinsics.checkParameterIsNotNull(s2, "message");
        return new ZyztCallBack(b, s, s2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof ZyztCallBack) {
                final ZyztCallBack zyztCallBack = (ZyztCallBack)o;
                if (this.status == zyztCallBack.status && Intrinsics.areEqual(this.statusCode, zyztCallBack.statusCode) && Intrinsics.areEqual(this.message, zyztCallBack.message)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getMessage() {
        return this.message;
    }
    
    public final boolean getStatus() {
        return this.status;
    }
    
    public final String getStatusCode() {
        return this.statusCode;
    }
    
    @Override
    public int hashCode() {
        return 0;
        //throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ZyztCallBack(status=");
        sb.append(this.status);
        sb.append(", statusCode=");
        sb.append(this.statusCode);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(")");
        return sb.toString();
    }
}
