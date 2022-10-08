package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/HylLoginBean;", "", "device_id", "", "(Ljava/lang/String;)V", "getDevice_id", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class HylLoginBean
{
    private final String device_id;
    
    public HylLoginBean(final String device_id) {
        //Intrinsics.checkParameterIsNotNull(device_id, "device_id");
        this.device_id = device_id;
    }
    
    public final String component1() {
        return this.device_id;
    }
    
    public final HylLoginBean copy(final String s) {
        //Intrinsics.checkParameterIsNotNull(s, "device_id");
        return new HylLoginBean(s);
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof HylLoginBean && Intrinsics.areEqual(this.device_id, ((HylLoginBean)o).device_id));
    }
    
    public final String getDevice_id() {
        return this.device_id;
    }
    
    @Override
    public int hashCode() {
        final String device_id = this.device_id;
        if (device_id != null) {
            return device_id.hashCode();
        }
        return 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("HylLoginBean(device_id=");
        sb.append(this.device_id);
        sb.append(")");
        return sb.toString();
    }
}
