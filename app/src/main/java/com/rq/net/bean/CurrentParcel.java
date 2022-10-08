package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/CurrentParcel;", "", "arriveTime", "", "parcelId", "(Ljava/lang/String;Ljava/lang/String;)V", "getArriveTime", "()Ljava/lang/String;", "getParcelId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class CurrentParcel
{
    private final String arriveTime;
    private final String parcelId;
    
    public CurrentParcel(final String arriveTime, final String parcelId) {
        //Intrinsics.checkParameterIsNotNull(arriveTime, "arriveTime");
        //Intrinsics.checkParameterIsNotNull(parcelId, "parcelId");
        this.arriveTime = arriveTime;
        this.parcelId = parcelId;
    }
    
    public final String component1() {
        return this.arriveTime;
    }
    
    public final String component2() {
        return this.parcelId;
    }
    
    public final CurrentParcel copy(final String s, final String s2) {
        //Intrinsics.checkParameterIsNotNull(s, "arriveTime");
        //Intrinsics.checkParameterIsNotNull(s2, "parcelId");
        return new CurrentParcel(s, s2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof CurrentParcel) {
                final CurrentParcel currentParcel = (CurrentParcel)o;
                if (Intrinsics.areEqual(this.arriveTime, currentParcel.arriveTime) && Intrinsics.areEqual(this.parcelId, currentParcel.parcelId)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getArriveTime() {
        return this.arriveTime;
    }
    
    public final String getParcelId() {
        return this.parcelId;
    }
    
    @Override
    public int hashCode() {
        final String arriveTime = this.arriveTime;
        int hashCode = 0;
        int hashCode2;
        if (arriveTime != null) {
            hashCode2 = arriveTime.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String parcelId = this.parcelId;
        if (parcelId != null) {
            hashCode = parcelId.hashCode();
        }
        return hashCode2 * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CurrentParcel(arriveTime=");
        sb.append(this.arriveTime);
        sb.append(", parcelId=");
        sb.append(this.parcelId);
        sb.append(")");
        return sb.toString();
    }
}
