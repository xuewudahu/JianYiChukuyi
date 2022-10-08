package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public final class StationInfoBean
{
    private final String code;
    private final String icon;
    private final boolean isSelect;
    private final Boolean is_buyed;
    private final Boolean is_special;
    private final String name;
    private final String station_price;
    private final Boolean support_multi;
    
    public StationInfoBean(final String code, final String name, final Boolean support_multi, final Boolean is_special, final Boolean is_buyed, final String station_price, final String icon, final boolean isSelect) {
        //Intrinsics.checkParameterIsNotNull(code, "code");
        //Intrinsics.checkParameterIsNotNull(name, "name");
        //Intrinsics.checkParameterIsNotNull(station_price, "station_price");
        this.code = code;
        this.name = name;
        this.support_multi = support_multi;
        this.is_special = is_special;
        this.is_buyed = is_buyed;
        this.station_price = station_price;
        this.icon = icon;
        this.isSelect = isSelect;
    }
    
    public final String component1() {
        return this.code;
    }
    
    public final String component2() {
        return this.name;
    }
    
    public final Boolean component3() {
        return this.support_multi;
    }
    
    public final Boolean component4() {
        return this.is_special;
    }
    
    public final Boolean component5() {
        return this.is_buyed;
    }
    
    public final String component6() {
        return this.station_price;
    }
    
    public final String component7() {
        return this.icon;
    }
    
    public final boolean component8() {
        return this.isSelect;
    }
    
    public final StationInfoBean copy(final String s, final String s2, final Boolean b, final Boolean b2, final Boolean b3, final String s3, final String s4, final boolean b4) {
        //Intrinsics.checkParameterIsNotNull(s, "code");
        //Intrinsics.checkParameterIsNotNull(s2, "name");
        //Intrinsics.checkParameterIsNotNull(s3, "station_price");
        return new StationInfoBean(s, s2, b, b2, b3, s3, s4, b4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof StationInfoBean) {
                final StationInfoBean stationInfoBean = (StationInfoBean)o;
                if (Intrinsics.areEqual(this.code, stationInfoBean.code) && Intrinsics.areEqual(this.name, stationInfoBean.name) && Intrinsics.areEqual(this.support_multi, stationInfoBean.support_multi) && Intrinsics.areEqual(this.is_special, stationInfoBean.is_special) && Intrinsics.areEqual(this.is_buyed, stationInfoBean.is_buyed) && Intrinsics.areEqual(this.station_price, stationInfoBean.station_price) && Intrinsics.areEqual(this.icon, stationInfoBean.icon) && this.isSelect == stationInfoBean.isSelect) {
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
    
    public final String getIcon() {
        return this.icon;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public final String getStation_price() {
        return this.station_price;
    }
    
    public final Boolean getSupport_multi() {
        return this.support_multi;
    }
    
    @Override
    public int hashCode() {
        return 0;
       // throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    public final boolean isSelect() {
        return this.isSelect;
    }
    
    public final Boolean is_buyed() {
        return this.is_buyed;
    }
    
    public final Boolean is_special() {
        return this.is_special;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("StationInfoBean(code=");
        sb.append(this.code);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", support_multi=");
        sb.append(this.support_multi);
        sb.append(", is_special=");
        sb.append(this.is_special);
        sb.append(", is_buyed=");
        sb.append(this.is_buyed);
        sb.append(", station_price=");
        sb.append(this.station_price);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", isSelect=");
        sb.append(this.isSelect);
        sb.append(")");
        return sb.toString();
    }
}
