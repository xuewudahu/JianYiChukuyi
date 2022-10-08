package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/ResultDataBean;", "", "expressCode", "", "expressName", "logisticNo", "estimateWeight", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getEstimateWeight", "()I", "getExpressCode", "()Ljava/lang/String;", "getExpressName", "getLogisticNo", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class ResultDataBean
{
    private final int estimateWeight;
    private final String expressCode;
    private final String expressName;
    private final String logisticNo;
    
    public ResultDataBean(final String expressCode, final String expressName, final String logisticNo, final int estimateWeight) {
        //Intrinsics.checkParameterIsNotNull(expressCode, "expressCode");
        //Intrinsics.checkParameterIsNotNull(expressName, "expressName");
        //Intrinsics.checkParameterIsNotNull(logisticNo, "logisticNo");
        this.expressCode = expressCode;
        this.expressName = expressName;
        this.logisticNo = logisticNo;
        this.estimateWeight = estimateWeight;
    }
    
    public final String component1() {
        return this.expressCode;
    }
    
    public final String component2() {
        return this.expressName;
    }
    
    public final String component3() {
        return this.logisticNo;
    }
    
    public final int component4() {
        return this.estimateWeight;
    }
    
    public final ResultDataBean copy(final String s, final String s2, final String s3, final int n) {
        //Intrinsics.checkParameterIsNotNull(s, "expressCode");
        //Intrinsics.checkParameterIsNotNull(s2, "expressName");
        //Intrinsics.checkParameterIsNotNull(s3, "logisticNo");
        return new ResultDataBean(s, s2, s3, n);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof ResultDataBean) {
                final ResultDataBean resultDataBean = (ResultDataBean)o;
                if (Intrinsics.areEqual(this.expressCode, resultDataBean.expressCode) && Intrinsics.areEqual(this.expressName, resultDataBean.expressName) && Intrinsics.areEqual(this.logisticNo, resultDataBean.logisticNo) && this.estimateWeight == resultDataBean.estimateWeight) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final int getEstimateWeight() {
        return this.estimateWeight;
    }
    
    public final String getExpressCode() {
        return this.expressCode;
    }
    
    public final String getExpressName() {
        return this.expressName;
    }
    
    public final String getLogisticNo() {
        return this.logisticNo;
    }
    
    @Override
    public int hashCode() {
        final String expressCode = this.expressCode;
        int hashCode = 0;
        int hashCode2;
        if (expressCode != null) {
            hashCode2 = expressCode.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String expressName = this.expressName;
        int hashCode3;
        if (expressName != null) {
            hashCode3 = expressName.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String logisticNo = this.logisticNo;
        if (logisticNo != null) {
            hashCode = logisticNo.hashCode();
        }
        return ((hashCode2 * 31 + hashCode3) * 31 + hashCode) * 31 + this.estimateWeight;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ResultDataBean(expressCode=");
        sb.append(this.expressCode);
        sb.append(", expressName=");
        sb.append(this.expressName);
        sb.append(", logisticNo=");
        sb.append(this.logisticNo);
        sb.append(", estimateWeight=");
        sb.append(this.estimateWeight);
        sb.append(")");
        return sb.toString();
    }
}
