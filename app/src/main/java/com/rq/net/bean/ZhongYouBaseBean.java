package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/ZhongYouBaseBean;", "", "opeUserId", "", "opeUserName", "opeSiteId", "opeSiteName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOpeSiteId", "()Ljava/lang/String;", "getOpeSiteName", "getOpeUserId", "getOpeUserName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class ZhongYouBaseBean
{
    private final String opeSiteId;
    private final String opeSiteName;
    private final String opeUserId;
    private final String opeUserName;
    
    public ZhongYouBaseBean(final String opeUserId, final String opeUserName, final String opeSiteId, final String opeSiteName) {
        //Intrinsics.checkParameterIsNotNull(opeUserId, "opeUserId");
        //Intrinsics.checkParameterIsNotNull(opeUserName, "opeUserName");
        //Intrinsics.checkParameterIsNotNull(opeSiteId, "opeSiteId");
        //Intrinsics.checkParameterIsNotNull(opeSiteName, "opeSiteName");
        this.opeUserId = opeUserId;
        this.opeUserName = opeUserName;
        this.opeSiteId = opeSiteId;
        this.opeSiteName = opeSiteName;
    }
    
    public final String component1() {
        return this.opeUserId;
    }
    
    public final String component2() {
        return this.opeUserName;
    }
    
    public final String component3() {
        return this.opeSiteId;
    }
    
    public final String component4() {
        return this.opeSiteName;
    }
    
    public final ZhongYouBaseBean copy(final String s, final String s2, final String s3, final String s4) {
        //Intrinsics.checkParameterIsNotNull(s, "opeUserId");
        //Intrinsics.checkParameterIsNotNull(s2, "opeUserName");
        //Intrinsics.checkParameterIsNotNull(s3, "opeSiteId");
        //Intrinsics.checkParameterIsNotNull(s4, "opeSiteName");
        return new ZhongYouBaseBean(s, s2, s3, s4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof ZhongYouBaseBean) {
                final ZhongYouBaseBean zhongYouBaseBean = (ZhongYouBaseBean)o;
                if (Intrinsics.areEqual(this.opeUserId, zhongYouBaseBean.opeUserId) && Intrinsics.areEqual(this.opeUserName, zhongYouBaseBean.opeUserName) && Intrinsics.areEqual(this.opeSiteId, zhongYouBaseBean.opeSiteId) && Intrinsics.areEqual(this.opeSiteName, zhongYouBaseBean.opeSiteName)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getOpeSiteId() {
        return this.opeSiteId;
    }
    
    public final String getOpeSiteName() {
        return this.opeSiteName;
    }
    
    public final String getOpeUserId() {
        return this.opeUserId;
    }
    
    public final String getOpeUserName() {
        return this.opeUserName;
    }
    
    @Override
    public int hashCode() {
        final String opeUserId = this.opeUserId;
        int hashCode = 0;
        int hashCode2;
        if (opeUserId != null) {
            hashCode2 = opeUserId.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String opeUserName = this.opeUserName;
        int hashCode3;
        if (opeUserName != null) {
            hashCode3 = opeUserName.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String opeSiteId = this.opeSiteId;
        int hashCode4;
        if (opeSiteId != null) {
            hashCode4 = opeSiteId.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String opeSiteName = this.opeSiteName;
        if (opeSiteName != null) {
            hashCode = opeSiteName.hashCode();
        }
        return ((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ZhongYouBaseBean(opeUserId=");
        sb.append(this.opeUserId);
        sb.append(", opeUserName=");
        sb.append(this.opeUserName);
        sb.append(", opeSiteId=");
        sb.append(this.opeSiteId);
        sb.append(", opeSiteName=");
        sb.append(this.opeSiteName);
        sb.append(")");
        return sb.toString();
    }
}
