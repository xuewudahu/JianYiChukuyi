package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/PandaStayData;", "", "arriveTime", "", "mailNo", "companyId", "recipientMobile", "companyName", "recipientName", "frameCode", "parcelId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArriveTime", "()Ljava/lang/String;", "getCompanyId", "getCompanyName", "getFrameCode", "getMailNo", "getParcelId", "getRecipientMobile", "getRecipientName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class PandaStayData
{
    private final String arriveTime;
    private final String companyId;
    private final String companyName;
    private final String frameCode;
    private final String mailNo;
    private final String parcelId;
    private final String recipientMobile;
    private final String recipientName;
    
    public PandaStayData(final String arriveTime, final String mailNo, final String companyId, final String recipientMobile, final String companyName, final String recipientName, final String frameCode, final String parcelId) {
        //Intrinsics.checkParameterIsNotNull(arriveTime, "arriveTime");
        //Intrinsics.checkParameterIsNotNull(mailNo, "mailNo");
        //Intrinsics.checkParameterIsNotNull(companyId, "companyId");
        //Intrinsics.checkParameterIsNotNull(recipientMobile, "recipientMobile");
        //Intrinsics.checkParameterIsNotNull(companyName, "companyName");
        //Intrinsics.checkParameterIsNotNull(recipientName, "recipientName");
        //Intrinsics.checkParameterIsNotNull(frameCode, "frameCode");
        //Intrinsics.checkParameterIsNotNull(parcelId, "parcelId");
        this.arriveTime = arriveTime;
        this.mailNo = mailNo;
        this.companyId = companyId;
        this.recipientMobile = recipientMobile;
        this.companyName = companyName;
        this.recipientName = recipientName;
        this.frameCode = frameCode;
        this.parcelId = parcelId;
    }
    
    public final String component1() {
        return this.arriveTime;
    }
    
    public final String component2() {
        return this.mailNo;
    }
    
    public final String component3() {
        return this.companyId;
    }
    
    public final String component4() {
        return this.recipientMobile;
    }
    
    public final String component5() {
        return this.companyName;
    }
    
    public final String component6() {
        return this.recipientName;
    }
    
    public final String component7() {
        return this.frameCode;
    }
    
    public final String component8() {
        return this.parcelId;
    }
    
    public final PandaStayData copy(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final String s7, final String s8) {
        //Intrinsics.checkParameterIsNotNull(s, "arriveTime");
        //Intrinsics.checkParameterIsNotNull(s2, "mailNo");
        //Intrinsics.checkParameterIsNotNull(s3, "companyId");
        //Intrinsics.checkParameterIsNotNull(s4, "recipientMobile");
        //Intrinsics.checkParameterIsNotNull(s5, "companyName");
        //Intrinsics.checkParameterIsNotNull(s6, "recipientName");
        //Intrinsics.checkParameterIsNotNull(s7, "frameCode");
        //Intrinsics.checkParameterIsNotNull(s8, "parcelId");
        return new PandaStayData(s, s2, s3, s4, s5, s6, s7, s8);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PandaStayData) {
                final PandaStayData pandaStayData = (PandaStayData)o;
                if (Intrinsics.areEqual(this.arriveTime, pandaStayData.arriveTime) && Intrinsics.areEqual(this.mailNo, pandaStayData.mailNo) && Intrinsics.areEqual(this.companyId, pandaStayData.companyId) && Intrinsics.areEqual(this.recipientMobile, pandaStayData.recipientMobile) && Intrinsics.areEqual(this.companyName, pandaStayData.companyName) && Intrinsics.areEqual(this.recipientName, pandaStayData.recipientName) && Intrinsics.areEqual(this.frameCode, pandaStayData.frameCode) && Intrinsics.areEqual(this.parcelId, pandaStayData.parcelId)) {
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
    
    public final String getCompanyId() {
        return this.companyId;
    }
    
    public final String getCompanyName() {
        return this.companyName;
    }
    
    public final String getFrameCode() {
        return this.frameCode;
    }
    
    public final String getMailNo() {
        return this.mailNo;
    }
    
    public final String getParcelId() {
        return this.parcelId;
    }
    
    public final String getRecipientMobile() {
        return this.recipientMobile;
    }
    
    public final String getRecipientName() {
        return this.recipientName;
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
        final String mailNo = this.mailNo;
        int hashCode3;
        if (mailNo != null) {
            hashCode3 = mailNo.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String companyId = this.companyId;
        int hashCode4;
        if (companyId != null) {
            hashCode4 = companyId.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String recipientMobile = this.recipientMobile;
        int hashCode5;
        if (recipientMobile != null) {
            hashCode5 = recipientMobile.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String companyName = this.companyName;
        int hashCode6;
        if (companyName != null) {
            hashCode6 = companyName.hashCode();
        }
        else {
            hashCode6 = 0;
        }
        final String recipientName = this.recipientName;
        int hashCode7;
        if (recipientName != null) {
            hashCode7 = recipientName.hashCode();
        }
        else {
            hashCode7 = 0;
        }
        final String frameCode = this.frameCode;
        int hashCode8;
        if (frameCode != null) {
            hashCode8 = frameCode.hashCode();
        }
        else {
            hashCode8 = 0;
        }
        final String parcelId = this.parcelId;
        if (parcelId != null) {
            hashCode = parcelId.hashCode();
        }
        return ((((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode8) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PandaStayData(arriveTime=");
        sb.append(this.arriveTime);
        sb.append(", mailNo=");
        sb.append(this.mailNo);
        sb.append(", companyId=");
        sb.append(this.companyId);
        sb.append(", recipientMobile=");
        sb.append(this.recipientMobile);
        sb.append(", companyName=");
        sb.append(this.companyName);
        sb.append(", recipientName=");
        sb.append(this.recipientName);
        sb.append(", frameCode=");
        sb.append(this.frameCode);
        sb.append(", parcelId=");
        sb.append(this.parcelId);
        sb.append(")");
        return sb.toString();
    }
}
