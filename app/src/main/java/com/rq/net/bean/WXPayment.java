package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public final class WXPayment
{
    private final String appid;
    private final String code_url;
    private final String partnerid;
    private final String prepayid;
    
    public WXPayment(final String appid, final String partnerid, final String prepayid, final String code_url) {
        //Intrinsics.checkParameterIsNotNull(appid, "appid");
        //Intrinsics.checkParameterIsNotNull(partnerid, "partnerid");
        //Intrinsics.checkParameterIsNotNull(prepayid, "prepayid");
        //Intrinsics.checkParameterIsNotNull(code_url, "code_url");
        this.appid = appid;
        this.partnerid = partnerid;
        this.prepayid = prepayid;
        this.code_url = code_url;
    }
    
    public final String component1() {
        return this.appid;
    }
    
    public final String component2() {
        return this.partnerid;
    }
    
    public final String component3() {
        return this.prepayid;
    }
    
    public final String component4() {
        return this.code_url;
    }
    
    public final WXPayment copy(final String s, final String s2, final String s3, final String s4) {
        //Intrinsics.checkParameterIsNotNull(s, "appid");
        //Intrinsics.checkParameterIsNotNull(s2, "partnerid");
        //Intrinsics.checkParameterIsNotNull(s3, "prepayid");
        //Intrinsics.checkParameterIsNotNull(s4, "code_url");
        return new WXPayment(s, s2, s3, s4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof WXPayment) {
                final WXPayment wxPayment = (WXPayment)o;
                if (Intrinsics.areEqual(this.appid, wxPayment.appid) && Intrinsics.areEqual(this.partnerid, wxPayment.partnerid) && Intrinsics.areEqual(this.prepayid, wxPayment.prepayid) && Intrinsics.areEqual(this.code_url, wxPayment.code_url)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getAppid() {
        return this.appid;
    }
    
    public final String getCode_url() {
        return this.code_url;
    }
    
    public final String getPartnerid() {
        return this.partnerid;
    }
    
    public final String getPrepayid() {
        return this.prepayid;
    }
    
    @Override
    public int hashCode() {
        final String appid = this.appid;
        int hashCode = 0;
        int hashCode2;
        if (appid != null) {
            hashCode2 = appid.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String partnerid = this.partnerid;
        int hashCode3;
        if (partnerid != null) {
            hashCode3 = partnerid.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String prepayid = this.prepayid;
        int hashCode4;
        if (prepayid != null) {
            hashCode4 = prepayid.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String code_url = this.code_url;
        if (code_url != null) {
            hashCode = code_url.hashCode();
        }
        return ((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WXPayment(appid=");
        sb.append(this.appid);
        sb.append(", partnerid=");
        sb.append(this.partnerid);
        sb.append(", prepayid=");
        sb.append(this.prepayid);
        sb.append(", code_url=");
        sb.append(this.code_url);
        sb.append(")");
        return sb.toString();
    }
}
