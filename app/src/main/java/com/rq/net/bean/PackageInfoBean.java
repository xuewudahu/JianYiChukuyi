package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public final class PackageInfoBean
{
    private final String commission;
    private final String free_cycle;
    private final String free_station_num;
    private final String frequency;
    private final Double station_price;
    
    public PackageInfoBean(final Double station_price, final String free_station_num, final String free_cycle, final String frequency, final String commission) {
        this.station_price = station_price;
        this.free_station_num = free_station_num;
        this.free_cycle = free_cycle;
        this.frequency = frequency;
        this.commission = commission;
    }
    
    public final Double component1() {
        return this.station_price;
    }
    
    public final String component2() {
        return this.free_station_num;
    }
    
    public final String component3() {
        return this.free_cycle;
    }
    
    public final String component4() {
        return this.frequency;
    }
    
    public final String component5() {
        return this.commission;
    }
    
    public final PackageInfoBean copy(final Double n, final String s, final String s2, final String s3, final String s4) {
        return new PackageInfoBean(n, s, s2, s3, s4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PackageInfoBean) {
                final PackageInfoBean packageInfoBean = (PackageInfoBean)o;
                if (Intrinsics.areEqual(this.station_price, (Object)packageInfoBean.station_price) && Intrinsics.areEqual(this.free_station_num, packageInfoBean.free_station_num) && Intrinsics.areEqual(this.free_cycle, packageInfoBean.free_cycle) && Intrinsics.areEqual(this.frequency, packageInfoBean.frequency) && Intrinsics.areEqual(this.commission, packageInfoBean.commission)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getCommission() {
        return this.commission;
    }
    
    public final String getFree_cycle() {
        return this.free_cycle;
    }
    
    public final String getFree_station_num() {
        return this.free_station_num;
    }
    
    public final String getFrequency() {
        return this.frequency;
    }
    
    public final Double getStation_price() {
        return this.station_price;
    }
    
    @Override
    public int hashCode() {
        final Double station_price = this.station_price;
        int hashCode = 0;
        int hashCode2;
        if (station_price != null) {
            hashCode2 = station_price.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String free_station_num = this.free_station_num;
        int hashCode3;
        if (free_station_num != null) {
            hashCode3 = free_station_num.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String free_cycle = this.free_cycle;
        int hashCode4;
        if (free_cycle != null) {
            hashCode4 = free_cycle.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String frequency = this.frequency;
        int hashCode5;
        if (frequency != null) {
            hashCode5 = frequency.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String commission = this.commission;
        if (commission != null) {
            hashCode = commission.hashCode();
        }
        return (((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PackageInfoBean(station_price=");
        sb.append(this.station_price);
        sb.append(", free_station_num=");
        sb.append(this.free_station_num);
        sb.append(", free_cycle=");
        sb.append(this.free_cycle);
        sb.append(", frequency=");
        sb.append(this.frequency);
        sb.append(", commission=");
        sb.append(this.commission);
        sb.append(")");
        return sb.toString();
    }
}
