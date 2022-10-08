package com.rq.net.bean;

//import kotlin.*;
import com.rq.net.util.Intrinsics;

import java.util.*;
//import kotlin.jvm.internal.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u00c6\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/ZhongYouUploadWeightData;", "", "operType", "", "templateNo", "", "receivingMode", "operBody", "Ljava/util/ArrayList;", "Lcom/yunpan/cobaaidlservice/bean/ZhongYouUploadWeightDataOperBody;", "Lkotlin/collections/ArrayList;", "(ILjava/lang/String;ILjava/util/ArrayList;)V", "getOperBody", "()Ljava/util/ArrayList;", "getOperType", "()I", "getReceivingMode", "getTemplateNo", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class ZhongYouUploadWeightData
{
    private final ArrayList<ZhongYouUploadWeightDataOperBody> operBody;
    private final int operType;
    private final int receivingMode;
    private final String templateNo;
    
    public ZhongYouUploadWeightData(final int operType, final String templateNo, final int receivingMode, final ArrayList<ZhongYouUploadWeightDataOperBody> operBody) {
        //Intrinsics.checkParameterIsNotNull(templateNo, "templateNo");
        //Intrinsics.checkParameterIsNotNull(operBody, "operBody");
        this.operType = operType;
        this.templateNo = templateNo;
        this.receivingMode = receivingMode;
        this.operBody = operBody;
    }
    
    public final int component1() {
        return this.operType;
    }
    
    public final String component2() {
        return this.templateNo;
    }
    
    public final int component3() {
        return this.receivingMode;
    }
    
    public final ArrayList<ZhongYouUploadWeightDataOperBody> component4() {
        return this.operBody;
    }
    
    public final ZhongYouUploadWeightData copy(final int n, final String s, final int n2, final ArrayList<ZhongYouUploadWeightDataOperBody> list) {
        //Intrinsics.checkParameterIsNotNull(s, "templateNo");
        //Intrinsics.checkParameterIsNotNull(list, "operBody");
        return new ZhongYouUploadWeightData(n, s, n2, list);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof ZhongYouUploadWeightData) {
                final ZhongYouUploadWeightData zhongYouUploadWeightData = (ZhongYouUploadWeightData)o;
                if (this.operType == zhongYouUploadWeightData.operType && Intrinsics.areEqual(this.templateNo, zhongYouUploadWeightData.templateNo) && this.receivingMode == zhongYouUploadWeightData.receivingMode && Intrinsics.areEqual(this.operBody, zhongYouUploadWeightData.operBody)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final ArrayList<ZhongYouUploadWeightDataOperBody> getOperBody() {
        return this.operBody;
    }
    
    public final int getOperType() {
        return this.operType;
    }
    
    public final int getReceivingMode() {
        return this.receivingMode;
    }
    
    public final String getTemplateNo() {
        return this.templateNo;
    }
    
    @Override
    public int hashCode() {
        final int operType = this.operType;
        final String templateNo = this.templateNo;
        int hashCode = 0;
        int hashCode2;
        if (templateNo != null) {
            hashCode2 = templateNo.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final int receivingMode = this.receivingMode;
        final ArrayList<ZhongYouUploadWeightDataOperBody> operBody = this.operBody;
        if (operBody != null) {
            hashCode = operBody.hashCode();
        }
        return ((operType * 31 + hashCode2) * 31 + receivingMode) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ZhongYouUploadWeightData(operType=");
        sb.append(this.operType);
        sb.append(", templateNo=");
        sb.append(this.templateNo);
        sb.append(", receivingMode=");
        sb.append(this.receivingMode);
        sb.append(", operBody=");
        sb.append(this.operBody);
        sb.append(")");
        return sb.toString();
    }
}
