package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003Jf\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u00c6\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020&H\u00d6\u0001J\t\u0010'\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0010\"\u0004\b\u0013\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014¨\u0006(" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/StationInfoModel;", "", "code", "", "name", "station_price", "support_multi", "", "is_special", "icon", "isOpen", "isSelected", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;ZZ)V", "getCode", "()Ljava/lang/String;", "getIcon", "()Z", "setOpen", "(Z)V", "setSelected", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getStation_price", "getSupport_multi", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;ZZ)Lcom/yunpan/cobaaidlservice/bean/StationInfoModel;", "equals", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class StationInfoModel
{
    private final String code;
    private final String icon;
    private boolean isOpen;
    private boolean isSelected;
    private final Boolean is_special;
    private final String name;
    private final String station_price;
    private final Boolean support_multi;
    
    public StationInfoModel(final String code, final String name, final String station_price, final Boolean support_multi, final Boolean is_special, final String icon, final boolean isOpen, final boolean isSelected) {
        //Intrinsics.checkParameterIsNotNull(code, "code");
        //Intrinsics.checkParameterIsNotNull(name, "name");
        this.code = code;
        this.name = name;
        this.station_price = station_price;
        this.support_multi = support_multi;
        this.is_special = is_special;
        this.icon = icon;
        this.isOpen = isOpen;
        this.isSelected = isSelected;
    }
    
    public final String component1() {
        return this.code;
    }
    
    public final String component2() {
        return this.name;
    }
    
    public final String component3() {
        return this.station_price;
    }
    
    public final Boolean component4() {
        return this.support_multi;
    }
    
    public final Boolean component5() {
        return this.is_special;
    }
    
    public final String component6() {
        return this.icon;
    }
    
    public final boolean component7() {
        return this.isOpen;
    }
    
    public final boolean component8() {
        return this.isSelected;
    }
    
    public final StationInfoModel copy(final String s, final String s2, final String s3, final Boolean b, final Boolean b2, final String s4, final boolean b3, final boolean b4) {
        //Intrinsics.checkParameterIsNotNull(s, "code");
        //Intrinsics.checkParameterIsNotNull(s2, "name");
        return new StationInfoModel(s, s2, s3, b, b2, s4, b3, b4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof StationInfoModel) {
                final StationInfoModel stationInfoModel = (StationInfoModel)o;
                if (Intrinsics.areEqual(this.code, stationInfoModel.code) && Intrinsics.areEqual(this.name, stationInfoModel.name) && Intrinsics.areEqual(this.station_price, stationInfoModel.station_price) && Intrinsics.areEqual(this.support_multi, stationInfoModel.support_multi) && Intrinsics.areEqual(this.is_special, stationInfoModel.is_special) && Intrinsics.areEqual(this.icon, stationInfoModel.icon) && this.isOpen == stationInfoModel.isOpen && this.isSelected == stationInfoModel.isSelected) {
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
        //throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    public final boolean isOpen() {
        return this.isOpen;
    }
    
    public final boolean isSelected() {
        return this.isSelected;
    }
    
    public final Boolean is_special() {
        return this.is_special;
    }
    
    public final void setOpen(final boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    public final void setSelected(final boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("StationInfoModel(code=");
        sb.append(this.code);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", station_price=");
        sb.append(this.station_price);
        sb.append(", support_multi=");
        sb.append(this.support_multi);
        sb.append(", is_special=");
        sb.append(this.is_special);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", isOpen=");
        sb.append(this.isOpen);
        sb.append(", isSelected=");
        sb.append(this.isSelected);
        sb.append(")");
        return sb.toString();
    }
}
