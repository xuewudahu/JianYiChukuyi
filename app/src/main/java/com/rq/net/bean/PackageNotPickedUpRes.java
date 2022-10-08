package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/PackageNotPickedUpRes;", "", "agentId", "", "recePhone", "company", "pickCode", "state", "ydUserId", "shipId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAgentId", "()Ljava/lang/String;", "getCompany", "getPickCode", "getRecePhone", "getShipId", "getState", "getYdUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class PackageNotPickedUpRes
{
    private final String agentId;
    private final String company;
    private final String pickCode;
    private final String recePhone;
    private final String shipId;
    private final String state;
    private final String ydUserId;
    
    public PackageNotPickedUpRes(final String agentId, final String recePhone, final String company, final String pickCode, final String state, final String ydUserId, final String shipId) {
        //Intrinsics.checkParameterIsNotNull(agentId, "agentId");
        //Intrinsics.checkParameterIsNotNull(recePhone, "recePhone");
        //Intrinsics.checkParameterIsNotNull(company, "company");
        //Intrinsics.checkParameterIsNotNull(pickCode, "pickCode");
        //Intrinsics.checkParameterIsNotNull(state, "state");
        //Intrinsics.checkParameterIsNotNull(ydUserId, "ydUserId");
        //Intrinsics.checkParameterIsNotNull(shipId, "shipId");
        this.agentId = agentId;
        this.recePhone = recePhone;
        this.company = company;
        this.pickCode = pickCode;
        this.state = state;
        this.ydUserId = ydUserId;
        this.shipId = shipId;
    }
    
    public final String component1() {
        return this.agentId;
    }
    
    public final String component2() {
        return this.recePhone;
    }
    
    public final String component3() {
        return this.company;
    }
    
    public final String component4() {
        return this.pickCode;
    }
    
    public final String component5() {
        return this.state;
    }
    
    public final String component6() {
        return this.ydUserId;
    }
    
    public final String component7() {
        return this.shipId;
    }
    
    public final PackageNotPickedUpRes copy(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final String s7) {
        //Intrinsics.checkParameterIsNotNull(s, "agentId");
        //Intrinsics.checkParameterIsNotNull(s2, "recePhone");
        //Intrinsics.checkParameterIsNotNull(s3, "company");
        //Intrinsics.checkParameterIsNotNull(s4, "pickCode");
        //Intrinsics.checkParameterIsNotNull(s5, "state");
        //Intrinsics.checkParameterIsNotNull(s6, "ydUserId");
        //Intrinsics.checkParameterIsNotNull(s7, "shipId");
        return new PackageNotPickedUpRes(s, s2, s3, s4, s5, s6, s7);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PackageNotPickedUpRes) {
                final PackageNotPickedUpRes packageNotPickedUpRes = (PackageNotPickedUpRes)o;
                if (Intrinsics.areEqual(this.agentId, packageNotPickedUpRes.agentId) && Intrinsics.areEqual(this.recePhone, packageNotPickedUpRes.recePhone) && Intrinsics.areEqual(this.company, packageNotPickedUpRes.company) && Intrinsics.areEqual(this.pickCode, packageNotPickedUpRes.pickCode) && Intrinsics.areEqual(this.state, packageNotPickedUpRes.state) && Intrinsics.areEqual(this.ydUserId, packageNotPickedUpRes.ydUserId) && Intrinsics.areEqual(this.shipId, packageNotPickedUpRes.shipId)) {
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
    
    public final String getCompany() {
        return this.company;
    }
    
    public final String getPickCode() {
        return this.pickCode;
    }
    
    public final String getRecePhone() {
        return this.recePhone;
    }
    
    public final String getShipId() {
        return this.shipId;
    }
    
    public final String getState() {
        return this.state;
    }
    
    public final String getYdUserId() {
        return this.ydUserId;
    }
    
    @Override
    public int hashCode() {
        final String agentId = this.agentId;
        int hashCode = 0;
        int hashCode2;
        if (agentId != null) {
            hashCode2 = agentId.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String recePhone = this.recePhone;
        int hashCode3;
        if (recePhone != null) {
            hashCode3 = recePhone.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String company = this.company;
        int hashCode4;
        if (company != null) {
            hashCode4 = company.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String pickCode = this.pickCode;
        int hashCode5;
        if (pickCode != null) {
            hashCode5 = pickCode.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String state = this.state;
        int hashCode6;
        if (state != null) {
            hashCode6 = state.hashCode();
        }
        else {
            hashCode6 = 0;
        }
        final String ydUserId = this.ydUserId;
        int hashCode7;
        if (ydUserId != null) {
            hashCode7 = ydUserId.hashCode();
        }
        else {
            hashCode7 = 0;
        }
        final String shipId = this.shipId;
        if (shipId != null) {
            hashCode = shipId.hashCode();
        }
        return (((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PackageNotPickedUpRes(agentId=");
        sb.append(this.agentId);
        sb.append(", recePhone=");
        sb.append(this.recePhone);
        sb.append(", company=");
        sb.append(this.company);
        sb.append(", pickCode=");
        sb.append(this.pickCode);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", ydUserId=");
        sb.append(this.ydUserId);
        sb.append(", shipId=");
        sb.append(this.shipId);
        sb.append(")");
        return sb.toString();
    }
}
