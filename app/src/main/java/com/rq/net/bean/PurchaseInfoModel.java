package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/PurchaseInfoModel;", "", "id", "", "name", "", "price", "payType", "startTime", "entTime", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getEntTime", "()Ljava/lang/String;", "getId", "()I", "getName", "getPayType", "getPrice", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class PurchaseInfoModel
{
    private final String entTime;
    private final int id;
    private final String name;
    private final int payType;
    private final String price;
    private final String startTime;
    
    public PurchaseInfoModel(final int id, final String name, final String price, final int payType, final String startTime, final String entTime) {
        //Intrinsics.checkParameterIsNotNull(name, "name");
        //Intrinsics.checkParameterIsNotNull(price, "price");
        //Intrinsics.checkParameterIsNotNull(startTime, "startTime");
        //Intrinsics.checkParameterIsNotNull(entTime, "entTime");
        this.id = id;
        this.name = name;
        this.price = price;
        this.payType = payType;
        this.startTime = startTime;
        this.entTime = entTime;
    }
    
    public final int component1() {
        return this.id;
    }
    
    public final String component2() {
        return this.name;
    }
    
    public final String component3() {
        return this.price;
    }
    
    public final int component4() {
        return this.payType;
    }
    
    public final String component5() {
        return this.startTime;
    }
    
    public final String component6() {
        return this.entTime;
    }
    
    public final PurchaseInfoModel copy(final int n, final String s, final String s2, final int n2, final String s3, final String s4) {
        //Intrinsics.checkParameterIsNotNull(s, "name");
        //Intrinsics.checkParameterIsNotNull(s2, "price");
        //Intrinsics.checkParameterIsNotNull(s3, "startTime");
        //Intrinsics.checkParameterIsNotNull(s4, "entTime");
        return new PurchaseInfoModel(n, s, s2, n2, s3, s4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PurchaseInfoModel) {
                final PurchaseInfoModel purchaseInfoModel = (PurchaseInfoModel)o;
                if (this.id == purchaseInfoModel.id && Intrinsics.areEqual(this.name, purchaseInfoModel.name) && Intrinsics.areEqual(this.price, purchaseInfoModel.price) && this.payType == purchaseInfoModel.payType && Intrinsics.areEqual(this.startTime, purchaseInfoModel.startTime) && Intrinsics.areEqual(this.entTime, purchaseInfoModel.entTime)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getEntTime() {
        return this.entTime;
    }
    
    public final int getId() {
        return this.id;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public final int getPayType() {
        return this.payType;
    }
    
    public final String getPrice() {
        return this.price;
    }
    
    public final String getStartTime() {
        return this.startTime;
    }
    
    @Override
    public int hashCode() {
        final int id = this.id;
        final String name = this.name;
        int hashCode = 0;
        int hashCode2;
        if (name != null) {
            hashCode2 = name.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String price = this.price;
        int hashCode3;
        if (price != null) {
            hashCode3 = price.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final int payType = this.payType;
        final String startTime = this.startTime;
        int hashCode4;
        if (startTime != null) {
            hashCode4 = startTime.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String entTime = this.entTime;
        if (entTime != null) {
            hashCode = entTime.hashCode();
        }
        return ((((id * 31 + hashCode2) * 31 + hashCode3) * 31 + payType) * 31 + hashCode4) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PurchaseInfoModel(id=");
        sb.append(this.id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", price=");
        sb.append(this.price);
        sb.append(", payType=");
        sb.append(this.payType);
        sb.append(", startTime=");
        sb.append(this.startTime);
        sb.append(", entTime=");
        sb.append(this.entTime);
        sb.append(")");
        return sb.toString();
    }
}
