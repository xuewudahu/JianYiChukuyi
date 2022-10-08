package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003¢\u0006\u0002\u0010\u0019J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\u0090\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003H\u00c6\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u000202H\u00d6\u0001J\t\u00103\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0019¨\u00064" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/ZhongYouUploadWeightDataOperBody;", "", "packageCode", "", "machineCode", "pWeight", "", "pLength", "pWidth", "pHigh", "volume", "opeUserId", "opeUserName", "opeSiteId", "opeSiteName", "opeTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMachineCode", "()Ljava/lang/String;", "getOpeSiteId", "getOpeSiteName", "getOpeTime", "getOpeUserId", "getOpeUserName", "getPHigh", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPLength", "getPWeight", "getPWidth", "getPackageCode", "getVolume", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/yunpan/cobaaidlservice/bean/ZhongYouUploadWeightDataOperBody;", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class ZhongYouUploadWeightDataOperBody
{
    private final String machineCode;
    private final String opeSiteId;
    private final String opeSiteName;
    private final String opeTime;
    private final String opeUserId;
    private final String opeUserName;
    private final Float pHigh;
    private final Float pLength;
    private final Float pWeight;
    private final Float pWidth;
    private final String packageCode;
    private final Float volume;
    
    public ZhongYouUploadWeightDataOperBody(final String packageCode, final String machineCode, final Float pWeight, final Float pLength, final Float pWidth, final Float pHigh, final Float volume, final String opeUserId, final String opeUserName, final String opeSiteId, final String opeSiteName, final String opeTime) {
        //Intrinsics.checkParameterIsNotNull(packageCode, "packageCode");
        //Intrinsics.checkParameterIsNotNull(machineCode, "machineCode");
        //Intrinsics.checkParameterIsNotNull(opeUserId, "opeUserId");
        //Intrinsics.checkParameterIsNotNull(opeUserName, "opeUserName");
        //Intrinsics.checkParameterIsNotNull(opeSiteId, "opeSiteId");
        //Intrinsics.checkParameterIsNotNull(opeSiteName, "opeSiteName");
        //Intrinsics.checkParameterIsNotNull(opeTime, "opeTime");
        this.packageCode = packageCode;
        this.machineCode = machineCode;
        this.pWeight = pWeight;
        this.pLength = pLength;
        this.pWidth = pWidth;
        this.pHigh = pHigh;
        this.volume = volume;
        this.opeUserId = opeUserId;
        this.opeUserName = opeUserName;
        this.opeSiteId = opeSiteId;
        this.opeSiteName = opeSiteName;
        this.opeTime = opeTime;
    }
    
    public final String component1() {
        return this.packageCode;
    }
    
    public final String component10() {
        return this.opeSiteId;
    }
    
    public final String component11() {
        return this.opeSiteName;
    }
    
    public final String component12() {
        return this.opeTime;
    }
    
    public final String component2() {
        return this.machineCode;
    }
    
    public final Float component3() {
        return this.pWeight;
    }
    
    public final Float component4() {
        return this.pLength;
    }
    
    public final Float component5() {
        return this.pWidth;
    }
    
    public final Float component6() {
        return this.pHigh;
    }
    
    public final Float component7() {
        return this.volume;
    }
    
    public final String component8() {
        return this.opeUserId;
    }
    
    public final String component9() {
        return this.opeUserName;
    }
    
    public final ZhongYouUploadWeightDataOperBody copy(final String s, final String s2, final Float n, final Float n2, final Float n3, final Float n4, final Float n5, final String s3, final String s4, final String s5, final String s6, final String s7) {
        //Intrinsics.checkParameterIsNotNull(s, "packageCode");
        //Intrinsics.checkParameterIsNotNull(s2, "machineCode");
        //Intrinsics.checkParameterIsNotNull(s3, "opeUserId");
        //Intrinsics.checkParameterIsNotNull(s4, "opeUserName");
        //Intrinsics.checkParameterIsNotNull(s5, "opeSiteId");
        //Intrinsics.checkParameterIsNotNull(s6, "opeSiteName");
        //Intrinsics.checkParameterIsNotNull(s7, "opeTime");
        return new ZhongYouUploadWeightDataOperBody(s, s2, n, n2, n3, n4, n5, s3, s4, s5, s6, s7);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof ZhongYouUploadWeightDataOperBody) {
                final ZhongYouUploadWeightDataOperBody zhongYouUploadWeightDataOperBody = (ZhongYouUploadWeightDataOperBody)o;
                if (Intrinsics.areEqual(this.packageCode, zhongYouUploadWeightDataOperBody.packageCode) && Intrinsics.areEqual(this.machineCode, zhongYouUploadWeightDataOperBody.machineCode) && Intrinsics.areEqual(this.pWeight, (Object)zhongYouUploadWeightDataOperBody.pWeight) && Intrinsics.areEqual(this.pLength, (Object)zhongYouUploadWeightDataOperBody.pLength) && Intrinsics.areEqual(this.pWidth, (Object)zhongYouUploadWeightDataOperBody.pWidth) && Intrinsics.areEqual(this.pHigh, (Object)zhongYouUploadWeightDataOperBody.pHigh) && Intrinsics.areEqual(this.volume, (Object)zhongYouUploadWeightDataOperBody.volume) && Intrinsics.areEqual(this.opeUserId, zhongYouUploadWeightDataOperBody.opeUserId) && Intrinsics.areEqual(this.opeUserName, zhongYouUploadWeightDataOperBody.opeUserName) && Intrinsics.areEqual(this.opeSiteId, zhongYouUploadWeightDataOperBody.opeSiteId) && Intrinsics.areEqual(this.opeSiteName, zhongYouUploadWeightDataOperBody.opeSiteName) && Intrinsics.areEqual(this.opeTime, zhongYouUploadWeightDataOperBody.opeTime)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getMachineCode() {
        return this.machineCode;
    }
    
    public final String getOpeSiteId() {
        return this.opeSiteId;
    }
    
    public final String getOpeSiteName() {
        return this.opeSiteName;
    }
    
    public final String getOpeTime() {
        return this.opeTime;
    }
    
    public final String getOpeUserId() {
        return this.opeUserId;
    }
    
    public final String getOpeUserName() {
        return this.opeUserName;
    }
    
    public final Float getPHigh() {
        return this.pHigh;
    }
    
    public final Float getPLength() {
        return this.pLength;
    }
    
    public final Float getPWeight() {
        return this.pWeight;
    }
    
    public final Float getPWidth() {
        return this.pWidth;
    }
    
    public final String getPackageCode() {
        return this.packageCode;
    }
    
    public final Float getVolume() {
        return this.volume;
    }
    
    @Override
    public int hashCode() {
        final String packageCode = this.packageCode;
        int hashCode = 0;
        int hashCode2;
        if (packageCode != null) {
            hashCode2 = packageCode.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String machineCode = this.machineCode;
        int hashCode3;
        if (machineCode != null) {
            hashCode3 = machineCode.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final Float pWeight = this.pWeight;
        int hashCode4;
        if (pWeight != null) {
            hashCode4 = pWeight.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final Float pLength = this.pLength;
        int hashCode5;
        if (pLength != null) {
            hashCode5 = pLength.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final Float pWidth = this.pWidth;
        int hashCode6;
        if (pWidth != null) {
            hashCode6 = pWidth.hashCode();
        }
        else {
            hashCode6 = 0;
        }
        final Float pHigh = this.pHigh;
        int hashCode7;
        if (pHigh != null) {
            hashCode7 = pHigh.hashCode();
        }
        else {
            hashCode7 = 0;
        }
        final Float volume = this.volume;
        int hashCode8;
        if (volume != null) {
            hashCode8 = volume.hashCode();
        }
        else {
            hashCode8 = 0;
        }
        final String opeUserId = this.opeUserId;
        int hashCode9;
        if (opeUserId != null) {
            hashCode9 = opeUserId.hashCode();
        }
        else {
            hashCode9 = 0;
        }
        final String opeUserName = this.opeUserName;
        int hashCode10;
        if (opeUserName != null) {
            hashCode10 = opeUserName.hashCode();
        }
        else {
            hashCode10 = 0;
        }
        final String opeSiteId = this.opeSiteId;
        int hashCode11;
        if (opeSiteId != null) {
            hashCode11 = opeSiteId.hashCode();
        }
        else {
            hashCode11 = 0;
        }
        final String opeSiteName = this.opeSiteName;
        int hashCode12;
        if (opeSiteName != null) {
            hashCode12 = opeSiteName.hashCode();
        }
        else {
            hashCode12 = 0;
        }
        final String opeTime = this.opeTime;
        if (opeTime != null) {
            hashCode = opeTime.hashCode();
        }
        return ((((((((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode8) * 31 + hashCode9) * 31 + hashCode10) * 31 + hashCode11) * 31 + hashCode12) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ZhongYouUploadWeightDataOperBody(packageCode=");
        sb.append(this.packageCode);
        sb.append(", machineCode=");
        sb.append(this.machineCode);
        sb.append(", pWeight=");
        sb.append(this.pWeight);
        sb.append(", pLength=");
        sb.append(this.pLength);
        sb.append(", pWidth=");
        sb.append(this.pWidth);
        sb.append(", pHigh=");
        sb.append(this.pHigh);
        sb.append(", volume=");
        sb.append(this.volume);
        sb.append(", opeUserId=");
        sb.append(this.opeUserId);
        sb.append(", opeUserName=");
        sb.append(this.opeUserName);
        sb.append(", opeSiteId=");
        sb.append(this.opeSiteId);
        sb.append(", opeSiteName=");
        sb.append(this.opeSiteName);
        sb.append(", opeTime=");
        sb.append(this.opeTime);
        sb.append(")");
        return sb.toString();
    }
}
