package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/LoginResponseDataBean;", "", "auid", "", "asuid", "token", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAsuid", "()Ljava/lang/String;", "getAuid", "getToken", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class LoginResponseDataBean
{
    private final String asuid;
    private final String auid;
    private final String token;
    
    public LoginResponseDataBean(final String auid, final String asuid, final String token) {
        //Intrinsics.checkParameterIsNotNull(auid, "auid");
        //Intrinsics.checkParameterIsNotNull(asuid, "asuid");
        //Intrinsics.checkParameterIsNotNull(token, "token");
        this.auid = auid;
        this.asuid = asuid;
        this.token = token;
    }
    
    public final String component1() {
        return this.auid;
    }
    
    public final String component2() {
        return this.asuid;
    }
    
    public final String component3() {
        return this.token;
    }
    
    public final LoginResponseDataBean copy(final String s, final String s2, final String s3) {
        //Intrinsics.checkParameterIsNotNull(s, "auid");
        //Intrinsics.checkParameterIsNotNull(s2, "asuid");
        //Intrinsics.checkParameterIsNotNull(s3, "token");
        return new LoginResponseDataBean(s, s2, s3);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof LoginResponseDataBean) {
                final LoginResponseDataBean loginResponseDataBean = (LoginResponseDataBean)o;
                if (Intrinsics.areEqual(this.auid, loginResponseDataBean.auid) && Intrinsics.areEqual(this.asuid, loginResponseDataBean.asuid) && Intrinsics.areEqual(this.token, loginResponseDataBean.token)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getAsuid() {
        return this.asuid;
    }
    
    public final String getAuid() {
        return this.auid;
    }
    
    public final String getToken() {
        return this.token;
    }
    
    @Override
    public int hashCode() {
        final String auid = this.auid;
        int hashCode = 0;
        int hashCode2;
        if (auid != null) {
            hashCode2 = auid.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String asuid = this.asuid;
        int hashCode3;
        if (asuid != null) {
            hashCode3 = asuid.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String token = this.token;
        if (token != null) {
            hashCode = token.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LoginResponseDataBean(auid=");
        sb.append(this.auid);
        sb.append(", asuid=");
        sb.append(this.asuid);
        sb.append(", token=");
        sb.append(this.token);
        sb.append(")");
        return sb.toString();
    }
}
