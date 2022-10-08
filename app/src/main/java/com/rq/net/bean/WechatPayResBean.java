package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public final class WechatPayResBean
{
    private String code_url;
    private String prepayid;
    private String trade_type;
    
    public WechatPayResBean(final String trade_type, final String prepayid, final String code_url) {
        //Intrinsics.checkParameterIsNotNull(trade_type, "trade_type");
        //Intrinsics.checkParameterIsNotNull(prepayid, "prepayid");
        //Intrinsics.checkParameterIsNotNull(code_url, "code_url");
        this.trade_type = trade_type;
        this.prepayid = prepayid;
        this.code_url = code_url;
    }
    
    public final String component1() {
        return this.trade_type;
    }
    
    public final String component2() {
        return this.prepayid;
    }
    
    public final String component3() {
        return this.code_url;
    }
    
    public final WechatPayResBean copy(final String s, final String s2, final String s3) {
        //Intrinsics.checkParameterIsNotNull(s, "trade_type");
        //Intrinsics.checkParameterIsNotNull(s2, "prepayid");
        //Intrinsics.checkParameterIsNotNull(s3, "code_url");
        return new WechatPayResBean(s, s2, s3);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof WechatPayResBean) {
                final WechatPayResBean wechatPayResBean = (WechatPayResBean)o;
                if (Intrinsics.areEqual(this.trade_type, wechatPayResBean.trade_type) && Intrinsics.areEqual(this.prepayid, wechatPayResBean.prepayid) && Intrinsics.areEqual(this.code_url, wechatPayResBean.code_url)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getCode_url() {
        return this.code_url;
    }
    
    public final String getPrepayid() {
        return this.prepayid;
    }
    
    public final String getTrade_type() {
        return this.trade_type;
    }
    
    @Override
    public int hashCode() {
        final String trade_type = this.trade_type;
        int hashCode = 0;
        int hashCode2;
        if (trade_type != null) {
            hashCode2 = trade_type.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String prepayid = this.prepayid;
        int hashCode3;
        if (prepayid != null) {
            hashCode3 = prepayid.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String code_url = this.code_url;
        if (code_url != null) {
            hashCode = code_url.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    public final void setCode_url(final String code_url) {
        //Intrinsics.checkParameterIsNotNull(code_url, "<set-?>");
        this.code_url = code_url;
    }
    
    public final void setPrepayid(final String prepayid) {
        //Intrinsics.checkParameterIsNotNull(prepayid, "<set-?>");
        this.prepayid = prepayid;
    }
    
    public final void setTrade_type(final String trade_type) {
        //Intrinsics.checkParameterIsNotNull(trade_type, "<set-?>");
        this.trade_type = trade_type;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WechatPayResBean(trade_type=");
        sb.append(this.trade_type);
        sb.append(", prepayid=");
        sb.append(this.prepayid);
        sb.append(", code_url=");
        sb.append(this.code_url);
        sb.append(")");
        return sb.toString();
    }
}
