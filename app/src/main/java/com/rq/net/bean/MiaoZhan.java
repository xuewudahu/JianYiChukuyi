package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0004H\u00c6\u0003J\u000e\u0010\u0010\u001a\u00028\u0000H\u00c6\u0003¢\u0006\u0002\u0010\u000bJ2\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00028\u0000H\u00c6\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0004H\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0019" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/MiaoZhan;", "T", "", "brand", "", "sign", "content", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getBrand", "()Ljava/lang/String;", "getContent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSign", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/yunpan/cobaaidlservice/bean/MiaoZhan;", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class MiaoZhan<T>
{
    private final String brand;
    private final T content;
    private final String sign;
    
    public MiaoZhan(final String brand, final String sign, final T content) {
        //Intrinsics.checkParameterIsNotNull(brand, "brand");
        //Intrinsics.checkParameterIsNotNull(sign, "sign");
        this.brand = brand;
        this.sign = sign;
        this.content = content;
    }
    
    public final String component1() {
        return this.brand;
    }
    
    public final String component2() {
        return this.sign;
    }
    
    public final T component3() {
        return this.content;
    }
    
    public final MiaoZhan<T> copy(final String s, final String s2, final T t) {
        //Intrinsics.checkParameterIsNotNull(s, "brand");
        //Intrinsics.checkParameterIsNotNull(s2, "sign");
        return new MiaoZhan<T>(s, s2, t);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof MiaoZhan) {
                final MiaoZhan miaoZhan = (MiaoZhan)o;
                if (Intrinsics.areEqual(this.brand, miaoZhan.brand) && Intrinsics.areEqual(this.sign, miaoZhan.sign) && Intrinsics.areEqual(this.content, miaoZhan.content)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getBrand() {
        return this.brand;
    }
    
    public final T getContent() {
        return this.content;
    }
    
    public final String getSign() {
        return this.sign;
    }
    
    @Override
    public int hashCode() {
        final String brand = this.brand;
        int hashCode = 0;
        int hashCode2;
        if (brand != null) {
            hashCode2 = brand.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String sign = this.sign;
        int hashCode3;
        if (sign != null) {
            hashCode3 = sign.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final T content = this.content;
        if (content != null) {
            hashCode = content.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MiaoZhan(brand=");
        sb.append(this.brand);
        sb.append(", sign=");
        sb.append(this.sign);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(")");
        return sb.toString();
    }
}
