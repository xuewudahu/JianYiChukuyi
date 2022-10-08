package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/AgentInfo;", "", "accountPhone", "", "agentId", "userId", "source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountPhone", "()Ljava/lang/String;", "getAgentId", "getSource", "getUserId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class AgentInfo
{
    private final String accountPhone;
    private final String agentId;
    private final String source;
    private final String userId;
    
    public AgentInfo(final String accountPhone, final String agentId, final String userId, final String source) {
        //Intrinsics.checkParameterIsNotNull(accountPhone, "accountPhone");
        //Intrinsics.checkParameterIsNotNull(agentId, "agentId");
        //Intrinsics.checkParameterIsNotNull(userId, "userId");
        //Intrinsics.checkParameterIsNotNull(source, "source");
        this.accountPhone = accountPhone;
        this.agentId = agentId;
        this.userId = userId;
        this.source = source;
    }
    
    public final String component1() {
        return this.accountPhone;
    }
    
    public final String component2() {
        return this.agentId;
    }
    
    public final String component3() {
        return this.userId;
    }
    
    public final String component4() {
        return this.source;
    }
    
    public final AgentInfo copy(final String s, final String s2, final String s3, final String s4) {
        //Intrinsics.checkParameterIsNotNull(s, "accountPhone");
        //Intrinsics.checkParameterIsNotNull(s2, "agentId");
        //Intrinsics.checkParameterIsNotNull(s3, "userId");
        //Intrinsics.checkParameterIsNotNull(s4, "source");
        return new AgentInfo(s, s2, s3, s4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof AgentInfo) {
                final AgentInfo agentInfo = (AgentInfo)o;
                if (Intrinsics.areEqual(this.accountPhone, agentInfo.accountPhone) && Intrinsics.areEqual(this.agentId, agentInfo.agentId) && Intrinsics.areEqual(this.userId, agentInfo.userId) && Intrinsics.areEqual(this.source, agentInfo.source)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getAccountPhone() {
        return this.accountPhone;
    }
    
    public final String getAgentId() {
        return this.agentId;
    }
    
    public final String getSource() {
        return this.source;
    }
    
    public final String getUserId() {
        return this.userId;
    }
    
    @Override
    public int hashCode() {
        final String accountPhone = this.accountPhone;
        int hashCode = 0;
        int hashCode2;
        if (accountPhone != null) {
            hashCode2 = accountPhone.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String agentId = this.agentId;
        int hashCode3;
        if (agentId != null) {
            hashCode3 = agentId.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String userId = this.userId;
        int hashCode4;
        if (userId != null) {
            hashCode4 = userId.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String source = this.source;
        if (source != null) {
            hashCode = source.hashCode();
        }
        return ((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AgentInfo(accountPhone=");
        sb.append(this.accountPhone);
        sb.append(", agentId=");
        sb.append(this.agentId);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", source=");
        sb.append(this.source);
        sb.append(")");
        return sb.toString();
    }
}
