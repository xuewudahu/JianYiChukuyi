package com.rq.net.bean;

public class PinDuoDuoLoginRequestBean {
    private String appIndex;
    private String encryptedPassword;
    private String mobile;

    public PinDuoDuoLoginRequestBean(String var1, String var2, String var3) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "appIndex");
        //Intrinsics.checkParameterIsNotNull(var2, "encryptedPassword");
        //Intrinsics.checkParameterIsNotNull(var3, "mobile");*/
        super();
        init(var1, var2, var3);
    }

    // $FF: synthetic method
    public PinDuoDuoLoginRequestBean(String var1, String var2, String var3, int var4/*, DefaultConstructorMarker var5*/) {
        if ((var4 & 1) != 0) {
            var1 = "2";
        }

        init(var1, var2, var3);
    }

    private void init(String var1, String var2, String var3) {
        this.appIndex = var1;
        this.encryptedPassword = var2;
        this.mobile = var3;
    }
    // $FF: synthetic method
    public static PinDuoDuoLoginRequestBean copy$default(PinDuoDuoLoginRequestBean var0, String var1, String var2, String var3, int var4, Object var5) {
        if ((var4 & 1) != 0) {
            var1 = var0.appIndex;
        }

        if ((var4 & 2) != 0) {
            var2 = var0.encryptedPassword;
        }

        if ((var4 & 4) != 0) {
            var3 = var0.mobile;
        }

        return var0.copy(var1, var2, var3);
    }

    public final String component1() {
        return this.appIndex;
    }

    public final String component2() {
        return this.encryptedPassword;
    }

    public final String component3() {
        return this.mobile;
    }

    public final PinDuoDuoLoginRequestBean copy(String var1, String var2, String var3) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "appIndex");
        //Intrinsics.checkParameterIsNotNull(var2, "encryptedPassword");
        //Intrinsics.checkParameterIsNotNull(var3, "mobile");*/
        return new PinDuoDuoLoginRequestBean(var1, var2, var3);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (!(var1 instanceof PinDuoDuoLoginRequestBean)) {
                return false;
            }

            PinDuoDuoLoginRequestBean var2 = (PinDuoDuoLoginRequestBean)var1;
            if (!this.appIndex.equals(var2.appIndex) || !this.encryptedPassword.equals(var2.encryptedPassword) || !this.mobile.equals(var2.mobile)) {
                return false;
            }
        }

        return true;
    }

    public final String getAppIndex() {
        return this.appIndex;
    }

    public final String getEncryptedPassword() {
        return this.encryptedPassword;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public int hashCode() {
        String var4 = this.appIndex;
        int var3 = 0;
        int var1;
        if (var4 != null) {
            var1 = var4.hashCode();
        } else {
            var1 = 0;
        }

        var4 = this.encryptedPassword;
        int var2;
        if (var4 != null) {
            var2 = var4.hashCode();
        } else {
            var2 = 0;
        }

        var4 = this.mobile;
        if (var4 != null) {
            var3 = var4.hashCode();
        }

        return (var1 * 31 + var2) * 31 + var3;
    }

    public final void setAppIndex(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.appIndex = var1;
    }

    public final void setEncryptedPassword(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.encryptedPassword = var1;
    }

    public final void setMobile(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.mobile = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("PinDuoDuoLoginRequestBean(appIndex=");
        var1.append(this.appIndex);
        var1.append(", encryptedPassword=");
        var1.append(this.encryptedPassword);
        var1.append(", mobile=");
        var1.append(this.mobile);
        var1.append(")");
        return var1.toString();
    }
}
