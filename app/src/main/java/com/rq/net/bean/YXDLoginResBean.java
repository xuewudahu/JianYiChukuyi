package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003Jw\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020+H\u00d6\u0001J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006-" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/YXDLoginResBean;", "", "realName", "", "nickName", "openId", "mobile", "userName", "userId", "email", "allDataPermission", "jti", "accessToken", "refreshToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getAllDataPermission", "getEmail", "getJti", "getMobile", "getNickName", "getOpenId", "getRealName", "getRefreshToken", "getUserId", "getUserName", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class YXDLoginResBean
{
    private final String accessToken;
    private final String allDataPermission;
    private final String email;
    private final String jti;
    private final String mobile;
    private final String nickName;
    private final String openId;
    private final String realName;
    private final String refreshToken;
    private final String userId;
    private final String userName;
    
    public YXDLoginResBean(final String realName, final String nickName, final String openId, final String mobile, final String userName, final String userId, final String email, final String allDataPermission, final String jti, final String accessToken, final String refreshToken) {
        //Intrinsics.checkParameterIsNotNull(realName, "realName");
        //Intrinsics.checkParameterIsNotNull(nickName, "nickName");
        //Intrinsics.checkParameterIsNotNull(openId, "openId");
        //Intrinsics.checkParameterIsNotNull(mobile, "mobile");
        //Intrinsics.checkParameterIsNotNull(userName, "userName");
        //Intrinsics.checkParameterIsNotNull(userId, "userId");
        //Intrinsics.checkParameterIsNotNull(email, "email");
        //Intrinsics.checkParameterIsNotNull(allDataPermission, "allDataPermission");
        //Intrinsics.checkParameterIsNotNull(jti, "jti");
        //Intrinsics.checkParameterIsNotNull(accessToken, "accessToken");
        //Intrinsics.checkParameterIsNotNull(refreshToken, "refreshToken");
        this.realName = realName;
        this.nickName = nickName;
        this.openId = openId;
        this.mobile = mobile;
        this.userName = userName;
        this.userId = userId;
        this.email = email;
        this.allDataPermission = allDataPermission;
        this.jti = jti;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
    
    public final String component1() {
        return this.realName;
    }
    
    public final String component10() {
        return this.accessToken;
    }
    
    public final String component11() {
        return this.refreshToken;
    }
    
    public final String component2() {
        return this.nickName;
    }
    
    public final String component3() {
        return this.openId;
    }
    
    public final String component4() {
        return this.mobile;
    }
    
    public final String component5() {
        return this.userName;
    }
    
    public final String component6() {
        return this.userId;
    }
    
    public final String component7() {
        return this.email;
    }
    
    public final String component8() {
        return this.allDataPermission;
    }
    
    public final String component9() {
        return this.jti;
    }
    
    public final YXDLoginResBean copy(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final String s7, final String s8, final String s9, final String s10, final String s11) {
        //Intrinsics.checkParameterIsNotNull(s, "realName");
        //Intrinsics.checkParameterIsNotNull(s2, "nickName");
        //Intrinsics.checkParameterIsNotNull(s3, "openId");
        //Intrinsics.checkParameterIsNotNull(s4, "mobile");
        //Intrinsics.checkParameterIsNotNull(s5, "userName");
        //Intrinsics.checkParameterIsNotNull(s6, "userId");
        //Intrinsics.checkParameterIsNotNull(s7, "email");
        //Intrinsics.checkParameterIsNotNull(s8, "allDataPermission");
        //Intrinsics.checkParameterIsNotNull(s9, "jti");
        //Intrinsics.checkParameterIsNotNull(s10, "accessToken");
        //Intrinsics.checkParameterIsNotNull(s11, "refreshToken");
        return new YXDLoginResBean(s, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof YXDLoginResBean) {
                final YXDLoginResBean yxdLoginResBean = (YXDLoginResBean)o;
                if (Intrinsics.areEqual(this.realName, yxdLoginResBean.realName) && Intrinsics.areEqual(this.nickName, yxdLoginResBean.nickName) && Intrinsics.areEqual(this.openId, yxdLoginResBean.openId) && Intrinsics.areEqual(this.mobile, yxdLoginResBean.mobile) && Intrinsics.areEqual(this.userName, yxdLoginResBean.userName) && Intrinsics.areEqual(this.userId, yxdLoginResBean.userId) && Intrinsics.areEqual(this.email, yxdLoginResBean.email) && Intrinsics.areEqual(this.allDataPermission, yxdLoginResBean.allDataPermission) && Intrinsics.areEqual(this.jti, yxdLoginResBean.jti) && Intrinsics.areEqual(this.accessToken, yxdLoginResBean.accessToken) && Intrinsics.areEqual(this.refreshToken, yxdLoginResBean.refreshToken)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getAccessToken() {
        return this.accessToken;
    }
    
    public final String getAllDataPermission() {
        return this.allDataPermission;
    }
    
    public final String getEmail() {
        return this.email;
    }
    
    public final String getJti() {
        return this.jti;
    }
    
    public final String getMobile() {
        return this.mobile;
    }
    
    public final String getNickName() {
        return this.nickName;
    }
    
    public final String getOpenId() {
        return this.openId;
    }
    
    public final String getRealName() {
        return this.realName;
    }
    
    public final String getRefreshToken() {
        return this.refreshToken;
    }
    
    public final String getUserId() {
        return this.userId;
    }
    
    public final String getUserName() {
        return this.userName;
    }
    
    @Override
    public int hashCode() {
        final String realName = this.realName;
        int hashCode = 0;
        int hashCode2;
        if (realName != null) {
            hashCode2 = realName.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String nickName = this.nickName;
        int hashCode3;
        if (nickName != null) {
            hashCode3 = nickName.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String openId = this.openId;
        int hashCode4;
        if (openId != null) {
            hashCode4 = openId.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String mobile = this.mobile;
        int hashCode5;
        if (mobile != null) {
            hashCode5 = mobile.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String userName = this.userName;
        int hashCode6;
        if (userName != null) {
            hashCode6 = userName.hashCode();
        }
        else {
            hashCode6 = 0;
        }
        final String userId = this.userId;
        int hashCode7;
        if (userId != null) {
            hashCode7 = userId.hashCode();
        }
        else {
            hashCode7 = 0;
        }
        final String email = this.email;
        int hashCode8;
        if (email != null) {
            hashCode8 = email.hashCode();
        }
        else {
            hashCode8 = 0;
        }
        final String allDataPermission = this.allDataPermission;
        int hashCode9;
        if (allDataPermission != null) {
            hashCode9 = allDataPermission.hashCode();
        }
        else {
            hashCode9 = 0;
        }
        final String jti = this.jti;
        int hashCode10;
        if (jti != null) {
            hashCode10 = jti.hashCode();
        }
        else {
            hashCode10 = 0;
        }
        final String accessToken = this.accessToken;
        int hashCode11;
        if (accessToken != null) {
            hashCode11 = accessToken.hashCode();
        }
        else {
            hashCode11 = 0;
        }
        final String refreshToken = this.refreshToken;
        if (refreshToken != null) {
            hashCode = refreshToken.hashCode();
        }
        return (((((((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode8) * 31 + hashCode9) * 31 + hashCode10) * 31 + hashCode11) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("YXDLoginResBean(realName=");
        sb.append(this.realName);
        sb.append(", nickName=");
        sb.append(this.nickName);
        sb.append(", openId=");
        sb.append(this.openId);
        sb.append(", mobile=");
        sb.append(this.mobile);
        sb.append(", userName=");
        sb.append(this.userName);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", email=");
        sb.append(this.email);
        sb.append(", allDataPermission=");
        sb.append(this.allDataPermission);
        sb.append(", jti=");
        sb.append(this.jti);
        sb.append(", accessToken=");
        sb.append(this.accessToken);
        sb.append(", refreshToken=");
        sb.append(this.refreshToken);
        sb.append(")");
        return sb.toString();
    }
}
