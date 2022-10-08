package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/YshouFaLoginRequestBean;", "", "password", "", "userName", "userType", "channel", "uuid", "wxAuthorizationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", "getPassword", "setPassword", "getUserName", "setUserName", "getUserType", "setUserType", "getUuid", "setUuid", "getWxAuthorizationId", "setWxAuthorizationId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class YshouFaLoginRequestBean
{
    private String channel;
    private String password;
    private String userName;
    private String userType;
    private String uuid;
    private String wxAuthorizationId;
    
    public YshouFaLoginRequestBean(final String password, final String userName, final String userType, final String channel, final String uuid, final String wxAuthorizationId) {
        //Intrinsics.checkParameterIsNotNull(password, "password");
        //Intrinsics.checkParameterIsNotNull(userName, "userName");
        //Intrinsics.checkParameterIsNotNull(userType, "userType");
        //Intrinsics.checkParameterIsNotNull(channel, "channel");
        //Intrinsics.checkParameterIsNotNull(uuid, "uuid");
        //Intrinsics.checkParameterIsNotNull(wxAuthorizationId, "wxAuthorizationId");
        this.password = password;
        this.userName = userName;
        this.userType = userType;
        this.channel = channel;
        this.uuid = uuid;
        this.wxAuthorizationId = wxAuthorizationId;
    }
    
    public final String component1() {
        return this.password;
    }
    
    public final String component2() {
        return this.userName;
    }
    
    public final String component3() {
        return this.userType;
    }
    
    public final String component4() {
        return this.channel;
    }
    
    public final String component5() {
        return this.uuid;
    }
    
    public final String component6() {
        return this.wxAuthorizationId;
    }
    
    public final YshouFaLoginRequestBean copy(final String s, final String s2, final String s3, final String s4, final String s5, final String s6) {
        //Intrinsics.checkParameterIsNotNull(s, "password");
        //Intrinsics.checkParameterIsNotNull(s2, "userName");
        //Intrinsics.checkParameterIsNotNull(s3, "userType");
        //Intrinsics.checkParameterIsNotNull(s4, "channel");
        //Intrinsics.checkParameterIsNotNull(s5, "uuid");
        //Intrinsics.checkParameterIsNotNull(s6, "wxAuthorizationId");
        return new YshouFaLoginRequestBean(s, s2, s3, s4, s5, s6);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof YshouFaLoginRequestBean) {
                final YshouFaLoginRequestBean yshouFaLoginRequestBean = (YshouFaLoginRequestBean)o;
                if (Intrinsics.areEqual(this.password, yshouFaLoginRequestBean.password) && Intrinsics.areEqual(this.userName, yshouFaLoginRequestBean.userName) && Intrinsics.areEqual(this.userType, yshouFaLoginRequestBean.userType) && Intrinsics.areEqual(this.channel, yshouFaLoginRequestBean.channel) && Intrinsics.areEqual(this.uuid, yshouFaLoginRequestBean.uuid) && Intrinsics.areEqual(this.wxAuthorizationId, yshouFaLoginRequestBean.wxAuthorizationId)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getChannel() {
        return this.channel;
    }
    
    public final String getPassword() {
        return this.password;
    }
    
    public final String getUserName() {
        return this.userName;
    }
    
    public final String getUserType() {
        return this.userType;
    }
    
    public final String getUuid() {
        return this.uuid;
    }
    
    public final String getWxAuthorizationId() {
        return this.wxAuthorizationId;
    }
    
    @Override
    public int hashCode() {
        final String password = this.password;
        int hashCode = 0;
        int hashCode2;
        if (password != null) {
            hashCode2 = password.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String userName = this.userName;
        int hashCode3;
        if (userName != null) {
            hashCode3 = userName.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String userType = this.userType;
        int hashCode4;
        if (userType != null) {
            hashCode4 = userType.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String channel = this.channel;
        int hashCode5;
        if (channel != null) {
            hashCode5 = channel.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String uuid = this.uuid;
        int hashCode6;
        if (uuid != null) {
            hashCode6 = uuid.hashCode();
        }
        else {
            hashCode6 = 0;
        }
        final String wxAuthorizationId = this.wxAuthorizationId;
        if (wxAuthorizationId != null) {
            hashCode = wxAuthorizationId.hashCode();
        }
        return ((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode;
    }
    
    public final void setChannel(final String channel) {
        //Intrinsics.checkParameterIsNotNull(channel, "<set-?>");
        this.channel = channel;
    }
    
    public final void setPassword(final String password) {
        //Intrinsics.checkParameterIsNotNull(password, "<set-?>");
        this.password = password;
    }
    
    public final void setUserName(final String userName) {
        //Intrinsics.checkParameterIsNotNull(userName, "<set-?>");
        this.userName = userName;
    }
    
    public final void setUserType(final String userType) {
        //Intrinsics.checkParameterIsNotNull(userType, "<set-?>");
        this.userType = userType;
    }
    
    public final void setUuid(final String uuid) {
        //Intrinsics.checkParameterIsNotNull(uuid, "<set-?>");
        this.uuid = uuid;
    }
    
    public final void setWxAuthorizationId(final String wxAuthorizationId) {
        //Intrinsics.checkParameterIsNotNull(wxAuthorizationId, "<set-?>");
        this.wxAuthorizationId = wxAuthorizationId;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("YshouFaLoginRequestBean(password=");
        sb.append(this.password);
        sb.append(", userName=");
        sb.append(this.userName);
        sb.append(", userType=");
        sb.append(this.userType);
        sb.append(", channel=");
        sb.append(this.channel);
        sb.append(", uuid=");
        sb.append(this.uuid);
        sb.append(", wxAuthorizationId=");
        sb.append(this.wxAuthorizationId);
        sb.append(")");
        return sb.toString();
    }
}
