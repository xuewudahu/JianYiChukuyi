package com.rq.net.bean;

//import kotlin.*;
import com.rq.net.util.Intrinsics;

import java.util.*;
//import kotlin.jvm.internal.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007H\u00c6\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\\\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020\u0007H\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015¨\u0006+" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/PurchaseAuthCodeV2ReqBean;", "", "serial_number", "", "station_codes", "", "payment_type", "", "is_buy", "timestamp", "sign", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/Integer;", "set_buy", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPayment_type", "setPayment_type", "getSerial_number", "()Ljava/lang/String;", "setSerial_number", "(Ljava/lang/String;)V", "getSign", "setSign", "getStation_codes", "()Ljava/util/List;", "setStation_codes", "(Ljava/util/List;)V", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/yunpan/cobaaidlservice/bean/PurchaseAuthCodeV2ReqBean;", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class PurchaseAuthCodeV2ReqBean
{
    private Integer is_buy;
    private Integer payment_type;
    private String serial_number;
    private String sign;
    private List<String> station_codes;
    private String timestamp;
    
    public PurchaseAuthCodeV2ReqBean(final String serial_number, final List<String> station_codes, final Integer payment_type, final Integer is_buy, final String timestamp, final String sign) {
        this.serial_number = serial_number;
        this.station_codes = station_codes;
        this.payment_type = payment_type;
        this.is_buy = is_buy;
        this.timestamp = timestamp;
        this.sign = sign;
    }
    
    public final String component1() {
        return this.serial_number;
    }
    
    public final List<String> component2() {
        return this.station_codes;
    }
    
    public final Integer component3() {
        return this.payment_type;
    }
    
    public final Integer component4() {
        return this.is_buy;
    }
    
    public final String component5() {
        return this.timestamp;
    }
    
    public final String component6() {
        return this.sign;
    }
    
    public final PurchaseAuthCodeV2ReqBean copy(final String s, final List<String> list, final Integer n, final Integer n2, final String s2, final String s3) {
        return new PurchaseAuthCodeV2ReqBean(s, list, n, n2, s2, s3);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PurchaseAuthCodeV2ReqBean) {
                final PurchaseAuthCodeV2ReqBean purchaseAuthCodeV2ReqBean = (PurchaseAuthCodeV2ReqBean)o;
                if (Intrinsics.areEqual(this.serial_number, purchaseAuthCodeV2ReqBean.serial_number) && Intrinsics.areEqual(this.station_codes, purchaseAuthCodeV2ReqBean.station_codes) && Intrinsics.areEqual(this.payment_type, purchaseAuthCodeV2ReqBean.payment_type) && Intrinsics.areEqual(this.is_buy, purchaseAuthCodeV2ReqBean.is_buy) && Intrinsics.areEqual(this.timestamp, purchaseAuthCodeV2ReqBean.timestamp) && Intrinsics.areEqual(this.sign, purchaseAuthCodeV2ReqBean.sign)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final Integer getPayment_type() {
        return this.payment_type;
    }
    
    public final String getSerial_number() {
        return this.serial_number;
    }
    
    public final String getSign() {
        return this.sign;
    }
    
    public final List<String> getStation_codes() {
        return this.station_codes;
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
        final List<String> station_codes = this.station_codes;
        int hashCode3;
        if (station_codes != null) {
            hashCode3 = station_codes.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final Integer payment_type = this.payment_type;
        int hashCode4;
        if (payment_type != null) {
            hashCode4 = payment_type.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final Integer is_buy = this.is_buy;
        int hashCode5;
        if (is_buy != null) {
            hashCode5 = is_buy.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String timestamp = this.timestamp;
        int hashCode6;
        if (timestamp != null) {
            hashCode6 = timestamp.hashCode();
        }
        else {
            hashCode6 = 0;
        }
        final String sign = this.sign;
        if (sign != null) {
            hashCode = sign.hashCode();
        }
        return ((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode;
    }
    
    public final Integer is_buy() {
        return this.is_buy;
    }
    
    public final void setPayment_type(final Integer payment_type) {
        this.payment_type = payment_type;
    }
    
    public final void setSerial_number(final String serial_number) {
        this.serial_number = serial_number;
    }
    
    public final void setSign(final String sign) {
        this.sign = sign;
    }
    
    public final void setStation_codes(final List<String> station_codes) {
        this.station_codes = station_codes;
    }
    
    public final void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }
    
    public final void set_buy(final Integer is_buy) {
        this.is_buy = is_buy;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PurchaseAuthCodeV2ReqBean(serial_number=");
        sb.append(this.serial_number);
        sb.append(", station_codes=");
        sb.append(this.station_codes);
        sb.append(", payment_type=");
        sb.append(this.payment_type);
        sb.append(", is_buy=");
        sb.append(this.is_buy);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", sign=");
        sb.append(this.sign);
        sb.append(")");
        return sb.toString();
    }
}
