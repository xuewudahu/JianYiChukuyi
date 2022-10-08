package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/YshouFaVersionBean;", "", "delFlag", "", "deviceType", "deviceUrl", "deviceUrl1", "deviceUrl2", "deviceVersion", "id", "remark", "whetherUpdate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDelFlag", "()Ljava/lang/String;", "getDeviceType", "getDeviceUrl", "getDeviceUrl1", "getDeviceUrl2", "getDeviceVersion", "getId", "getRemark", "getWhetherUpdate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class YshouFaVersionBean
{
    private final String delFlag;
    private final String deviceType;
    private final String deviceUrl;
    private final String deviceUrl1;
    private final String deviceUrl2;
    private final String deviceVersion;
    private final String id;
    private final String remark;
    private final String whetherUpdate;
    
    public YshouFaVersionBean(final String delFlag, final String deviceType, final String deviceUrl, final String deviceUrl2, final String deviceUrl3, final String deviceVersion, final String id, final String remark, final String whetherUpdate) {
        //Intrinsics.checkParameterIsNotNull(delFlag, "delFlag");
        //Intrinsics.checkParameterIsNotNull(deviceType, "deviceType");
        //Intrinsics.checkParameterIsNotNull(deviceUrl, "deviceUrl");
        //Intrinsics.checkParameterIsNotNull(deviceUrl2, "deviceUrl1");
        //Intrinsics.checkParameterIsNotNull(deviceUrl3, "deviceUrl2");
        //Intrinsics.checkParameterIsNotNull(deviceVersion, "deviceVersion");
        //Intrinsics.checkParameterIsNotNull(id, "id");
        //Intrinsics.checkParameterIsNotNull(remark, "remark");
        //Intrinsics.checkParameterIsNotNull(whetherUpdate, "whetherUpdate");
        this.delFlag = delFlag;
        this.deviceType = deviceType;
        this.deviceUrl = deviceUrl;
        this.deviceUrl1 = deviceUrl2;
        this.deviceUrl2 = deviceUrl3;
        this.deviceVersion = deviceVersion;
        this.id = id;
        this.remark = remark;
        this.whetherUpdate = whetherUpdate;
    }
    
    public final String component1() {
        return this.delFlag;
    }
    
    public final String component2() {
        return this.deviceType;
    }
    
    public final String component3() {
        return this.deviceUrl;
    }
    
    public final String component4() {
        return this.deviceUrl1;
    }
    
    public final String component5() {
        return this.deviceUrl2;
    }
    
    public final String component6() {
        return this.deviceVersion;
    }
    
    public final String component7() {
        return this.id;
    }
    
    public final String component8() {
        return this.remark;
    }
    
    public final String component9() {
        return this.whetherUpdate;
    }
    
    public final YshouFaVersionBean copy(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final String s7, final String s8, final String s9) {
        //Intrinsics.checkParameterIsNotNull(s, "delFlag");
        //Intrinsics.checkParameterIsNotNull(s2, "deviceType");
        //Intrinsics.checkParameterIsNotNull(s3, "deviceUrl");
        //Intrinsics.checkParameterIsNotNull(s4, "deviceUrl1");
        //Intrinsics.checkParameterIsNotNull(s5, "deviceUrl2");
        //Intrinsics.checkParameterIsNotNull(s6, "deviceVersion");
        //Intrinsics.checkParameterIsNotNull(s7, "id");
        //Intrinsics.checkParameterIsNotNull(s8, "remark");
        //Intrinsics.checkParameterIsNotNull(s9, "whetherUpdate");
        return new YshouFaVersionBean(s, s2, s3, s4, s5, s6, s7, s8, s9);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof YshouFaVersionBean) {
                final YshouFaVersionBean yshouFaVersionBean = (YshouFaVersionBean)o;
                if (Intrinsics.areEqual(this.delFlag, yshouFaVersionBean.delFlag) && Intrinsics.areEqual(this.deviceType, yshouFaVersionBean.deviceType) && Intrinsics.areEqual(this.deviceUrl, yshouFaVersionBean.deviceUrl) && Intrinsics.areEqual(this.deviceUrl1, yshouFaVersionBean.deviceUrl1) && Intrinsics.areEqual(this.deviceUrl2, yshouFaVersionBean.deviceUrl2) && Intrinsics.areEqual(this.deviceVersion, yshouFaVersionBean.deviceVersion) && Intrinsics.areEqual(this.id, yshouFaVersionBean.id) && Intrinsics.areEqual(this.remark, yshouFaVersionBean.remark) && Intrinsics.areEqual(this.whetherUpdate, yshouFaVersionBean.whetherUpdate)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getDelFlag() {
        return this.delFlag;
    }
    
    public final String getDeviceType() {
        return this.deviceType;
    }
    
    public final String getDeviceUrl() {
        return this.deviceUrl;
    }
    
    public final String getDeviceUrl1() {
        return this.deviceUrl1;
    }
    
    public final String getDeviceUrl2() {
        return this.deviceUrl2;
    }
    
    public final String getDeviceVersion() {
        return this.deviceVersion;
    }
    
    public final String getId() {
        return this.id;
    }
    
    public final String getRemark() {
        return this.remark;
    }
    
    public final String getWhetherUpdate() {
        return this.whetherUpdate;
    }
    
    @Override
    public int hashCode() {
        final String delFlag = this.delFlag;
        int hashCode = 0;
        int hashCode2;
        if (delFlag != null) {
            hashCode2 = delFlag.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String deviceType = this.deviceType;
        int hashCode3;
        if (deviceType != null) {
            hashCode3 = deviceType.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String deviceUrl = this.deviceUrl;
        int hashCode4;
        if (deviceUrl != null) {
            hashCode4 = deviceUrl.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String deviceUrl2 = this.deviceUrl1;
        int hashCode5;
        if (deviceUrl2 != null) {
            hashCode5 = deviceUrl2.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String deviceUrl3 = this.deviceUrl2;
        int hashCode6;
        if (deviceUrl3 != null) {
            hashCode6 = deviceUrl3.hashCode();
        }
        else {
            hashCode6 = 0;
        }
        final String deviceVersion = this.deviceVersion;
        int hashCode7;
        if (deviceVersion != null) {
            hashCode7 = deviceVersion.hashCode();
        }
        else {
            hashCode7 = 0;
        }
        final String id = this.id;
        int hashCode8;
        if (id != null) {
            hashCode8 = id.hashCode();
        }
        else {
            hashCode8 = 0;
        }
        final String remark = this.remark;
        int hashCode9;
        if (remark != null) {
            hashCode9 = remark.hashCode();
        }
        else {
            hashCode9 = 0;
        }
        final String whetherUpdate = this.whetherUpdate;
        if (whetherUpdate != null) {
            hashCode = whetherUpdate.hashCode();
        }
        return (((((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode8) * 31 + hashCode9) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("YshouFaVersionBean(delFlag=");
        sb.append(this.delFlag);
        sb.append(", deviceType=");
        sb.append(this.deviceType);
        sb.append(", deviceUrl=");
        sb.append(this.deviceUrl);
        sb.append(", deviceUrl1=");
        sb.append(this.deviceUrl1);
        sb.append(", deviceUrl2=");
        sb.append(this.deviceUrl2);
        sb.append(", deviceVersion=");
        sb.append(this.deviceVersion);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", remark=");
        sb.append(this.remark);
        sb.append(", whetherUpdate=");
        sb.append(this.whetherUpdate);
        sb.append(")");
        return sb.toString();
    }
}
