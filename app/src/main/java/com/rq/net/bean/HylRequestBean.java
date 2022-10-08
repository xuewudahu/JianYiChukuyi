package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/HylRequestBean;", "", "bag_id", "", "device_id", "timestamp", "nonce_str", "signature", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBag_id", "()Ljava/lang/String;", "getDevice_id", "getNonce_str", "getSignature", "getTimestamp", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class HylRequestBean
{
    private final String bag_id;
    private final String device_id;
    private final String nonce_str;
    private final String signature;
    private final String timestamp;
    
    public HylRequestBean(final String bag_id, final String device_id, final String timestamp, final String nonce_str, final String signature) {
        //Intrinsics.checkParameterIsNotNull(bag_id, "bag_id");
        //Intrinsics.checkParameterIsNotNull(device_id, "device_id");
        //Intrinsics.checkParameterIsNotNull(timestamp, "timestamp");
        //Intrinsics.checkParameterIsNotNull(nonce_str, "nonce_str");
        //Intrinsics.checkParameterIsNotNull(signature, "signature");
        this.bag_id = bag_id;
        this.device_id = device_id;
        this.timestamp = timestamp;
        this.nonce_str = nonce_str;
        this.signature = signature;
    }
    
    public final String component1() {
        return this.bag_id;
    }
    
    public final String component2() {
        return this.device_id;
    }
    
    public final String component3() {
        return this.timestamp;
    }
    
    public final String component4() {
        return this.nonce_str;
    }
    
    public final String component5() {
        return this.signature;
    }
    
    public final HylRequestBean copy(final String s, final String s2, final String s3, final String s4, final String s5) {
        //Intrinsics.checkParameterIsNotNull(s, "bag_id");
        //Intrinsics.checkParameterIsNotNull(s2, "device_id");
        //Intrinsics.checkParameterIsNotNull(s3, "timestamp");
        //Intrinsics.checkParameterIsNotNull(s4, "nonce_str");
        //Intrinsics.checkParameterIsNotNull(s5, "signature");
        return new HylRequestBean(s, s2, s3, s4, s5);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof HylRequestBean) {
                final HylRequestBean hylRequestBean = (HylRequestBean)o;
                if (Intrinsics.areEqual(this.bag_id, hylRequestBean.bag_id) && Intrinsics.areEqual(this.device_id, hylRequestBean.device_id) && Intrinsics.areEqual(this.timestamp, hylRequestBean.timestamp) && Intrinsics.areEqual(this.nonce_str, hylRequestBean.nonce_str) && Intrinsics.areEqual(this.signature, hylRequestBean.signature)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getBag_id() {
        return this.bag_id;
    }
    
    public final String getDevice_id() {
        return this.device_id;
    }
    
    public final String getNonce_str() {
        return this.nonce_str;
    }
    
    public final String getSignature() {
        return this.signature;
    }
    
    public final String getTimestamp() {
        return this.timestamp;
    }
    
    @Override
    public int hashCode() {
        final String bag_id = this.bag_id;
        int hashCode = 0;
        int hashCode2;
        if (bag_id != null) {
            hashCode2 = bag_id.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String device_id = this.device_id;
        int hashCode3;
        if (device_id != null) {
            hashCode3 = device_id.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String timestamp = this.timestamp;
        int hashCode4;
        if (timestamp != null) {
            hashCode4 = timestamp.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String nonce_str = this.nonce_str;
        int hashCode5;
        if (nonce_str != null) {
            hashCode5 = nonce_str.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String signature = this.signature;
        if (signature != null) {
            hashCode = signature.hashCode();
        }
        return (((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("HylRequestBean(bag_id=");
        sb.append(this.bag_id);
        sb.append(", device_id=");
        sb.append(this.device_id);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", nonce_str=");
        sb.append(this.nonce_str);
        sb.append(", signature=");
        sb.append(this.signature);
        sb.append(")");
        return sb.toString();
    }
}
