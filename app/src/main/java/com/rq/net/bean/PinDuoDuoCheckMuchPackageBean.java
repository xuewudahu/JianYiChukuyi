package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public class PinDuoDuoCheckMuchPackageBean {
    private long first_in_time;
    private String mobile;
    private String pickup_code;
    private String userId;
    private String waybill_code;
    private String waybill_status_desc;
    private String wp_code;
    private String wp_name;

    public PinDuoDuoCheckMuchPackageBean(String var1, String var2, String var3, String var4, String var5, String var6, long var7, String var9) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "pickup_code");
        //Intrinsics.checkParameterIsNotNull(var2, "waybill_code");
        //Intrinsics.checkParameterIsNotNull(var3, "wp_code");
        //Intrinsics.checkParameterIsNotNull(var4, "wp_name");
        //Intrinsics.checkParameterIsNotNull(var5, "waybill_status_desc");
        //Intrinsics.checkParameterIsNotNull(var6, "mobile");
        //Intrinsics.checkParameterIsNotNull(var9, "userId");*/
        super();
        this.pickup_code = var1;
        this.waybill_code = var2;
        this.wp_code = var3;
        this.wp_name = var4;
        this.waybill_status_desc = var5;
        this.mobile = var6;
        this.first_in_time = var7;
        this.userId = var9;
    }

    // $FF: synthetic method
    public static PinDuoDuoCheckMuchPackageBean copy$default(PinDuoDuoCheckMuchPackageBean var0, String var1, String var2, String var3, String var4, String var5, String var6, long var7, String var9, int var10, Object var11) {
        if ((var10 & 1) != 0) {
            var1 = var0.pickup_code;
        }

        if ((var10 & 2) != 0) {
            var2 = var0.waybill_code;
        }

        if ((var10 & 4) != 0) {
            var3 = var0.wp_code;
        }

        if ((var10 & 8) != 0) {
            var4 = var0.wp_name;
        }

        if ((var10 & 16) != 0) {
            var5 = var0.waybill_status_desc;
        }

        if ((var10 & 32) != 0) {
            var6 = var0.mobile;
        }

        if ((var10 & 64) != 0) {
            var7 = var0.first_in_time;
        }

        if ((var10 & 128) != 0) {
            var9 = var0.userId;
        }

        return var0.copy(var1, var2, var3, var4, var5, var6, var7, var9);
    }

    public final String component1() {
        return this.pickup_code;
    }

    public final String component2() {
        return this.waybill_code;
    }

    public final String component3() {
        return this.wp_code;
    }

    public final String component4() {
        return this.wp_name;
    }

    public final String component5() {
        return this.waybill_status_desc;
    }

    public final String component6() {
        return this.mobile;
    }

    public final long component7() {
        return this.first_in_time;
    }

    public final String component8() {
        return this.userId;
    }

    public final PinDuoDuoCheckMuchPackageBean copy(String var1, String var2, String var3, String var4, String var5, String var6, long var7, String var9) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "pickup_code");
        //Intrinsics.checkParameterIsNotNull(var2, "waybill_code");
        //Intrinsics.checkParameterIsNotNull(var3, "wp_code");
        //Intrinsics.checkParameterIsNotNull(var4, "wp_name");
        //Intrinsics.checkParameterIsNotNull(var5, "waybill_status_desc");
        //Intrinsics.checkParameterIsNotNull(var6, "mobile");
        //Intrinsics.checkParameterIsNotNull(var9, "userId");*/
        return new PinDuoDuoCheckMuchPackageBean(var1, var2, var3, var4, var5, var6, var7, var9);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (!(var1 instanceof PinDuoDuoCheckMuchPackageBean)) {
                return false;
            }

            PinDuoDuoCheckMuchPackageBean var2 = (PinDuoDuoCheckMuchPackageBean)var1;
            if (!Intrinsics.areEqual(this.pickup_code, var2.pickup_code) || !Intrinsics.areEqual(this.waybill_code, var2.waybill_code) || !Intrinsics.areEqual(this.wp_code, var2.wp_code) || !Intrinsics.areEqual(this.wp_name, var2.wp_name) || !Intrinsics.areEqual(this.waybill_status_desc, var2.waybill_status_desc) || !Intrinsics.areEqual(this.mobile, var2.mobile) || this.first_in_time != var2.first_in_time || !Intrinsics.areEqual(this.userId, var2.userId)) {
                return false;
            }
        }

        return true;
    }

    public final long getFirst_in_time() {
        return this.first_in_time;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final String getPickup_code() {
        return this.pickup_code;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getWaybill_code() {
        return this.waybill_code;
    }

    public final String getWaybill_status_desc() {
        return this.waybill_status_desc;
    }

    public final String getWp_code() {
        return this.wp_code;
    }

    public final String getWp_name() {
        return this.wp_name;
    }

    public int hashCode() {
        String var11 = this.pickup_code;
        int var7 = 0;
        int var1;
        if (var11 != null) {
            var1 = var11.hashCode();
        } else {
            var1 = 0;
        }

        var11 = this.waybill_code;
        int var2;
        if (var11 != null) {
            var2 = var11.hashCode();
        } else {
            var2 = 0;
        }

        var11 = this.wp_code;
        int var3;
        if (var11 != null) {
            var3 = var11.hashCode();
        } else {
            var3 = 0;
        }

        var11 = this.wp_name;
        int var4;
        if (var11 != null) {
            var4 = var11.hashCode();
        } else {
            var4 = 0;
        }

        var11 = this.waybill_status_desc;
        int var5;
        if (var11 != null) {
            var5 = var11.hashCode();
        } else {
            var5 = 0;
        }

        var11 = this.mobile;
        int var6;
        if (var11 != null) {
            var6 = var11.hashCode();
        } else {
            var6 = 0;
        }

        long var9 = this.first_in_time;
        int var8 = (int)(var9 ^ var9 >>> 32);
        var11 = this.userId;
        if (var11 != null) {
            var7 = var11.hashCode();
        }

        return ((((((var1 * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var8) * 31 + var7;
    }

    public final void setFirst_in_time(long var1) {
        this.first_in_time = var1;
    }

    public final void setMobile(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.mobile = var1;
    }

    public final void setPickup_code(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.pickup_code = var1;
    }

    public final void setUserId(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.userId = var1;
    }

    public final void setWaybill_code(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.waybill_code = var1;
    }

    public final void setWaybill_status_desc(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.waybill_status_desc = var1;
    }

    public final void setWp_code(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.wp_code = var1;
    }

    public final void setWp_name(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.wp_name = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("PinDuoDuoCheckMuchPackageBean(pickup_code=");
        var1.append(this.pickup_code);
        var1.append(", waybill_code=");
        var1.append(this.waybill_code);
        var1.append(", wp_code=");
        var1.append(this.wp_code);
        var1.append(", wp_name=");
        var1.append(this.wp_name);
        var1.append(", waybill_status_desc=");
        var1.append(this.waybill_status_desc);
        var1.append(", mobile=");
        var1.append(this.mobile);
        var1.append(", first_in_time=");
        var1.append(this.first_in_time);
        var1.append(", userId=");
        var1.append(this.userId);
        var1.append(")");
        return var1.toString();
    }
}

