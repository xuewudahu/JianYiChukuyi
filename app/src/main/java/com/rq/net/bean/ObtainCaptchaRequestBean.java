package com.rq.net.bean;

public class ObtainCaptchaRequestBean {
    private boolean station;

    public ObtainCaptchaRequestBean(boolean var1) {
        this.station = var1;
    }

    // $FF: synthetic method
    public static ObtainCaptchaRequestBean copy$default(ObtainCaptchaRequestBean var0, boolean var1, int var2, Object var3) {
        if ((var2 & 1) != 0) {
            var1 = var0.station;
        }

        return var0.copy(var1);
    }

    public final boolean component1() {
        return this.station;
    }

    public final ObtainCaptchaRequestBean copy(boolean var1) {
        return new ObtainCaptchaRequestBean(var1);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (!(var1 instanceof ObtainCaptchaRequestBean)) {
                return false;
            }

            ObtainCaptchaRequestBean var2 = (ObtainCaptchaRequestBean)var1;
            if (this.station != var2.station) {
                return false;
            }
        }

        return true;
    }

    public final boolean getStation() {
        return this.station;
    }

    public int hashCode() {
        throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public final void setStation(boolean var1) {
        this.station = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("ObtainCaptchaRequestBean(station=");
        var1.append(this.station);
        var1.append(")");
        return var1.toString();
    }
}
