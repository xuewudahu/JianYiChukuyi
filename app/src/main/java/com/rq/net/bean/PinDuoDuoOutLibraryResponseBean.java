package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public final class PinDuoDuoOutLibraryResponseBean {
    private String content;
    private String display;
    private String image_name;
    private Integer package_count;
    private String package_id;
    private boolean scan_out_success;

    public PinDuoDuoOutLibraryResponseBean(String var1, String var2, String var3, Integer var4, String var5, boolean var6) {
        this.content = var1;
        this.display = var2;
        this.image_name = var3;
        this.package_count = var4;
        this.package_id = var5;
        this.scan_out_success = var6;
    }

    // $FF: synthetic method
    public static PinDuoDuoOutLibraryResponseBean copy$default(PinDuoDuoOutLibraryResponseBean var0, String var1, String var2, String var3, Integer var4, String var5, boolean var6, int var7, Object var8) {
        if ((var7 & 1) != 0) {
            var1 = var0.content;
        }

        if ((var7 & 2) != 0) {
            var2 = var0.display;
        }

        if ((var7 & 4) != 0) {
            var3 = var0.image_name;
        }

        if ((var7 & 8) != 0) {
            var4 = var0.package_count;
        }

        if ((var7 & 16) != 0) {
            var5 = var0.package_id;
        }

        if ((var7 & 32) != 0) {
            var6 = var0.scan_out_success;
        }

        return var0.copy(var1, var2, var3, var4, var5, var6);
    }

    public final String component1() {
        return this.content;
    }

    public final String component2() {
        return this.display;
    }

    public final String component3() {
        return this.image_name;
    }

    public final Integer component4() {
        return this.package_count;
    }

    public final String component5() {
        return this.package_id;
    }

    public final boolean component6() {
        return this.scan_out_success;
    }

    public final PinDuoDuoOutLibraryResponseBean copy(String var1, String var2, String var3, Integer var4, String var5, boolean var6) {
        return new PinDuoDuoOutLibraryResponseBean(var1, var2, var3, var4, var5, var6);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (!(var1 instanceof PinDuoDuoOutLibraryResponseBean)) {
                return false;
            }

            PinDuoDuoOutLibraryResponseBean var2 = (PinDuoDuoOutLibraryResponseBean)var1;
            if (!Intrinsics.areEqual(this.content, var2.content) || !Intrinsics.areEqual(this.display, var2.display) || !Intrinsics.areEqual(this.image_name, var2.image_name) || this.package_count.intValue() != var2.package_count.intValue() || !Intrinsics.areEqual(this.package_id, var2.package_id) || this.scan_out_success != var2.scan_out_success) {
                return false;
            }
        }

        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDisplay() {
        return this.display;
    }

    public final String getImage_name() {
        return this.image_name;
    }

    public final Integer getPackage_count() {
        return this.package_count;
    }

    public final String getPackage_id() {
        return this.package_id;
    }

    public final boolean getScan_out_success() {
        return this.scan_out_success;
    }

    public int hashCode() {
        throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public final void setContent(String var1) {
        this.content = var1;
    }

    public final void setDisplay(String var1) {
        this.display = var1;
    }

    public final void setImage_name(String var1) {
        this.image_name = var1;
    }

    public final void setPackage_count(Integer var1) {
        this.package_count = var1;
    }

    public final void setPackage_id(String var1) {
        this.package_id = var1;
    }

    public final void setScan_out_success(boolean var1) {
        this.scan_out_success = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("PinDuoDuoOutLibraryResponseBean(content=");
        var1.append(this.content);
        var1.append(", display=");
        var1.append(this.display);
        var1.append(", image_name=");
        var1.append(this.image_name);
        var1.append(", package_count=");
        var1.append(this.package_count);
        var1.append(", package_id=");
        var1.append(this.package_id);
        var1.append(", scan_out_success=");
        var1.append(this.scan_out_success);
        var1.append(")");
        return var1.toString();
    }
}