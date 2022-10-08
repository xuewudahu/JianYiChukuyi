package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public final class PandaOutLibCall
{
    private final String d;
    private final String e;
    private String m;
    private final boolean success;
    
    public PandaOutLibCall(final String m, final String e, final boolean success, final String d) {
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
    
    public final String component4() {
        return this.d;
    }
    
    public final PandaOutLibCall copy(final String s, final String s2, final boolean b, final String s3) {
        //Intrinsics.checkParameterIsNotNull(s, "m");
        //Intrinsics.checkParameterIsNotNull(s2, "e");
        return new PandaOutLibCall(s, s2, b, s3);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PandaOutLibCall) {
                final PandaOutLibCall pandaOutLibCall = (PandaOutLibCall)o;
                if (Intrinsics.areEqual(this.m, pandaOutLibCall.m) && Intrinsics.areEqual(this.e, pandaOutLibCall.e) && this.success == pandaOutLibCall.success && Intrinsics.areEqual(this.d, pandaOutLibCall.d)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getD() {
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
        sb.append("PandaOutLibCall(m=");
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
