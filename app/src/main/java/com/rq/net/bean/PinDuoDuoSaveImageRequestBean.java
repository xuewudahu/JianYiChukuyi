package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public class PinDuoDuoSaveImageRequestBean {
    private String image_name;
    private String image_url;

    public PinDuoDuoSaveImageRequestBean(String var1, String var2) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "image_url");
        //Intrinsics.checkParameterIsNotNull(var2, "image_name");*/
        super();
        this.image_url = var1;
        this.image_name = var2;
    }

    // $FF: synthetic method
    public static PinDuoDuoSaveImageRequestBean copy$default(PinDuoDuoSaveImageRequestBean var0, String var1, String var2, int var3, Object var4) {
        if ((var3 & 1) != 0) {
            var1 = var0.image_url;
        }

        if ((var3 & 2) != 0) {
            var2 = var0.image_name;
        }

        return var0.copy(var1, var2);
    }

    public final String component1() {
        return this.image_url;
    }

    public final String component2() {
        return this.image_name;
    }

    public final PinDuoDuoSaveImageRequestBean copy(String var1, String var2) {
        /*//Intrinsics.checkParameterIsNotNull(var1, "image_url");
        //Intrinsics.checkParameterIsNotNull(var2, "image_name");*/
        return new PinDuoDuoSaveImageRequestBean(var1, var2);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (!(var1 instanceof PinDuoDuoSaveImageRequestBean)) {
                return false;
            }

            PinDuoDuoSaveImageRequestBean var2 = (PinDuoDuoSaveImageRequestBean)var1;
            if (!Intrinsics.areEqual(this.image_url, var2.image_url) || !Intrinsics.areEqual(this.image_name, var2.image_name)) {
                return false;
            }
        }

        return true;
    }

    public final String getImage_name() {
        return this.image_name;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public int hashCode() {
        String var3 = this.image_url;
        int var2 = 0;
        int var1;
        if (var3 != null) {
            var1 = var3.hashCode();
        } else {
            var1 = 0;
        }

        var3 = this.image_name;
        if (var3 != null) {
            var2 = var3.hashCode();
        }

        return var1 * 31 + var2;
    }

    public final void setImage_name(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.image_name = var1;
    }

    public final void setImage_url(String var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.image_url = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("PinDuoDuoSaveImageRequestBean(image_url=");
        var1.append(this.image_url);
        var1.append(", image_name=");
        var1.append(this.image_name);
        var1.append(")");
        return var1.toString();
    }
}
