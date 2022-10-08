package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/DuoDuoPhone;", "", "customer_name", "", "mobile", "waybill_code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCustomer_name", "()Ljava/lang/String;", "setCustomer_name", "(Ljava/lang/String;)V", "getMobile", "setMobile", "getWaybill_code", "setWaybill_code", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class DuoDuoPhone
{
    private String customer_name;
    private String mobile;
    private String waybill_code;
    
    public DuoDuoPhone() {
        this(null, null, null);
    }
    
    public DuoDuoPhone(final String customer_name, final String mobile, final String waybill_code) {
        //Intrinsics.checkParameterIsNotNull(customer_name, "customer_name");
        //Intrinsics.checkParameterIsNotNull(mobile, "mobile");
        //Intrinsics.checkParameterIsNotNull(waybill_code, "waybill_code");
        this.customer_name = customer_name;
        this.mobile = mobile;
        this.waybill_code = waybill_code;
    }
    
    public final String component1() {
        return this.customer_name;
    }
    
    public final String component2() {
        return this.mobile;
    }
    
    public final String component3() {
        return this.waybill_code;
    }
    
    public final DuoDuoPhone copy(final String s, final String s2, final String s3) {
        //Intrinsics.checkParameterIsNotNull(s, "customer_name");
        //Intrinsics.checkParameterIsNotNull(s2, "mobile");
        //Intrinsics.checkParameterIsNotNull(s3, "waybill_code");
        return new DuoDuoPhone(s, s2, s3);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof DuoDuoPhone) {
                final DuoDuoPhone duoDuoPhone = (DuoDuoPhone)o;
                if (Intrinsics.areEqual(this.customer_name, duoDuoPhone.customer_name) && Intrinsics.areEqual(this.mobile, duoDuoPhone.mobile) && Intrinsics.areEqual(this.waybill_code, duoDuoPhone.waybill_code)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getCustomer_name() {
        return this.customer_name;
    }
    
    public final String getMobile() {
        return this.mobile;
    }
    
    public final String getWaybill_code() {
        return this.waybill_code;
    }
    
    @Override
    public int hashCode() {
        final String customer_name = this.customer_name;
        int hashCode = 0;
        int hashCode2;
        if (customer_name != null) {
            hashCode2 = customer_name.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String mobile = this.mobile;
        int hashCode3;
        if (mobile != null) {
            hashCode3 = mobile.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String waybill_code = this.waybill_code;
        if (waybill_code != null) {
            hashCode = waybill_code.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    public final void setCustomer_name(final String customer_name) {
        //Intrinsics.checkParameterIsNotNull(customer_name, "<set-?>");
        this.customer_name = customer_name;
    }
    
    public final void setMobile(final String mobile) {
        //Intrinsics.checkParameterIsNotNull(mobile, "<set-?>");
        this.mobile = mobile;
    }
    
    public final void setWaybill_code(final String waybill_code) {
        //Intrinsics.checkParameterIsNotNull(waybill_code, "<set-?>");
        this.waybill_code = waybill_code;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DuoDuoPhone(customer_name=");
        sb.append(this.customer_name);
        sb.append(", mobile=");
        sb.append(this.mobile);
        sb.append(", waybill_code=");
        sb.append(this.waybill_code);
        sb.append(")");
        return sb.toString();
    }
}
