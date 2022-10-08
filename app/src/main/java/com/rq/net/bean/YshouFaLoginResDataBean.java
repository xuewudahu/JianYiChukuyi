package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/YshouFaLoginResDataBean;", "", "userType", "", "token", "(Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getUserType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class YshouFaLoginResDataBean
{
    private final String token;
    private final String userType;
    
    public YshouFaLoginResDataBean(final String userType, final String token) {
        //Intrinsics.checkParameterIsNotNull(userType, "userType");
        //Intrinsics.checkParameterIsNotNull(token, "token");
        this.userType = userType;
        this.token = token;
    }
    
    public final String component1() {
        return this.userType;
    }
    
    public final String component2() {
        return this.token;
    }
    
    public final YshouFaLoginResDataBean copy(final String s, final String s2) {
        //Intrinsics.checkParameterIsNotNull(s, "userType");
        //Intrinsics.checkParameterIsNotNull(s2, "token");
        return new YshouFaLoginResDataBean(s, s2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof YshouFaLoginResDataBean) {
                final YshouFaLoginResDataBean yshouFaLoginResDataBean = (YshouFaLoginResDataBean)o;
                if (Intrinsics.areEqual(this.userType, yshouFaLoginResDataBean.userType) && Intrinsics.areEqual(this.token, yshouFaLoginResDataBean.token)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getToken() {
        return this.token;
    }
    
    public final String getUserType() {
        return this.userType;
    }
    
    @Override
    public int hashCode() {
        final String userType = this.userType;
        int hashCode = 0;
        int hashCode2;
        if (userType != null) {
            hashCode2 = userType.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String token = this.token;
        if (token != null) {
            hashCode = token.hashCode();
        }
        return hashCode2 * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("YshouFaLoginResDataBean(userType=");
        sb.append(this.userType);
        sb.append(", token=");
        sb.append(this.token);
        sb.append(")");
        return sb.toString();
    }
}
