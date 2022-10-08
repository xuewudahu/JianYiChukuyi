package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/YXDLoginBean;", "", "username", "", "password", "grant_type", "scope", "deviceNum", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceNum", "()Ljava/lang/String;", "getGrant_type", "getPassword", "getScope", "getUsername", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class YXDLoginBean
{
    private final String deviceNum;
    private final String grant_type;
    private final String password;
    private final String scope;
    private final String username;
    
    public YXDLoginBean(final String username, final String password, final String grant_type, final String scope, final String deviceNum) {
        //Intrinsics.checkParameterIsNotNull(username, "username");
        //Intrinsics.checkParameterIsNotNull(password, "password");
        //Intrinsics.checkParameterIsNotNull(grant_type, "grant_type");
        //Intrinsics.checkParameterIsNotNull(scope, "scope");
        //Intrinsics.checkParameterIsNotNull(deviceNum, "deviceNum");
        this.username = username;
        this.password = password;
        this.grant_type = grant_type;
        this.scope = scope;
        this.deviceNum = deviceNum;
    }
    
    public final String component1() {
        return this.username;
    }
    
    public final String component2() {
        return this.password;
    }
    
    public final String component3() {
        return this.grant_type;
    }
    
    public final String component4() {
        return this.scope;
    }
    
    public final String component5() {
        return this.deviceNum;
    }
    
    public final YXDLoginBean copy(final String s, final String s2, final String s3, final String s4, final String s5) {
        //Intrinsics.checkParameterIsNotNull(s, "username");
        //Intrinsics.checkParameterIsNotNull(s2, "password");
        //Intrinsics.checkParameterIsNotNull(s3, "grant_type");
        //Intrinsics.checkParameterIsNotNull(s4, "scope");
        //Intrinsics.checkParameterIsNotNull(s5, "deviceNum");
        return new YXDLoginBean(s, s2, s3, s4, s5);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof YXDLoginBean) {
                final YXDLoginBean yxdLoginBean = (YXDLoginBean)o;
                if (Intrinsics.areEqual(this.username, yxdLoginBean.username) && Intrinsics.areEqual(this.password, yxdLoginBean.password) && Intrinsics.areEqual(this.grant_type, yxdLoginBean.grant_type) && Intrinsics.areEqual(this.scope, yxdLoginBean.scope) && Intrinsics.areEqual(this.deviceNum, yxdLoginBean.deviceNum)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getDeviceNum() {
        return this.deviceNum;
    }
    
    public final String getGrant_type() {
        return this.grant_type;
    }
    
    public final String getPassword() {
        return this.password;
    }
    
    public final String getScope() {
        return this.scope;
    }
    
    public final String getUsername() {
        return this.username;
    }
    
    @Override
    public int hashCode() {
        final String username = this.username;
        int hashCode = 0;
        int hashCode2;
        if (username != null) {
            hashCode2 = username.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String password = this.password;
        int hashCode3;
        if (password != null) {
            hashCode3 = password.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String grant_type = this.grant_type;
        int hashCode4;
        if (grant_type != null) {
            hashCode4 = grant_type.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String scope = this.scope;
        int hashCode5;
        if (scope != null) {
            hashCode5 = scope.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String deviceNum = this.deviceNum;
        if (deviceNum != null) {
            hashCode = deviceNum.hashCode();
        }
        return (((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("YXDLoginBean(username=");
        sb.append(this.username);
        sb.append(", password=");
        sb.append(this.password);
        sb.append(", grant_type=");
        sb.append(this.grant_type);
        sb.append(", scope=");
        sb.append(this.scope);
        sb.append(", deviceNum=");
        sb.append(this.deviceNum);
        sb.append(")");
        return sb.toString();
    }
}
