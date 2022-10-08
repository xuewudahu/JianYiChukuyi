package com.rq.net.bean;

//import kotlin.*;
import com.rq.net.util.Intrinsics;

import java.util.*;
//import kotlin.jvm.internal.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u00c6\u0003J8\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/PandaOutData;", "", "todoParcel", "", "data", "", "Lcom/yunpan/cobaaidlservice/bean/PandaStayData;", "currentParcel", "Lcom/yunpan/cobaaidlservice/bean/CurrentParcel;", "(Ljava/lang/Integer;Ljava/util/List;Lcom/yunpan/cobaaidlservice/bean/CurrentParcel;)V", "getCurrentParcel", "()Lcom/yunpan/cobaaidlservice/bean/CurrentParcel;", "getData", "()Ljava/util/List;", "getTodoParcel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/List;Lcom/yunpan/cobaaidlservice/bean/CurrentParcel;)Lcom/yunpan/cobaaidlservice/bean/PandaOutData;", "equals", "", "other", "hashCode", "toString", "", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class PandaOutData
{
    private final CurrentParcel currentParcel;
    private final List<PandaStayData> data;
    private final Integer todoParcel;
    
    public PandaOutData(final Integer todoParcel, final List<PandaStayData> data, final CurrentParcel currentParcel) {
        this.todoParcel = todoParcel;
        this.data = data;
        this.currentParcel = currentParcel;
    }
    
    public final Integer component1() {
        return this.todoParcel;
    }
    
    public final List<PandaStayData> component2() {
        return this.data;
    }
    
    public final CurrentParcel component3() {
        return this.currentParcel;
    }
    
    public final PandaOutData copy(final Integer n, final List<PandaStayData> list, final CurrentParcel currentParcel) {
        return new PandaOutData(n, list, currentParcel);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PandaOutData) {
                final PandaOutData pandaOutData = (PandaOutData)o;
                if (Intrinsics.areEqual(this.todoParcel, pandaOutData.todoParcel) && Intrinsics.areEqual(this.data, pandaOutData.data) && Intrinsics.areEqual(this.currentParcel, pandaOutData.currentParcel)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final CurrentParcel getCurrentParcel() {
        return this.currentParcel;
    }
    
    public final List<PandaStayData> getData() {
        return this.data;
    }
    
    public final Integer getTodoParcel() {
        return this.todoParcel;
    }
    
    @Override
    public int hashCode() {
        final Integer todoParcel = this.todoParcel;
        int hashCode = 0;
        int hashCode2;
        if (todoParcel != null) {
            hashCode2 = todoParcel.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final List<PandaStayData> data = this.data;
        int hashCode3;
        if (data != null) {
            hashCode3 = data.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final CurrentParcel currentParcel = this.currentParcel;
        if (currentParcel != null) {
            hashCode = currentParcel.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PandaOutData(todoParcel=");
        sb.append(this.todoParcel);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", currentParcel=");
        sb.append(this.currentParcel);
        sb.append(")");
        return sb.toString();
    }
}
