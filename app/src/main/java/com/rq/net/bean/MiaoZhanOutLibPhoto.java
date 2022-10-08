package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/MiaoZhanOutLibPhoto;", "", "mailNo", "", "deviceNo", "signPhoto", "facePhoto", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceNo", "()Ljava/lang/String;", "getFacePhoto", "getMailNo", "getSignPhoto", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class MiaoZhanOutLibPhoto
{
    private final String deviceNo;
    private final String facePhoto;
    private final String mailNo;
    private final String signPhoto;
    
    public MiaoZhanOutLibPhoto(final String mailNo, final String deviceNo, final String signPhoto, final String facePhoto) {
        //Intrinsics.checkParameterIsNotNull(mailNo, "mailNo");
        //Intrinsics.checkParameterIsNotNull(deviceNo, "deviceNo");
        this.mailNo = mailNo;
        this.deviceNo = deviceNo;
        this.signPhoto = signPhoto;
        this.facePhoto = facePhoto;
    }
    
    public final String component1() {
        return this.mailNo;
    }
    
    public final String component2() {
        return this.deviceNo;
    }
    
    public final String component3() {
        return this.signPhoto;
    }
    
    public final String component4() {
        return this.facePhoto;
    }
    
    public final MiaoZhanOutLibPhoto copy(final String s, final String s2, final String s3, final String s4) {
        //Intrinsics.checkParameterIsNotNull(s, "mailNo");
        //Intrinsics.checkParameterIsNotNull(s2, "deviceNo");
        return new MiaoZhanOutLibPhoto(s, s2, s3, s4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof MiaoZhanOutLibPhoto) {
                final MiaoZhanOutLibPhoto miaoZhanOutLibPhoto = (MiaoZhanOutLibPhoto)o;
                if (Intrinsics.areEqual(this.mailNo, miaoZhanOutLibPhoto.mailNo) && Intrinsics.areEqual(this.deviceNo, miaoZhanOutLibPhoto.deviceNo) && Intrinsics.areEqual(this.signPhoto, miaoZhanOutLibPhoto.signPhoto) && Intrinsics.areEqual(this.facePhoto, miaoZhanOutLibPhoto.facePhoto)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getDeviceNo() {
        return this.deviceNo;
    }
    
    public final String getFacePhoto() {
        return this.facePhoto;
    }
    
    public final String getMailNo() {
        return this.mailNo;
    }
    
    public final String getSignPhoto() {
        return this.signPhoto;
    }
    
    @Override
    public int hashCode() {
        final String mailNo = this.mailNo;
        int hashCode = 0;
        int hashCode2;
        if (mailNo != null) {
            hashCode2 = mailNo.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String deviceNo = this.deviceNo;
        int hashCode3;
        if (deviceNo != null) {
            hashCode3 = deviceNo.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String signPhoto = this.signPhoto;
        int hashCode4;
        if (signPhoto != null) {
            hashCode4 = signPhoto.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String facePhoto = this.facePhoto;
        if (facePhoto != null) {
            hashCode = facePhoto.hashCode();
        }
        return ((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MiaoZhanOutLibPhoto(mailNo=");
        sb.append(this.mailNo);
        sb.append(", deviceNo=");
        sb.append(this.deviceNo);
        sb.append(", signPhoto=");
        sb.append(this.signPhoto);
        sb.append(", facePhoto=");
        sb.append(this.facePhoto);
        sb.append(")");
        return sb.toString();
    }
}
