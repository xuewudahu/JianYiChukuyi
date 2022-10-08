package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/YunDaChaoShiLoginResponseBean;", "", "branchId", "", "agentName", "agentPerson", "phone", "agentPhone", "branchName", "agentId", "userId", "username", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAgentId", "()Ljava/lang/String;", "getAgentName", "getAgentPerson", "getAgentPhone", "getBranchId", "getBranchName", "getPhone", "getUserId", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class YunDaChaoShiLoginResponseBean
{
    private final String agentId;
    private final String agentName;
    private final String agentPerson;
    private final String agentPhone;
    private final String branchId;
    private final String branchName;
    private final String phone;
    private final String userId;
    private final String username;
    
    public YunDaChaoShiLoginResponseBean(final String branchId, final String agentName, final String agentPerson, final String phone, final String agentPhone, final String branchName, final String agentId, final String userId, final String username) {
        //Intrinsics.checkParameterIsNotNull(branchId, "branchId");
        //Intrinsics.checkParameterIsNotNull(agentName, "agentName");
        //Intrinsics.checkParameterIsNotNull(agentPerson, "agentPerson");
        //Intrinsics.checkParameterIsNotNull(phone, "phone");
        //Intrinsics.checkParameterIsNotNull(agentPhone, "agentPhone");
        //Intrinsics.checkParameterIsNotNull(branchName, "branchName");
        //Intrinsics.checkParameterIsNotNull(agentId, "agentId");
        //Intrinsics.checkParameterIsNotNull(userId, "userId");
        //Intrinsics.checkParameterIsNotNull(username, "username");
        this.branchId = branchId;
        this.agentName = agentName;
        this.agentPerson = agentPerson;
        this.phone = phone;
        this.agentPhone = agentPhone;
        this.branchName = branchName;
        this.agentId = agentId;
        this.userId = userId;
        this.username = username;
    }
    
    public final String component1() {
        return this.branchId;
    }
    
    public final String component2() {
        return this.agentName;
    }
    
    public final String component3() {
        return this.agentPerson;
    }
    
    public final String component4() {
        return this.phone;
    }
    
    public final String component5() {
        return this.agentPhone;
    }
    
    public final String component6() {
        return this.branchName;
    }
    
    public final String component7() {
        return this.agentId;
    }
    
    public final String component8() {
        return this.userId;
    }
    
    public final String component9() {
        return this.username;
    }
    
    public final YunDaChaoShiLoginResponseBean copy(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final String s7, final String s8, final String s9) {
        //Intrinsics.checkParameterIsNotNull(s, "branchId");
        //Intrinsics.checkParameterIsNotNull(s2, "agentName");
        //Intrinsics.checkParameterIsNotNull(s3, "agentPerson");
        //Intrinsics.checkParameterIsNotNull(s4, "phone");
        //Intrinsics.checkParameterIsNotNull(s5, "agentPhone");
        //Intrinsics.checkParameterIsNotNull(s6, "branchName");
        //Intrinsics.checkParameterIsNotNull(s7, "agentId");
        //Intrinsics.checkParameterIsNotNull(s8, "userId");
        //Intrinsics.checkParameterIsNotNull(s9, "username");
        return new YunDaChaoShiLoginResponseBean(s, s2, s3, s4, s5, s6, s7, s8, s9);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof YunDaChaoShiLoginResponseBean) {
                final YunDaChaoShiLoginResponseBean yunDaChaoShiLoginResponseBean = (YunDaChaoShiLoginResponseBean)o;
                if (Intrinsics.areEqual(this.branchId, yunDaChaoShiLoginResponseBean.branchId) && Intrinsics.areEqual(this.agentName, yunDaChaoShiLoginResponseBean.agentName) && Intrinsics.areEqual(this.agentPerson, yunDaChaoShiLoginResponseBean.agentPerson) && Intrinsics.areEqual(this.phone, yunDaChaoShiLoginResponseBean.phone) && Intrinsics.areEqual(this.agentPhone, yunDaChaoShiLoginResponseBean.agentPhone) && Intrinsics.areEqual(this.branchName, yunDaChaoShiLoginResponseBean.branchName) && Intrinsics.areEqual(this.agentId, yunDaChaoShiLoginResponseBean.agentId) && Intrinsics.areEqual(this.userId, yunDaChaoShiLoginResponseBean.userId) && Intrinsics.areEqual(this.username, yunDaChaoShiLoginResponseBean.username)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getAgentId() {
        return this.agentId;
    }
    
    public final String getAgentName() {
        return this.agentName;
    }
    
    public final String getAgentPerson() {
        return this.agentPerson;
    }
    
    public final String getAgentPhone() {
        return this.agentPhone;
    }
    
    public final String getBranchId() {
        return this.branchId;
    }
    
    public final String getBranchName() {
        return this.branchName;
    }
    
    public final String getPhone() {
        return this.phone;
    }
    
    public final String getUserId() {
        return this.userId;
    }
    
    public final String getUsername() {
        return this.username;
    }
    
    @Override
    public int hashCode() {
        final String branchId = this.branchId;
        int hashCode = 0;
        int hashCode2;
        if (branchId != null) {
            hashCode2 = branchId.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String agentName = this.agentName;
        int hashCode3;
        if (agentName != null) {
            hashCode3 = agentName.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String agentPerson = this.agentPerson;
        int hashCode4;
        if (agentPerson != null) {
            hashCode4 = agentPerson.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String phone = this.phone;
        int hashCode5;
        if (phone != null) {
            hashCode5 = phone.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String agentPhone = this.agentPhone;
        int hashCode6;
        if (agentPhone != null) {
            hashCode6 = agentPhone.hashCode();
        }
        else {
            hashCode6 = 0;
        }
        final String branchName = this.branchName;
        int hashCode7;
        if (branchName != null) {
            hashCode7 = branchName.hashCode();
        }
        else {
            hashCode7 = 0;
        }
        final String agentId = this.agentId;
        int hashCode8;
        if (agentId != null) {
            hashCode8 = agentId.hashCode();
        }
        else {
            hashCode8 = 0;
        }
        final String userId = this.userId;
        int hashCode9;
        if (userId != null) {
            hashCode9 = userId.hashCode();
        }
        else {
            hashCode9 = 0;
        }
        final String username = this.username;
        if (username != null) {
            hashCode = username.hashCode();
        }
        return (((((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode8) * 31 + hashCode9) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("YunDaChaoShiLoginResponseBean(branchId=");
        sb.append(this.branchId);
        sb.append(", agentName=");
        sb.append(this.agentName);
        sb.append(", agentPerson=");
        sb.append(this.agentPerson);
        sb.append(", phone=");
        sb.append(this.phone);
        sb.append(", agentPhone=");
        sb.append(this.agentPhone);
        sb.append(", branchName=");
        sb.append(this.branchName);
        sb.append(", agentId=");
        sb.append(this.agentId);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", username=");
        sb.append(this.username);
        sb.append(")");
        return sb.toString();
    }
}
