package com.rq.net.bean;

//import kotlin.*;
import com.rq.net.util.Intrinsics;

import java.util.*;
//import kotlin.jvm.internal.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0004H\u00c6\u0003J7\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/YXDOrderReqBean;", "", "billCodes", "", "", "outSource", "scanTime", "outImageKey", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBillCodes", "()Ljava/util/List;", "getOutImageKey", "()Ljava/lang/String;", "getOutSource", "getScanTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class YXDOrderReqBean
{
    private final List<String> billCodes;
    private final String billCode;
    private final String outImageKey;
    private final String outSource;
    private final String scanTime;

    public YXDOrderReqBean(final List<String> billCodes,final String billCode, final String outSource, final String scanTime, final String outImageKey) {
        //Intrinsics.checkParameterIsNotNull(billCodes, "billCodes");
        //Intrinsics.checkParameterIsNotNull(outSource, "outSource");
        //Intrinsics.checkParameterIsNotNull(scanTime, "scanTime");
        //Intrinsics.checkParameterIsNotNull(outImageKey, "outImageKey");
        this.billCodes = billCodes;
        this.billCode = billCode;
        this.outSource = outSource;
        this.scanTime = scanTime;
        this.outImageKey = outImageKey;
    }

    public final List<String> component1() {
        return this.billCodes;
    }

    public final String component2() {
        return this.outSource;
    }

    public final String component3() {
        return this.scanTime;
    }

    public final String component4() {
        return this.outImageKey;
    }

    public final YXDOrderReqBean copy(final List<String> list, final String billcode, final String s, final String s2, final String s3) {
        //Intrinsics.checkParameterIsNotNull(list, "billCodes");
        //Intrinsics.checkParameterIsNotNull(s, "outSource");
        //Intrinsics.checkParameterIsNotNull(s2, "scanTime");
        //Intrinsics.checkParameterIsNotNull(s3, "outImageKey");
        return new YXDOrderReqBean(list,billcode, s, s2, s3);
    }

    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof YXDOrderReqBean) {
                final YXDOrderReqBean yxdOrderReqBean = (YXDOrderReqBean)o;
                if (Intrinsics.areEqual(this.billCodes, yxdOrderReqBean.billCodes) && Intrinsics.areEqual(this.outSource, yxdOrderReqBean.outSource) && Intrinsics.areEqual(this.scanTime, yxdOrderReqBean.scanTime) && Intrinsics.areEqual(this.outImageKey, yxdOrderReqBean.outImageKey)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final List<String> getBillCodes() {
        return this.billCodes;
    }

    public final String getBillCode(){
        return this.billCode;
    }

    public final String getOutImageKey() {
        return this.outImageKey;
    }

    public final String getOutSource() {
        return this.outSource;
    }

    public final String getScanTime() {
        return this.scanTime;
    }

    @Override
    public int hashCode() {
        final List<String> billCodes = this.billCodes;
        int hashCode = 0;
        int hashCode2;
        if (billCodes != null) {
            hashCode2 = billCodes.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String billCode = this.billCode;
        int hashCode5;
        if (billCode != null) {
            hashCode5 = billCode.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String outSource = this.outSource;
        int hashCode3;
        if (outSource != null) {
            hashCode3 = outSource.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String scanTime = this.scanTime;
        int hashCode4;
        if (scanTime != null) {
            hashCode4 = scanTime.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String outImageKey = this.outImageKey;
        if (outImageKey != null) {
            hashCode = outImageKey.hashCode();
        }
        return (((hashCode2 * 31 + hashCode5) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("YXDOrderReqBean(billCodes=");
        sb.append(this.billCodes);
        sb.append(", billCode=");
        sb.append(this.billCode);
        sb.append(", outSource=");
        sb.append(this.outSource);
        sb.append(", scanTime=");
        sb.append(this.scanTime);
        sb.append(", outImageKey=");
        sb.append(this.outImageKey);
        sb.append(")");
        return sb.toString();
    }
}
