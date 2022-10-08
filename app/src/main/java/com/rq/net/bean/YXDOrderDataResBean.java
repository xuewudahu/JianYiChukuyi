package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/YXDOrderDataResBean;", "", "billCode", "", "expressBrandCode", "pickupCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBillCode", "()Ljava/lang/String;", "getExpressBrandCode", "getPickupCode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class YXDOrderDataResBean
{
    private final String billCode;
    private final String expressBrandCode;
    private final String pickupCode;
    
    public YXDOrderDataResBean(final String billCode, final String expressBrandCode, final String pickupCode) {
        //Intrinsics.checkParameterIsNotNull(billCode, "billCode");
        //Intrinsics.checkParameterIsNotNull(expressBrandCode, "expressBrandCode");
        //Intrinsics.checkParameterIsNotNull(pickupCode, "pickupCode");
        this.billCode = billCode;
        this.expressBrandCode = expressBrandCode;
        this.pickupCode = pickupCode;
    }
    
    public final String component1() {
        return this.billCode;
    }
    
    public final String component2() {
        return this.expressBrandCode;
    }
    
    public final String component3() {
        return this.pickupCode;
    }
    
    public final YXDOrderDataResBean copy(final String s, final String s2, final String s3) {
        //Intrinsics.checkParameterIsNotNull(s, "billCode");
        //Intrinsics.checkParameterIsNotNull(s2, "expressBrandCode");
        //Intrinsics.checkParameterIsNotNull(s3, "pickupCode");
        return new YXDOrderDataResBean(s, s2, s3);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof YXDOrderDataResBean) {
                final YXDOrderDataResBean yxdOrderDataResBean = (YXDOrderDataResBean)o;
                if (Intrinsics.areEqual(this.billCode, yxdOrderDataResBean.billCode) && Intrinsics.areEqual(this.expressBrandCode, yxdOrderDataResBean.expressBrandCode) && Intrinsics.areEqual(this.pickupCode, yxdOrderDataResBean.pickupCode)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getBillCode() {
        return this.billCode;
    }
    
    public final String getExpressBrandCode() {
        return this.expressBrandCode;
    }
    
    public final String getPickupCode() {
        return this.pickupCode;
    }
    
    @Override
    public int hashCode() {
        final String billCode = this.billCode;
        int hashCode = 0;
        int hashCode2;
        if (billCode != null) {
            hashCode2 = billCode.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String expressBrandCode = this.expressBrandCode;
        int hashCode3;
        if (expressBrandCode != null) {
            hashCode3 = expressBrandCode.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String pickupCode = this.pickupCode;
        if (pickupCode != null) {
            hashCode = pickupCode.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("YXDOrderDataResBean(billCode=");
        sb.append(this.billCode);
        sb.append(", expressBrandCode=");
        sb.append(this.expressBrandCode);
        sb.append(", pickupCode=");
        sb.append(this.pickupCode);
        sb.append(")");
        return sb.toString();
    }
}
