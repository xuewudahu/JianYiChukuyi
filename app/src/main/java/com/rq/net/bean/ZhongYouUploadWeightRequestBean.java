package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/ZhongYouUploadWeightRequestBean;", "", "businessType", "", "operateType", "data", "", "(IILjava/lang/String;)V", "getBusinessType", "()I", "getData", "()Ljava/lang/String;", "getOperateType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class ZhongYouUploadWeightRequestBean
{
    private final int businessType;
    private final String data;
    private final int operateType;
    
    public ZhongYouUploadWeightRequestBean(final int businessType, final int operateType, final String data) {
        //Intrinsics.checkParameterIsNotNull(data, "data");
        this.businessType = businessType;
        this.operateType = operateType;
        this.data = data;
    }
    
    public final int component1() {
        return this.businessType;
    }
    
    public final int component2() {
        return this.operateType;
    }
    
    public final String component3() {
        return this.data;
    }
    
    public final ZhongYouUploadWeightRequestBean copy(final int n, final int n2, final String s) {
        //Intrinsics.checkParameterIsNotNull(s, "data");
        return new ZhongYouUploadWeightRequestBean(n, n2, s);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof ZhongYouUploadWeightRequestBean) {
                final ZhongYouUploadWeightRequestBean zhongYouUploadWeightRequestBean = (ZhongYouUploadWeightRequestBean)o;
                if (this.businessType == zhongYouUploadWeightRequestBean.businessType && this.operateType == zhongYouUploadWeightRequestBean.operateType && Intrinsics.areEqual(this.data, zhongYouUploadWeightRequestBean.data)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final int getBusinessType() {
        return this.businessType;
    }
    
    public final String getData() {
        return this.data;
    }
    
    public final int getOperateType() {
        return this.operateType;
    }
    
    @Override
    public int hashCode() {
        final int businessType = this.businessType;
        final int operateType = this.operateType;
        final String data = this.data;
        int hashCode;
        if (data != null) {
            hashCode = data.hashCode();
        }
        else {
            hashCode = 0;
        }
        return (businessType * 31 + operateType) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ZhongYouUploadWeightRequestBean(businessType=");
        sb.append(this.businessType);
        sb.append(", operateType=");
        sb.append(this.operateType);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(")");
        return sb.toString();
    }
}
