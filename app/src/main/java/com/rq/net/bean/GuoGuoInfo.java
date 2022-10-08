package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/GuoGuoInfo;", "", "apiId", "", "apiKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getApiId", "()Ljava/lang/String;", "setApiId", "(Ljava/lang/String;)V", "getApiKey", "setApiKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class GuoGuoInfo
{
    private String apiId;
    private String apiKey;
    
    public GuoGuoInfo() {
        this(null, null);
    }
    
    public GuoGuoInfo(final String apiId, final String apiKey) {
        //Intrinsics.checkParameterIsNotNull(apiId, "apiId");
        //Intrinsics.checkParameterIsNotNull(apiKey, "apiKey");
        this.apiId = apiId;
        this.apiKey = apiKey;
    }
    
    public final String component1() {
        return this.apiId;
    }
    
    public final String component2() {
        return this.apiKey;
    }
    
    public final GuoGuoInfo copy(final String s, final String s2) {
        //Intrinsics.checkParameterIsNotNull(s, "apiId");
        //Intrinsics.checkParameterIsNotNull(s2, "apiKey");
        return new GuoGuoInfo(s, s2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof GuoGuoInfo) {
                final GuoGuoInfo guoGuoInfo = (GuoGuoInfo)o;
                if (Intrinsics.areEqual(this.apiId, guoGuoInfo.apiId) && Intrinsics.areEqual(this.apiKey, guoGuoInfo.apiKey)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getApiId() {
        return this.apiId;
    }
    
    public final String getApiKey() {
        return this.apiKey;
    }
    
    @Override
    public int hashCode() {
        final String apiId = this.apiId;
        int hashCode = 0;
        int hashCode2;
        if (apiId != null) {
            hashCode2 = apiId.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String apiKey = this.apiKey;
        if (apiKey != null) {
            hashCode = apiKey.hashCode();
        }
        return hashCode2 * 31 + hashCode;
    }
    
    public final void setApiId(final String apiId) {
        //Intrinsics.checkParameterIsNotNull(apiId, "<set-?>");
        this.apiId = apiId;
    }
    
    public final void setApiKey(final String apiKey) {
        //Intrinsics.checkParameterIsNotNull(apiKey, "<set-?>");
        this.apiKey = apiKey;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GuoGuoInfo(apiId=");
        sb.append(this.apiId);
        sb.append(", apiKey=");
        sb.append(this.apiKey);
        sb.append(")");
        return sb.toString();
    }
}
