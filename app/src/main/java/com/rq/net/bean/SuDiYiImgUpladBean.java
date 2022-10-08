package com.rq.net.bean;

//import kotlin.*;
import com.rq.net.util.Intrinsics;

import java.io.*;
//import kotlin.jvm.internal.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/SuDiYiImgUpladBean;", "", "expressNo", "", "expressImage", "Ljava/io/File;", "userImage", "(Ljava/lang/String;Ljava/io/File;Ljava/io/File;)V", "getExpressImage", "()Ljava/io/File;", "getExpressNo", "()Ljava/lang/String;", "getUserImage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class SuDiYiImgUpladBean
{
    private final File expressImage;
    private final String expressNo;
    private final File userImage;
    
    public SuDiYiImgUpladBean(final String expressNo, final File expressImage, final File userImage) {
        //Intrinsics.checkParameterIsNotNull(expressNo, "expressNo");
        //Intrinsics.checkParameterIsNotNull(expressImage, "expressImage");
        //Intrinsics.checkParameterIsNotNull(userImage, "userImage");
        this.expressNo = expressNo;
        this.expressImage = expressImage;
        this.userImage = userImage;
    }
    
    public final String component1() {
        return this.expressNo;
    }
    
    public final File component2() {
        return this.expressImage;
    }
    
    public final File component3() {
        return this.userImage;
    }
    
    public final SuDiYiImgUpladBean copy(final String s, final File file, final File file2) {
        //Intrinsics.checkParameterIsNotNull(s, "expressNo");
        //Intrinsics.checkParameterIsNotNull(file, "expressImage");
        //Intrinsics.checkParameterIsNotNull(file2, "userImage");
        return new SuDiYiImgUpladBean(s, file, file2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof SuDiYiImgUpladBean) {
                final SuDiYiImgUpladBean suDiYiImgUpladBean = (SuDiYiImgUpladBean)o;
                if (Intrinsics.areEqual(this.expressNo, suDiYiImgUpladBean.expressNo) && Intrinsics.areEqual(this.expressImage, suDiYiImgUpladBean.expressImage) && Intrinsics.areEqual(this.userImage, suDiYiImgUpladBean.userImage)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final File getExpressImage() {
        return this.expressImage;
    }
    
    public final String getExpressNo() {
        return this.expressNo;
    }
    
    public final File getUserImage() {
        return this.userImage;
    }
    
    @Override
    public int hashCode() {
        final String expressNo = this.expressNo;
        int hashCode = 0;
        int hashCode2;
        if (expressNo != null) {
            hashCode2 = expressNo.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final File expressImage = this.expressImage;
        int hashCode3;
        if (expressImage != null) {
            hashCode3 = expressImage.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final File userImage = this.userImage;
        if (userImage != null) {
            hashCode = userImage.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SuDiYiImgUpladBean(expressNo=");
        sb.append(this.expressNo);
        sb.append(", expressImage=");
        sb.append(this.expressImage);
        sb.append(", userImage=");
        sb.append(this.userImage);
        sb.append(")");
        return sb.toString();
    }
}
