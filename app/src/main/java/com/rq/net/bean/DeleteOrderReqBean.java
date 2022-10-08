package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/DeleteOrderReqBean;", "", "serial_number", "", "timestamp", "sign", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSerial_number", "()Ljava/lang/String;", "setSerial_number", "(Ljava/lang/String;)V", "getSign", "setSign", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class DeleteOrderReqBean
{
    private String serial_number;
    private String sign;
    private String timestamp;
    
    public DeleteOrderReqBean(final String serial_number, final String timestamp, final String sign) {
        //Intrinsics.checkParameterIsNotNull(serial_number, "serial_number");
        //Intrinsics.checkParameterIsNotNull(timestamp, "timestamp");
        //Intrinsics.checkParameterIsNotNull(sign, "sign");
        this.serial_number = serial_number;
        this.timestamp = timestamp;
        this.sign = sign;
    }
    
    public final String component1() {
        return this.serial_number;
    }
    
    public final String component2() {
        return this.timestamp;
    }
    
    public final String component3() {
        return this.sign;
    }
    
    public final DeleteOrderReqBean copy(final String s, final String s2, final String s3) {
        //Intrinsics.checkParameterIsNotNull(s, "serial_number");
        //Intrinsics.checkParameterIsNotNull(s2, "timestamp");
        //Intrinsics.checkParameterIsNotNull(s3, "sign");
        return new DeleteOrderReqBean(s, s2, s3);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof DeleteOrderReqBean) {
                final DeleteOrderReqBean deleteOrderReqBean = (DeleteOrderReqBean)o;
                if (Intrinsics.areEqual(this.serial_number, deleteOrderReqBean.serial_number) && Intrinsics.areEqual(this.timestamp, deleteOrderReqBean.timestamp) && Intrinsics.areEqual(this.sign, deleteOrderReqBean.sign)) {
                    return true;
                }
            }
            return false;
        }
        return true;
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
        final String timestamp = this.timestamp;
        int hashCode3;
        if (timestamp != null) {
            hashCode3 = timestamp.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String sign = this.sign;
        if (sign != null) {
            hashCode = sign.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    public final void setSerial_number(final String serial_number) {
        //Intrinsics.checkParameterIsNotNull(serial_number, "<set-?>");
        this.serial_number = serial_number;
    }
    
    public final void setSign(final String sign) {
        //Intrinsics.checkParameterIsNotNull(sign, "<set-?>");
        this.sign = sign;
    }
    
    public final void setTimestamp(final String timestamp) {
        //Intrinsics.checkParameterIsNotNull(timestamp, "<set-?>");
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DeleteOrderReqBean(serial_number=");
        sb.append(this.serial_number);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", sign=");
        sb.append(this.sign);
        sb.append(")");
        return sb.toString();
    }
}
