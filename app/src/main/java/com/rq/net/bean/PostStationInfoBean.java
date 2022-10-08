package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public final class PostStationInfoBean
{
    private final String activated_date;
    private final String code;
    private final String deadline;
    private final String icon;
    private final String name;
    private final boolean support_multi;
    
    public PostStationInfoBean(final String code, final String name, final boolean support_multi, final String icon, final String activated_date, final String deadline) {
        this.code = code;
        this.name = name;
        this.support_multi = support_multi;
        this.icon = icon;
        this.activated_date = activated_date;
        this.deadline = deadline;
    }
    
    public final String component1() {
        return this.code;
    }
    
    public final String component2() {
        return this.name;
    }
    
    public final boolean component3() {
        return this.support_multi;
    }
    
    public final String component4() {
        return this.icon;
    }
    
    public final String component5() {
        return this.activated_date;
    }
    
    public final String component6() {
        return this.deadline;
    }
    
    public final PostStationInfoBean copy(final String s, final String s2, final boolean b, final String s3, final String s4, final String s5) {
        return new PostStationInfoBean(s, s2, b, s3, s4, s5);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PostStationInfoBean) {
                final PostStationInfoBean postStationInfoBean = (PostStationInfoBean)o;
                if (Intrinsics.areEqual(this.code, postStationInfoBean.code) && Intrinsics.areEqual(this.name, postStationInfoBean.name) && this.support_multi == postStationInfoBean.support_multi && Intrinsics.areEqual(this.icon, postStationInfoBean.icon) && Intrinsics.areEqual(this.activated_date, postStationInfoBean.activated_date) && Intrinsics.areEqual(this.deadline, postStationInfoBean.deadline)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getActivated_date() {
        return this.activated_date;
    }
    
    public final String getCode() {
        return this.code;
    }
    
    public final String getDeadline() {
        return this.deadline;
    }
    
    public final String getIcon() {
        return this.icon;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public final boolean getSupport_multi() {
        return this.support_multi;
    }
    
    @Override
    public int hashCode() {
        return 0;
        //throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PostStationInfoBean(code=");
        sb.append(this.code);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", support_multi=");
        sb.append(this.support_multi);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", activated_date=");
        sb.append(this.activated_date);
        sb.append(", deadline=");
        sb.append(this.deadline);
        sb.append(")");
        return sb.toString();
    }
}
