package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00018\u0000H\u00c6\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000H\u00c6\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0004H\u00d6\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/PandaBeanCall;", "T", "", "m", "", "e", "success", "", "d", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V", "getD", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getE", "()Ljava/lang/String;", "getM", "setM", "(Ljava/lang/String;)V", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)Lcom/yunpan/cobaaidlservice/bean/PandaBeanCall;", "equals", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class PandaBeanCall<T>
{
    private final T d;
    private final String e;
    private String m;
    private final boolean success;
    
    public PandaBeanCall(final String m, final String e, final boolean success, final T d) {
        //Intrinsics.checkParameterIsNotNull(m, "m");
        //Intrinsics.checkParameterIsNotNull(e, "e");
        this.m = m;
        this.e = e;
        this.success = success;
        this.d = d;
    }
    
    public final String component1() {
        return this.m;
    }
    
    public final String component2() {
        return this.e;
    }
    
    public final boolean component3() {
        return this.success;
    }
    
    public final T component4() {
        return this.d;
    }
    
    public final PandaBeanCall<T> copy(final String s, final String s2, final boolean b, final T t) {
        //Intrinsics.checkParameterIsNotNull(s, "m");
        //Intrinsics.checkParameterIsNotNull(s2, "e");
        return new PandaBeanCall<T>(s, s2, b, t);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PandaBeanCall) {
                final PandaBeanCall pandaBeanCall = (PandaBeanCall)o;
                if (Intrinsics.areEqual(this.m, pandaBeanCall.m) && Intrinsics.areEqual(this.e, pandaBeanCall.e) && this.success == pandaBeanCall.success && Intrinsics.areEqual(this.d, pandaBeanCall.d)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final T getD() {
        return this.d;
    }
    
    public final String getE() {
        return this.e;
    }
    
    public final String getM() {
        return this.m;
    }
    
    public final boolean getSuccess() {
        return this.success;
    }
    
    @Override
    public int hashCode() {
        return 0;
        //throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    public final void setM(final String m) {
        //Intrinsics.checkParameterIsNotNull(m, "<set-?>");
        this.m = m;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PandaBeanCall(m=");
        sb.append(this.m);
        sb.append(", e=");
        sb.append(this.e);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(", d=");
        sb.append(this.d);
        sb.append(")");
        return sb.toString();
    }
}
