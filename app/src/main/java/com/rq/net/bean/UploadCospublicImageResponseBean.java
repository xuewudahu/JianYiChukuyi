package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/UploadCospublicImageResponseBean;", "", "code", "", "data", "", "url", "total", "msg", "fileName", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Ljava/lang/String;", "getFileName", "getMsg", "getTotal", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class UploadCospublicImageResponseBean
{
    private final int code;
    private final String data;
    private final String fileName;
    private final String msg;
    private final int total;
    private final String url;
    
    public UploadCospublicImageResponseBean(final int code, final String data, final String url, final int total, final String msg, final String fileName) {
        //Intrinsics.checkParameterIsNotNull(data, "data");
        //Intrinsics.checkParameterIsNotNull(url, "url");
        //Intrinsics.checkParameterIsNotNull(msg, "msg");
        //Intrinsics.checkParameterIsNotNull(fileName, "fileName");
        this.code = code;
        this.data = data;
        this.url = url;
        this.total = total;
        this.msg = msg;
        this.fileName = fileName;
    }
    
    public final int component1() {
        return this.code;
    }
    
    public final String component2() {
        return this.data;
    }
    
    public final String component3() {
        return this.url;
    }
    
    public final int component4() {
        return this.total;
    }
    
    public final String component5() {
        return this.msg;
    }
    
    public final String component6() {
        return this.fileName;
    }
    
    public final UploadCospublicImageResponseBean copy(final int n, final String s, final String s2, final int n2, final String s3, final String s4) {
        //Intrinsics.checkParameterIsNotNull(s, "data");
        //Intrinsics.checkParameterIsNotNull(s2, "url");
        //Intrinsics.checkParameterIsNotNull(s3, "msg");
        //Intrinsics.checkParameterIsNotNull(s4, "fileName");
        return new UploadCospublicImageResponseBean(n, s, s2, n2, s3, s4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof UploadCospublicImageResponseBean) {
                final UploadCospublicImageResponseBean uploadCospublicImageResponseBean = (UploadCospublicImageResponseBean)o;
                if (this.code == uploadCospublicImageResponseBean.code && Intrinsics.areEqual(this.data, uploadCospublicImageResponseBean.data) && Intrinsics.areEqual(this.url, uploadCospublicImageResponseBean.url) && this.total == uploadCospublicImageResponseBean.total && Intrinsics.areEqual(this.msg, uploadCospublicImageResponseBean.msg) && Intrinsics.areEqual(this.fileName, uploadCospublicImageResponseBean.fileName)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final int getCode() {
        return this.code;
    }
    
    public final String getData() {
        return this.data;
    }
    
    public final String getFileName() {
        return this.fileName;
    }
    
    public final String getMsg() {
        return this.msg;
    }
    
    public final int getTotal() {
        return this.total;
    }
    
    public final String getUrl() {
        return this.url;
    }
    
    @Override
    public int hashCode() {
        final int code = this.code;
        final String data = this.data;
        int hashCode = 0;
        int hashCode2;
        if (data != null) {
            hashCode2 = data.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String url = this.url;
        int hashCode3;
        if (url != null) {
            hashCode3 = url.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final int total = this.total;
        final String msg = this.msg;
        int hashCode4;
        if (msg != null) {
            hashCode4 = msg.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String fileName = this.fileName;
        if (fileName != null) {
            hashCode = fileName.hashCode();
        }
        return ((((code * 31 + hashCode2) * 31 + hashCode3) * 31 + total) * 31 + hashCode4) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("UploadCospublicImageResponseBean(code=");
        sb.append(this.code);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", total=");
        sb.append(this.total);
        sb.append(", msg=");
        sb.append(this.msg);
        sb.append(", fileName=");
        sb.append(this.fileName);
        sb.append(")");
        return sb.toString();
    }
}
