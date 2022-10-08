package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public class PinDuoDuoOutLibraryRequestBean {
    private String device;
    private String waybill_code;

    public PinDuoDuoOutLibraryRequestBean(String var1, String var2) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "device");
        //Intrinsics.checkParameterIsNotNull(var2, "waybill_code");*/
        super();
        this.device = var1;
        this.waybill_code = var2;
    }

    // $FF: synthetic method
    public static PinDuoDuoOutLibraryRequestBean copy$default(PinDuoDuoOutLibraryRequestBean var0, String var1, String var2, int var3, Object var4) {
        if ((var3 & 1) != 0) {
            var1 = var0.device;
        }

        if ((var3 & 2) != 0) {
            var2 = var0.waybill_code;
        }

        return var0.copy(var1, var2);
    }

    public final String component1() {
        return this.device;
    }

    public final String component2() {
        return this.waybill_code;
    }

    public final PinDuoDuoOutLibraryRequestBean copy(String var1, String var2) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "device");
        //Intrinsics.checkParameterIsNotNull(var2, "waybill_code");*/
        return new PinDuoDuoOutLibraryRequestBean(var1, var2);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (!(var1 instanceof PinDuoDuoOutLibraryRequestBean)) {
                return false;
            }

            PinDuoDuoOutLibraryRequestBean var2 = (PinDuoDuoOutLibraryRequestBean)var1;
            if (!Intrinsics.areEqual(this.device, var2.device) || !Intrinsics.areEqual(this.waybill_code, var2.waybill_code)) {
                return false;
            }
        }

        return true;
    }

    public final String getDevice() {
        return this.device;
    }

    public final String getWaybill_code() {
        return this.waybill_code;
    }

    public int hashCode() {
        String var3 = this.device;
        int var2 = 0;
        int var1;
        if (var3 != null) {
            var1 = var3.hashCode();
        } else {
            var1 = 0;
        }

        var3 = this.waybill_code;
        if (var3 != null) {
            var2 = var3.hashCode();
        }

        return var1 * 31 + var2;
    }

    public final void setDevice(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.device = var1;
    }

    public final void setWaybill_code(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.waybill_code = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("PinDuoDuoOutLibraryRequestBean(device=");
        var1.append(this.device);
        var1.append(", waybill_code=");
        var1.append(this.waybill_code);
        var1.append(")");
        return var1.toString();
    }
}
