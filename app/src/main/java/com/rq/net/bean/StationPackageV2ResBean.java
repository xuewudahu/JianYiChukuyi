package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

import java.util.*;

public final class StationPackageV2ResBean
{
    private final PackageInfoBean package_info;
    private final List<StationInfoBean> station_info;
    
    public StationPackageV2ResBean(final List<StationInfoBean> station_info, final PackageInfoBean package_info) {
        this.station_info = station_info;
        this.package_info = package_info;
    }
    
    public final List<StationInfoBean> component1() {
        return this.station_info;
    }
    
    public final PackageInfoBean component2() {
        return this.package_info;
    }
    
    public final StationPackageV2ResBean copy(final List<StationInfoBean> list, final PackageInfoBean packageInfoBean) {
        return new StationPackageV2ResBean(list, packageInfoBean);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof StationPackageV2ResBean) {
                final StationPackageV2ResBean stationPackageV2ResBean = (StationPackageV2ResBean)o;
                if (Intrinsics.areEqual(this.station_info, stationPackageV2ResBean.station_info) && Intrinsics.areEqual(this.package_info, stationPackageV2ResBean.package_info)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final PackageInfoBean getPackage_info() {
        return this.package_info;
    }
    
    public final List<StationInfoBean> getStation_info() {
        return this.station_info;
    }
    
    @Override
    public int hashCode() {
        final List<StationInfoBean> station_info = this.station_info;
        int hashCode = 0;
        int hashCode2;
        if (station_info != null) {
            hashCode2 = station_info.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final PackageInfoBean package_info = this.package_info;
        if (package_info != null) {
            hashCode = package_info.hashCode();
        }
        return hashCode2 * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("StationPackageV2ResBean(station_info=");
        sb.append(this.station_info);
        sb.append(", package_info=");
        sb.append(this.package_info);
        sb.append(")");
        return sb.toString();
    }
}
