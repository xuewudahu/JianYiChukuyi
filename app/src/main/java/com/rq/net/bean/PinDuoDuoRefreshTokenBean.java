package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public final class PinDuoDuoRefreshTokenBean {
    private String token;
    private String userId;

    public PinDuoDuoRefreshTokenBean(String var1, String var2) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "token");
        //Intrinsics.checkParameterIsNotNull(var2, "userId");*/
        super();
        this.token = var1;
        this.userId = var2;
    }

    // $FF: synthetic method
    public static PinDuoDuoRefreshTokenBean copy$default(PinDuoDuoRefreshTokenBean var0, String var1, String var2, int var3, Object var4) {
        if ((var3 & 1) != 0) {
            var1 = var0.token;
        }

        if ((var3 & 2) != 0) {
            var2 = var0.userId;
        }

        return var0.copy(var1, var2);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.userId;
    }

    public final PinDuoDuoRefreshTokenBean copy(String var1, String var2) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "token");
        //Intrinsics.checkParameterIsNotNull(var2, "userId");*/
        return new PinDuoDuoRefreshTokenBean(var1, var2);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (!(var1 instanceof PinDuoDuoRefreshTokenBean)) {
                return false;
            }

            PinDuoDuoRefreshTokenBean var2 = (PinDuoDuoRefreshTokenBean)var1;
            if (!Intrinsics.areEqual(this.token, var2.token) || !Intrinsics.areEqual(this.userId, var2.userId)) {
                return false;
            }
        }

        return true;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String var3 = this.token;
        int var2 = 0;
        int var1;
        if (var3 != null) {
            var1 = var3.hashCode();
        } else {
            var1 = 0;
        }

        var3 = this.userId;
        if (var3 != null) {
            var2 = var3.hashCode();
        }

        return var1 * 31 + var2;
    }

    public final void setToken(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.token = var1;
    }

    public final void setUserId(String var1) {
       // //Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.userId = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("PinDuoDuoRefreshTokenBean(token=");
        var1.append(this.token);
        var1.append(", userId=");
        var1.append(this.userId);
        var1.append(")");
        return var1.toString();
    }
}
