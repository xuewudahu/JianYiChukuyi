package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u000bH\u00c6\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006$" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/MSwmsReq;", "", "barcode", "", "width", "length", "height", "weight", "pictureUrl", "serialNo", "isTurn", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getBarcode", "()Ljava/lang/String;", "getHeight", "()Z", "getLength", "getPictureUrl", "getSerialNo", "getWeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class MSwmsReq
{
    private final String barcode;
    private final String height;
    private final boolean isTurn;
    private final String length;
    private final String pictureUrl;
    private final String serialNo;
    private final String weight;
    private final String width;
    
    public MSwmsReq(final String barcode, final String width, final String length, final String height, final String weight, final String pictureUrl, final String serialNo, final boolean isTurn) {
        //Intrinsics.checkParameterIsNotNull(barcode, "barcode");
        //Intrinsics.checkParameterIsNotNull(width, "width");
        //Intrinsics.checkParameterIsNotNull(length, "length");
        //Intrinsics.checkParameterIsNotNull(height, "height");
        //Intrinsics.checkParameterIsNotNull(weight, "weight");
        //Intrinsics.checkParameterIsNotNull(pictureUrl, "pictureUrl");
        //Intrinsics.checkParameterIsNotNull(serialNo, "serialNo");
        this.barcode = barcode;
        this.width = width;
        this.length = length;
        this.height = height;
        this.weight = weight;
        this.pictureUrl = pictureUrl;
        this.serialNo = serialNo;
        this.isTurn = isTurn;
    }
    
    public final String component1() {
        return this.barcode;
    }
    
    public final String component2() {
        return this.width;
    }
    
    public final String component3() {
        return this.length;
    }
    
    public final String component4() {
        return this.height;
    }
    
    public final String component5() {
        return this.weight;
    }
    
    public final String component6() {
        return this.pictureUrl;
    }
    
    public final String component7() {
        return this.serialNo;
    }
    
    public final boolean component8() {
        return this.isTurn;
    }
    
    public final MSwmsReq copy(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final String s7, final boolean b) {
        //Intrinsics.checkParameterIsNotNull(s, "barcode");
        //Intrinsics.checkParameterIsNotNull(s2, "width");
        //Intrinsics.checkParameterIsNotNull(s3, "length");
        //Intrinsics.checkParameterIsNotNull(s4, "height");
        //Intrinsics.checkParameterIsNotNull(s5, "weight");
        //Intrinsics.checkParameterIsNotNull(s6, "pictureUrl");
        //Intrinsics.checkParameterIsNotNull(s7, "serialNo");
        return new MSwmsReq(s, s2, s3, s4, s5, s6, s7, b);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof MSwmsReq) {
                final MSwmsReq mSwmsReq = (MSwmsReq)o;
                if (Intrinsics.areEqual(this.barcode, mSwmsReq.barcode) && Intrinsics.areEqual(this.width, mSwmsReq.width) && Intrinsics.areEqual(this.length, mSwmsReq.length) && Intrinsics.areEqual(this.height, mSwmsReq.height) && Intrinsics.areEqual(this.weight, mSwmsReq.weight) && Intrinsics.areEqual(this.pictureUrl, mSwmsReq.pictureUrl) && Intrinsics.areEqual(this.serialNo, mSwmsReq.serialNo) && this.isTurn == mSwmsReq.isTurn) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getBarcode() {
        return this.barcode;
    }
    
    public final String getHeight() {
        return this.height;
    }
    
    public final String getLength() {
        return this.length;
    }
    
    public final String getPictureUrl() {
        return this.pictureUrl;
    }
    
    public final String getSerialNo() {
        return this.serialNo;
    }
    
    public final String getWeight() {
        return this.weight;
    }
    
    public final String getWidth() {
        return this.width;
    }
    
    @Override
    public int hashCode() {
        return 0;
        //throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    public final boolean isTurn() {
        return this.isTurn;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MSwmsReq(barcode=");
        sb.append(this.barcode);
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", length=");
        sb.append(this.length);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", weight=");
        sb.append(this.weight);
        sb.append(", pictureUrl=");
        sb.append(this.pictureUrl);
        sb.append(", serialNo=");
        sb.append(this.serialNo);
        sb.append(", isTurn=");
        sb.append(this.isTurn);
        sb.append(")");
        return sb.toString();
    }
}
