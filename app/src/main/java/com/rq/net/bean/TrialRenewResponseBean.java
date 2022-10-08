package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006$" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/TrialRenewResponseBean;", "", "serial_number", "", "renew_type", "renew_size", "", "discount", "", "payment_type", "timestamp", "sign", "(Ljava/lang/String;Ljava/lang/String;IFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDiscount", "()F", "getPayment_type", "()Ljava/lang/String;", "getRenew_size", "()I", "getRenew_type", "getSerial_number", "getSign", "getTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class TrialRenewResponseBean
{
    private final float discount;
    private final String payment_type;
    private final int renew_size;
    private final String renew_type;
    private final String serial_number;
    private final String sign;
    private final String timestamp;
    //private Object Intrinsics;

    public TrialRenewResponseBean(final String serial_number, final String renew_type, final int renew_size, final float discount, final String payment_type, final String timestamp, final String sign) {
        //Intrinsics.checkParameterIsNotNull(serial_number, "serial_number");
        //Intrinsics.checkParameterIsNotNull(renew_type, "renew_type");
        //Intrinsics.checkParameterIsNotNull(payment_type, "payment_type");
        //Intrinsics.checkParameterIsNotNull(timestamp, "timestamp");
        //Intrinsics.checkParameterIsNotNull(sign, "sign");
        this.serial_number = serial_number;
        this.renew_type = renew_type;
        this.renew_size = renew_size;
        this.discount = discount;
        this.payment_type = payment_type;
        this.timestamp = timestamp;
        this.sign = sign;
    }
    
    public final String component1() {
        return this.serial_number;
    }
    
    public final String component2() {
        return this.renew_type;
    }
    
    public final int component3() {
        return this.renew_size;
    }
    
    public final float component4() {
        return this.discount;
    }
    
    public final String component5() {
        return this.payment_type;
    }
    
    public final String component6() {
        return this.timestamp;
    }
    
    public final String component7() {
        return this.sign;
    }
    
    public final TrialRenewResponseBean copy(final String s, final String s2, final int n, final float n2, final String s3, final String s4, final String s5) {
        //Intrinsics.checkParameterIsNotNull(s, "serial_number");
        //Intrinsics.checkParameterIsNotNull(s2, "renew_type");
        //Intrinsics.checkParameterIsNotNull(s3, "payment_type");
        //Intrinsics.checkParameterIsNotNull(s4, "timestamp");
        //Intrinsics.checkParameterIsNotNull(s5, "sign");
        return new TrialRenewResponseBean(s, s2, n, n2, s3, s4, s5);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof TrialRenewResponseBean) {
                final TrialRenewResponseBean trialRenewResponseBean = (TrialRenewResponseBean)o;
                if (Intrinsics.areEqual(this.serial_number, trialRenewResponseBean.serial_number) && Intrinsics.areEqual(this.renew_type, trialRenewResponseBean.renew_type) && this.renew_size == trialRenewResponseBean.renew_size && Float.compare(this.discount, trialRenewResponseBean.discount) == 0 && Intrinsics.areEqual(this.payment_type, trialRenewResponseBean.payment_type) && Intrinsics.areEqual(this.timestamp, trialRenewResponseBean.timestamp) && Intrinsics.areEqual(this.sign, trialRenewResponseBean.sign)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final float getDiscount() {
        return this.discount;
    }
    
    public final String getPayment_type() {
        return this.payment_type;
    }
    
    public final int getRenew_size() {
        return this.renew_size;
    }
    
    public final String getRenew_type() {
        return this.renew_type;
    }
    
    public final String getSerial_number() {
        return this.serial_number;
    }
    
    public final String getSign() {
        return this.sign;
    }
    
    public final String getTimestamp() {
        return this.timestamp;
    }
    
    @Override
    public int hashCode() {
        final String serial_number = this.serial_number;
        int hashCode = 0;
        int hashCode2;
        if (serial_number != null) {
            hashCode2 = serial_number.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String renew_type = this.renew_type;
        int hashCode3;
        if (renew_type != null) {
            hashCode3 = renew_type.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final int renew_size = this.renew_size;
        final int floatToIntBits = Float.floatToIntBits(this.discount);
        final String payment_type = this.payment_type;
        int hashCode4;
        if (payment_type != null) {
            hashCode4 = payment_type.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String timestamp = this.timestamp;
        int hashCode5;
        if (timestamp != null) {
            hashCode5 = timestamp.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String sign = this.sign;
        if (sign != null) {
            hashCode = sign.hashCode();
        }
        return (((((hashCode2 * 31 + hashCode3) * 31 + renew_size) * 31 + floatToIntBits) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TrialRenewResponseBean(serial_number=");
        sb.append(this.serial_number);
        sb.append(", renew_type=");
        sb.append(this.renew_type);
        sb.append(", renew_size=");
        sb.append(this.renew_size);
        sb.append(", discount=");
        sb.append(this.discount);
        sb.append(", payment_type=");
        sb.append(this.payment_type);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", sign=");
        sb.append(this.sign);
        sb.append(")");
        return sb.toString();
    }
}
