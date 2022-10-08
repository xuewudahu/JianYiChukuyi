package com.rq.net.bean;

//import kotlin.*;
import com.rq.net.util.Intrinsics;

import java.util.*;
//import kotlin.jvm.internal.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J7\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/BatchsignOrderRequestBean;", "", "orderIds", "", "", "remark", "signUrl", "signType", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;I)V", "getOrderIds", "()Ljava/util/List;", "getRemark", "()Ljava/lang/String;", "getSignType", "()I", "getSignUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class BatchsignOrderRequestBean
{
    private final List<String> orderIds;
    private final String remark;
    private final int signType;
    private final String signUrl;
    
    public BatchsignOrderRequestBean(final List<String> orderIds, final String remark, final String signUrl, final int signType) {
        //Intrinsics.checkParameterIsNotNull(orderIds, "orderIds");
        //Intrinsics.checkParameterIsNotNull(remark, "remark");
        //Intrinsics.checkParameterIsNotNull(signUrl, "signUrl");
        this.orderIds = orderIds;
        this.remark = remark;
        this.signUrl = signUrl;
        this.signType = signType;
    }
    
    public final List<String> component1() {
        return this.orderIds;
    }
    
    public final String component2() {
        return this.remark;
    }
    
    public final String component3() {
        return this.signUrl;
    }
    
    public final int component4() {
        return this.signType;
    }
    
    public final BatchsignOrderRequestBean copy(final List<String> list, final String s, final String s2, final int n) {
        //Intrinsics.checkParameterIsNotNull(list, "orderIds");
        //Intrinsics.checkParameterIsNotNull(s, "remark");
        //Intrinsics.checkParameterIsNotNull(s2, "signUrl");
        return new BatchsignOrderRequestBean(list, s, s2, n);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof BatchsignOrderRequestBean) {
                final BatchsignOrderRequestBean batchsignOrderRequestBean = (BatchsignOrderRequestBean)o;
                if (Intrinsics.areEqual(this.orderIds, batchsignOrderRequestBean.orderIds) && Intrinsics.areEqual(this.remark, batchsignOrderRequestBean.remark) && Intrinsics.areEqual(this.signUrl, batchsignOrderRequestBean.signUrl) && this.signType == batchsignOrderRequestBean.signType) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final List<String> getOrderIds() {
        return this.orderIds;
    }
    
    public final String getRemark() {
        return this.remark;
    }
    
    public final int getSignType() {
        return this.signType;
    }
    
    public final String getSignUrl() {
        return this.signUrl;
    }
    
    @Override
    public int hashCode() {
        final List<String> orderIds = this.orderIds;
        int hashCode = 0;
        int hashCode2;
        if (orderIds != null) {
            hashCode2 = orderIds.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String remark = this.remark;
        int hashCode3;
        if (remark != null) {
            hashCode3 = remark.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String signUrl = this.signUrl;
        if (signUrl != null) {
            hashCode = signUrl.hashCode();
        }
        return ((hashCode2 * 31 + hashCode3) * 31 + hashCode) * 31 + this.signType;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BatchsignOrderRequestBean(orderIds=");
        sb.append(this.orderIds);
        sb.append(", remark=");
        sb.append(this.remark);
        sb.append(", signUrl=");
        sb.append(this.signUrl);
        sb.append(", signType=");
        sb.append(this.signType);
        sb.append(")");
        return sb.toString();
    }
}
