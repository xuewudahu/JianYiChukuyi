package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/BoundDetailList;", "", "pickup_code", "", "waybill_code", "wp_name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPickup_code", "()Ljava/lang/String;", "getWaybill_code", "getWp_name", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class BoundDetailList
{
    private final String pickup_code;
    private final String waybill_code;
    private final String wp_name;
    
    public BoundDetailList(final String pickup_code, final String waybill_code, final String wp_name) {
        this.pickup_code = pickup_code;
        this.waybill_code = waybill_code;
        this.wp_name = wp_name;
    }
    
    public final String component1() {
        return this.pickup_code;
    }
    
    public final String component2() {
        return this.waybill_code;
    }
    
    public final String component3() {
        return this.wp_name;
    }
    
    public final BoundDetailList copy(final String s, final String s2, final String s3) {
        return new BoundDetailList(s, s2, s3);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof BoundDetailList) {
                final BoundDetailList list = (BoundDetailList)o;
                if (Intrinsics.areEqual(this.pickup_code, list.pickup_code) && Intrinsics.areEqual(this.waybill_code, list.waybill_code) && Intrinsics.areEqual(this.wp_name, list.wp_name)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getPickup_code() {
        return this.pickup_code;
    }
    
    public final String getWaybill_code() {
        return this.waybill_code;
    }
    
    public final String getWp_name() {
        return this.wp_name;
    }
    
    @Override
    public int hashCode() {
        final String pickup_code = this.pickup_code;
        int hashCode = 0;
        int hashCode2;
        if (pickup_code != null) {
            hashCode2 = pickup_code.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String waybill_code = this.waybill_code;
        int hashCode3;
        if (waybill_code != null) {
            hashCode3 = waybill_code.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String wp_name = this.wp_name;
        if (wp_name != null) {
            hashCode = wp_name.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BoundDetailList(pickup_code=");
        sb.append(this.pickup_code);
        sb.append(", waybill_code=");
        sb.append(this.waybill_code);
        sb.append(", wp_name=");
        sb.append(this.wp_name);
        sb.append(")");
        return sb.toString();
    }
}
