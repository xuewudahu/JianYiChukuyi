package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003¢\u0006\u0002\u0010\rJJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r¨\u0006\u001f" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/StationInfoConfigModel;", "", "code", "", "name", "support_multi", "", "icon", "isOpen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "getCode", "()Ljava/lang/String;", "getIcon", "()Ljava/lang/Boolean;", "setOpen", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getName", "getSupport_multi", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/yunpan/cobaaidlservice/bean/StationInfoConfigModel;", "equals", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class StationInfoConfigModel
{
    private final String code;
    private final String icon;
    private Boolean isOpen;
    private final String name;
    private final Boolean support_multi;
    
    public StationInfoConfigModel(final String code, final String name, final Boolean support_multi, final String icon, final Boolean isOpen) {
        this.code = code;
        this.name = name;
        this.support_multi = support_multi;
        this.icon = icon;
        this.isOpen = isOpen;
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
    
    public final String component4() {
        return this.icon;
    }
    
    public final Boolean component5() {
        return this.isOpen;
    }
    
    public final StationInfoConfigModel copy(final String s, final String s2, final Boolean b, final String s3, final Boolean b2) {
        return new StationInfoConfigModel(s, s2, b, s3, b2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof StationInfoConfigModel) {
                final StationInfoConfigModel stationInfoConfigModel = (StationInfoConfigModel)o;
                if (Intrinsics.areEqual(this.code, stationInfoConfigModel.code) && Intrinsics.areEqual(this.name, stationInfoConfigModel.name) && Intrinsics.areEqual(this.support_multi, stationInfoConfigModel.support_multi) && Intrinsics.areEqual(this.icon, stationInfoConfigModel.icon) && Intrinsics.areEqual(this.isOpen, stationInfoConfigModel.isOpen)) {
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
    
    public final Boolean getSupport_multi() {
        return this.support_multi;
    }
    
    @Override
    public int hashCode() {
        final String code = this.code;
        int hashCode = 0;
        int hashCode2;
        if (code != null) {
            hashCode2 = code.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String name = this.name;
        int hashCode3;
        if (name != null) {
            hashCode3 = name.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final Boolean support_multi = this.support_multi;
        int hashCode4;
        if (support_multi != null) {
            hashCode4 = support_multi.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String icon = this.icon;
        int hashCode5;
        if (icon != null) {
            hashCode5 = icon.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final Boolean isOpen = this.isOpen;
        if (isOpen != null) {
            hashCode = isOpen.hashCode();
        }
        return (((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode;
    }
    
    public final Boolean isOpen() {
        return this.isOpen;
    }
    
    public final void setOpen(final Boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("StationInfoConfigModel(code=");
        sb.append(this.code);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", support_multi=");
        sb.append(this.support_multi);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", isOpen=");
        sb.append(this.isOpen);
        sb.append(")");
        return sb.toString();
    }
}
