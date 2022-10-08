package com.rq.net.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.rq.net.util.Intrinsics;

public final class MiaoZhanLogin {
    private final String checkCode;
    private final String deviceNo;
    private final String stationId;

    public MiaoZhanLogin( String var1, String var2, String var3) {

        this.stationId = var1;
        this.deviceNo = var2;
        this.checkCode = var3;
    }

    // $FF: synthetic method
    public static MiaoZhanLogin copy$default(MiaoZhanLogin var0, String var1, String var2, String var3, int var4, Object var5) {
        if ((var4 & 1) != 0) {
            var1 = var0.stationId;
        }

        if ((var4 & 2) != 0) {
            var2 = var0.deviceNo;
        }

        if ((var4 & 4) != 0) {
            var3 = var0.checkCode;
        }

        return var0.copy(var1, var2, var3);
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

    public final MiaoZhanLogin copy( String var1,  String var2,  String var3) {

        return new MiaoZhanLogin(var1, var2, var3);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (!(var1 instanceof MiaoZhanLogin)) {
                return false;
            }

            MiaoZhanLogin var2 = (MiaoZhanLogin)var1;
            if (!Intrinsics.areEqual(this.stationId, var2.stationId) || !Intrinsics.areEqual(this.deviceNo, var2.deviceNo) || !Intrinsics.areEqual(this.checkCode, var2.checkCode)) {
                return false;
            }
        }

        return true;
    }

    public final String getCheckCode() {
        return this.checkCode;
    }

    public final String getDeviceNo() {
        return this.deviceNo;
    }

    public final String getStationId() {
        return this.stationId;
    }

    public int hashCode() {
        String var4 = this.stationId;
        int var3 = 0;
        int var1;
        if (var4 != null) {
            var1 = var4.hashCode();
        } else {
            var1 = 0;
        }

        var4 = this.deviceNo;
        int var2;
        if (var4 != null) {
            var2 = var4.hashCode();
        } else {
            var2 = 0;
        }

        var4 = this.checkCode;
        if (var4 != null) {
            var3 = var4.hashCode();
        }

        return (var1 * 31 + var2) * 31 + var3;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("MiaoZhanLogin(stationId=");
        var1.append(this.stationId);
        var1.append(", deviceNo=");
        var1.append(this.deviceNo);
        var1.append(", checkCode=");
        var1.append(this.checkCode);
        var1.append(")");
        return var1.toString();
    }
}