package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/QuerySendOrderDataResponseBean;", "", "batchNo", "", "encTel", "expressName", "mailno", "takeCode", "createTime", "orderId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBatchNo", "()Ljava/lang/String;", "getCreateTime", "getEncTel", "getExpressName", "getMailno", "getOrderId", "getTakeCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class QuerySendOrderDataResponseBean
{
    private final String batchNo;
    private final String createTime;
    private final String encTel;
    private final String expressName;
    private final String mailno;
    private final String orderId;
    private final String takeCode;
    
    public QuerySendOrderDataResponseBean(final String batchNo, final String encTel, final String expressName, final String mailno, final String takeCode, final String createTime, final String orderId) {
        //Intrinsics.checkParameterIsNotNull(batchNo, "batchNo");
        //Intrinsics.checkParameterIsNotNull(encTel, "encTel");
        //Intrinsics.checkParameterIsNotNull(expressName, "expressName");
        //Intrinsics.checkParameterIsNotNull(mailno, "mailno");
        //Intrinsics.checkParameterIsNotNull(takeCode, "takeCode");
        //Intrinsics.checkParameterIsNotNull(createTime, "createTime");
        //Intrinsics.checkParameterIsNotNull(orderId, "orderId");
        this.batchNo = batchNo;
        this.encTel = encTel;
        this.expressName = expressName;
        this.mailno = mailno;
        this.takeCode = takeCode;
        this.createTime = createTime;
        this.orderId = orderId;
    }
    
    public final String component1() {
        return this.batchNo;
    }
    
    public final String component2() {
        return this.encTel;
    }
    
    public final String component3() {
        return this.expressName;
    }
    
    public final String component4() {
        return this.mailno;
    }
    
    public final String component5() {
        return this.takeCode;
    }
    
    public final String component6() {
        return this.createTime;
    }
    
    public final String component7() {
        return this.orderId;
    }
    
    public final QuerySendOrderDataResponseBean copy(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final String s7) {
        //Intrinsics.checkParameterIsNotNull(s, "batchNo");
        //Intrinsics.checkParameterIsNotNull(s2, "encTel");
        //Intrinsics.checkParameterIsNotNull(s3, "expressName");
        //Intrinsics.checkParameterIsNotNull(s4, "mailno");
        //Intrinsics.checkParameterIsNotNull(s5, "takeCode");
        //Intrinsics.checkParameterIsNotNull(s6, "createTime");
        //Intrinsics.checkParameterIsNotNull(s7, "orderId");
        return new QuerySendOrderDataResponseBean(s, s2, s3, s4, s5, s6, s7);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof QuerySendOrderDataResponseBean) {
                final QuerySendOrderDataResponseBean querySendOrderDataResponseBean = (QuerySendOrderDataResponseBean)o;
                if (Intrinsics.areEqual(this.batchNo, querySendOrderDataResponseBean.batchNo) && Intrinsics.areEqual(this.encTel, querySendOrderDataResponseBean.encTel) && Intrinsics.areEqual(this.expressName, querySendOrderDataResponseBean.expressName) && Intrinsics.areEqual(this.mailno, querySendOrderDataResponseBean.mailno) && Intrinsics.areEqual(this.takeCode, querySendOrderDataResponseBean.takeCode) && Intrinsics.areEqual(this.createTime, querySendOrderDataResponseBean.createTime) && Intrinsics.areEqual(this.orderId, querySendOrderDataResponseBean.orderId)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getBatchNo() {
        return this.batchNo;
    }
    
    public final String getCreateTime() {
        return this.createTime;
    }
    
    public final String getEncTel() {
        return this.encTel;
    }
    
    public final String getExpressName() {
        return this.expressName;
    }
    
    public final String getMailno() {
        return this.mailno;
    }
    
    public final String getOrderId() {
        return this.orderId;
    }
    
    public final String getTakeCode() {
        return this.takeCode;
    }
    
    @Override
    public int hashCode() {
        final String batchNo = this.batchNo;
        int hashCode = 0;
        int hashCode2;
        if (batchNo != null) {
            hashCode2 = batchNo.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String encTel = this.encTel;
        int hashCode3;
        if (encTel != null) {
            hashCode3 = encTel.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String expressName = this.expressName;
        int hashCode4;
        if (expressName != null) {
            hashCode4 = expressName.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String mailno = this.mailno;
        int hashCode5;
        if (mailno != null) {
            hashCode5 = mailno.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String takeCode = this.takeCode;
        int hashCode6;
        if (takeCode != null) {
            hashCode6 = takeCode.hashCode();
        }
        else {
            hashCode6 = 0;
        }
        final String createTime = this.createTime;
        int hashCode7;
        if (createTime != null) {
            hashCode7 = createTime.hashCode();
        }
        else {
            hashCode7 = 0;
        }
        final String orderId = this.orderId;
        if (orderId != null) {
            hashCode = orderId.hashCode();
        }
        return (((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("QuerySendOrderDataResponseBean(batchNo=");
        sb.append(this.batchNo);
        sb.append(", encTel=");
        sb.append(this.encTel);
        sb.append(", expressName=");
        sb.append(this.expressName);
        sb.append(", mailno=");
        sb.append(this.mailno);
        sb.append(", takeCode=");
        sb.append(this.takeCode);
        sb.append(", createTime=");
        sb.append(this.createTime);
        sb.append(", orderId=");
        sb.append(this.orderId);
        sb.append(")");
        return sb.toString();
    }
}
