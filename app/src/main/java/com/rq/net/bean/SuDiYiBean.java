package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/SuDiYiBean;", "", "source", "", "target", "time", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getTarget", "getTime", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class SuDiYiBean
{
    private final String source;
    private final String target;
    private final String time;
    private final String type;
    
    public SuDiYiBean(final String source, final String target, final String time, final String type) {
        //Intrinsics.checkParameterIsNotNull(source, "source");
        //Intrinsics.checkParameterIsNotNull(target, "target");
        //Intrinsics.checkParameterIsNotNull(time, "time");
        //Intrinsics.checkParameterIsNotNull(type, "type");
        this.source = source;
        this.target = target;
        this.time = time;
        this.type = type;
    }
    
    public final String component1() {
        return this.source;
    }
    
    public final String component2() {
        return this.target;
    }
    
    public final String component3() {
        return this.time;
    }
    
    public final String component4() {
        return this.type;
    }
    
    public final SuDiYiBean copy(final String s, final String s2, final String s3, final String s4) {
        //Intrinsics.checkParameterIsNotNull(s, "source");
        //Intrinsics.checkParameterIsNotNull(s2, "target");
        //Intrinsics.checkParameterIsNotNull(s3, "time");
        //Intrinsics.checkParameterIsNotNull(s4, "type");
        return new SuDiYiBean(s, s2, s3, s4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof SuDiYiBean) {
                final SuDiYiBean suDiYiBean = (SuDiYiBean)o;
                if (Intrinsics.areEqual(this.source, suDiYiBean.source) && Intrinsics.areEqual(this.target, suDiYiBean.target) && Intrinsics.areEqual(this.time, suDiYiBean.time) && Intrinsics.areEqual(this.type, suDiYiBean.type)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getSource() {
        return this.source;
    }
    
    public final String getTarget() {
        return this.target;
    }
    
    public final String getTime() {
        return this.time;
    }
    
    public final String getType() {
        return this.type;
    }
    
    @Override
    public int hashCode() {
        final String source = this.source;
        int hashCode = 0;
        int hashCode2;
        if (source != null) {
            hashCode2 = source.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String target = this.target;
        int hashCode3;
        if (target != null) {
            hashCode3 = target.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String time = this.time;
        int hashCode4;
        if (time != null) {
            hashCode4 = time.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String type = this.type;
        if (type != null) {
            hashCode = type.hashCode();
        }
        return ((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SuDiYiBean(source=");
        sb.append(this.source);
        sb.append(", target=");
        sb.append(this.target);
        sb.append(", time=");
        sb.append(this.time);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(")");
        return sb.toString();
    }
}
