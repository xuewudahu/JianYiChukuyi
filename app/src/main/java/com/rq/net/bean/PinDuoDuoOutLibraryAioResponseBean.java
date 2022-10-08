package com.rq.net.bean;

//import kotlin.*;
import com.rq.net.util.Intrinsics;

import java.util.*;
//import kotlin.jvm.internal.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\fH\u00c6\u0003JZ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/PinDuoDuoOutLibraryAioResponseBean;", "", "package_count", "", "mobile", "", "image_name", "package_id", "to_out_bound_detail_d_t_o_list", "", "Lcom/yunpan/cobaaidlservice/bean/BoundDetailList;", "success", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getImage_name", "()Ljava/lang/String;", "getMobile", "getPackage_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPackage_id", "getSuccess", "()Z", "getTo_out_bound_detail_d_t_o_list", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)Lcom/yunpan/cobaaidlservice/bean/PinDuoDuoOutLibraryAioResponseBean;", "equals", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class PinDuoDuoOutLibraryAioResponseBean
{
    private final String image_name;
    private final String mobile;
    private final Integer package_count;
    private final String package_id;
    private final boolean success;
    private final List<BoundDetailList> to_out_bound_detail_d_t_o_list;
    
    public PinDuoDuoOutLibraryAioResponseBean(final Integer package_count, final String mobile, final String image_name, final String package_id, final List<BoundDetailList> to_out_bound_detail_d_t_o_list, final boolean success) {
        this.package_count = package_count;
        this.mobile = mobile;
        this.image_name = image_name;
        this.package_id = package_id;
        this.to_out_bound_detail_d_t_o_list = to_out_bound_detail_d_t_o_list;
        this.success = success;
    }
    
    public final Integer component1() {
        return this.package_count;
    }
    
    public final String component2() {
        return this.mobile;
    }
    
    public final String component3() {
        return this.image_name;
    }
    
    public final String component4() {
        return this.package_id;
    }
    
    public final List<BoundDetailList> component5() {
        return this.to_out_bound_detail_d_t_o_list;
    }
    
    public final boolean component6() {
        return this.success;
    }
    
    public final PinDuoDuoOutLibraryAioResponseBean copy(final Integer n, final String s, final String s2, final String s3, final List<BoundDetailList> list, final boolean b) {
        return new PinDuoDuoOutLibraryAioResponseBean(n, s, s2, s3, list, b);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PinDuoDuoOutLibraryAioResponseBean) {
                final PinDuoDuoOutLibraryAioResponseBean pinDuoDuoOutLibraryAioResponseBean = (PinDuoDuoOutLibraryAioResponseBean)o;
                if (Intrinsics.areEqual(this.package_count, pinDuoDuoOutLibraryAioResponseBean.package_count) && Intrinsics.areEqual(this.mobile, pinDuoDuoOutLibraryAioResponseBean.mobile) && Intrinsics.areEqual(this.image_name, pinDuoDuoOutLibraryAioResponseBean.image_name) && Intrinsics.areEqual(this.package_id, pinDuoDuoOutLibraryAioResponseBean.package_id) && Intrinsics.areEqual(this.to_out_bound_detail_d_t_o_list, pinDuoDuoOutLibraryAioResponseBean.to_out_bound_detail_d_t_o_list) && this.success == pinDuoDuoOutLibraryAioResponseBean.success) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getImage_name() {
        return this.image_name;
    }
    
    public final String getMobile() {
        return this.mobile;
    }
    
    public final Integer getPackage_count() {
        return this.package_count;
    }
    
    public final String getPackage_id() {
        return this.package_id;
    }
    
    public final boolean getSuccess() {
        return this.success;
    }
    
    public final List<BoundDetailList> getTo_out_bound_detail_d_t_o_list() {
        return this.to_out_bound_detail_d_t_o_list;
    }
    
    @Override
    public int hashCode() {
        return 0;
        //throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PinDuoDuoOutLibraryAioResponseBean(package_count=");
        sb.append(this.package_count);
        sb.append(", mobile=");
        sb.append(this.mobile);
        sb.append(", image_name=");
        sb.append(this.image_name);
        sb.append(", package_id=");
        sb.append(this.package_id);
        sb.append(", to_out_bound_detail_d_t_o_list=");
        sb.append(this.to_out_bound_detail_d_t_o_list);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(")");
        return sb.toString();
    }
}
