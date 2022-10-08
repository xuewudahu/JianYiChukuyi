package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public final class MiaoZhanLoginBean
{
    private String brand;
    private String checkCode;
    private String deviceNo;
    private String secret;
    private String stationId;
    
    public MiaoZhanLoginBean(final String stationId, final String deviceNo, final String checkCode, final String brand, final String secret) {
        this.stationId = stationId;
        this.deviceNo = deviceNo;
        this.checkCode = checkCode;
        this.brand = brand;
        this.secret = secret;
    }
    
    public final String component1() {
        return this.stationId;
    }
    
    public final String component2() {
        return this.deviceNo;
    }
    
    public final String component3() {
        return this.checkCode;
    }
    
    public final String component4() {
        return this.brand;
    }
    
    public final String component5() {
        return this.secret;
    }
    
    public final MiaoZhanLoginBean copy(final String s, final String s2, final String s3, final String s4, final String s5) {
        return new MiaoZhanLoginBean(s, s2, s3, s4, s5);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof MiaoZhanLoginBean) {
                final MiaoZhanLoginBean miaoZhanLoginBean = (MiaoZhanLoginBean)o;
                if (Intrinsics.areEqual(this.stationId, miaoZhanLoginBean.stationId) && Intrinsics.areEqual(this.deviceNo, miaoZhanLoginBean.deviceNo) && Intrinsics.areEqual(this.checkCode, miaoZhanLoginBean.checkCode) && Intrinsics.areEqual(this.brand, miaoZhanLoginBean.brand) && Intrinsics.areEqual(this.secret, miaoZhanLoginBean.secret)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getBrand() {
        return this.brand;
    }
    
    public final String getCheckCode() {
        return this.checkCode;
    }
    
    public final String getDeviceNo() {
        return this.deviceNo;
    }
    
    public final String getSecret() {
        return this.secret;
    }
    
    public final String getStationId() {
        return this.stationId;
    }
    
    @Override
    public int hashCode() {
        final String stationId = this.stationId;
        int hashCode = 0;
        int hashCode2;
        if (stationId != null) {
            hashCode2 = stationId.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String deviceNo = this.deviceNo;
        int hashCode3;
        if (deviceNo != null) {
            hashCode3 = deviceNo.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String checkCode = this.checkCode;
        int hashCode4;
        if (checkCode != null) {
            hashCode4 = checkCode.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String brand = this.brand;
        int hashCode5;
        if (brand != null) {
            hashCode5 = brand.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String secret = this.secret;
        if (secret != null) {
            hashCode = secret.hashCode();
        }
        return (((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode;
    }
    
    public final void setBrand(final String brand) {
        this.brand = brand;
    }
    
    public final void setCheckCode(final String checkCode) {
        this.checkCode = checkCode;
    }
    
    public final void setDeviceNo(final String deviceNo) {
        this.deviceNo = deviceNo;
    }
    
    public final void setSecret(final String secret) {
        this.secret = secret;
    }
    
    public final void setStationId(final String stationId) {
        this.stationId = stationId;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MiaoZhanLoginBean(stationId=");
        sb.append(this.stationId);
        sb.append(", deviceNo=");
        sb.append(this.deviceNo);
        sb.append(", checkCode=");
        sb.append(this.checkCode);
        sb.append(", brand=");
        sb.append(this.brand);
        sb.append(", secret=");
        sb.append(this.secret);
        sb.append(")");
        return sb.toString();
    }
}
