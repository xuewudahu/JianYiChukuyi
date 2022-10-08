package com.rq.net.bean;


import com.rq.net.util.Intrinsics;

public final class PandaLoginBean {
    private String deviceNum;
    private String userName;
    private String userPwd;

    public PandaLoginBean() {
        this(null, null, null, 7);
    }

    public PandaLoginBean(String var1,  String var2, String var3) {

        init(var1, var2, var3);
    }

    // $FF: synthetic method
    public PandaLoginBean(String var1, String var2, String var3, int var4) {
        if ((var4 & 1) != 0) {
            var1 = "";
        }

        if ((var4 & 2) != 0) {
            var2 = "";
        }

        if ((var4 & 4) != 0) {
            var3 = "";
        }

        init(var1, var2, var3);
    }

    private void init(String var1,  String var2, String var3) {

        this.userName = var1;
        this.userPwd = var2;
        this.deviceNum = var3;
    }

    // $FF: synthetic method
    public static PandaLoginBean copy$default(PandaLoginBean var0, String var1, String var2, String var3, int var4, Object var5) {
        if ((var4 & 1) != 0) {
            var1 = var0.userName;
        }

        if ((var4 & 2) != 0) {
            var2 = var0.userPwd;
        }

        if ((var4 & 4) != 0) {
            var3 = var0.deviceNum;
        }

        return var0.copy(var1, var2, var3);
    }

    public final String component1() {
        return this.userName;
    }

    public final String component2() {
        return this.userPwd;
    }

    public final String component3() {
        return this.deviceNum;
    }

    public final PandaLoginBean copy( String var1, String var2, String var3) {

        return new PandaLoginBean(var1, var2, var3);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (!(var1 instanceof PandaLoginBean)) {
                return false;
            }

            PandaLoginBean var2 = (PandaLoginBean)var1;
            if (!Intrinsics.areEqual(this.userName, var2.userName) || !Intrinsics.areEqual(this.userPwd, var2.userPwd) || !Intrinsics.areEqual(this.deviceNum, var2.deviceNum)) {
                return false;
            }
        }

        return true;
    }

    public final String getDeviceNum() {
        return this.deviceNum;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserPwd() {
        return this.userPwd;
    }

    public int hashCode() {
        String var4 = this.userName;
        int var3 = 0;
        int var1;
        if (var4 != null) {
            var1 = var4.hashCode();
        } else {
            var1 = 0;
        }

        var4 = this.userPwd;
        int var2;
        if (var4 != null) {
            var2 = var4.hashCode();
        } else {
            var2 = 0;
        }

        var4 = this.deviceNum;
        if (var4 != null) {
            var3 = var4.hashCode();
        }

        return (var1 * 31 + var2) * 31 + var3;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("PandaLoginBean(userName=");
        var1.append(this.userName);
        var1.append(", userPwd=");
        var1.append(this.userPwd);
        var1.append(", deviceNum=");
        var1.append(this.deviceNum);
        var1.append(")");
        return var1.toString();
    }
}
