package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/PackageBean;", "", "id", "", "express_num", "", "express_com", "client_tel", "client_name", "remark", "pcode", "checked", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChecked", "()Ljava/lang/String;", "getClient_name", "getClient_tel", "getExpress_com", "getExpress_num", "getId", "()I", "getPcode", "getRemark", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class PackageBean
{
    private final String checked;
    private final String client_name;
    private final String client_tel;
    private final String express_com;
    private final String express_num;
    private final int id;
    private final String pcode;
    private final String remark;
    
    public PackageBean(final int id, final String express_num, final String express_com, final String client_tel, final String client_name, final String remark, final String pcode, final String checked) {
        //Intrinsics.checkParameterIsNotNull(express_num, "express_num");
        //Intrinsics.checkParameterIsNotNull(express_com, "express_com");
        //Intrinsics.checkParameterIsNotNull(client_tel, "client_tel");
        //Intrinsics.checkParameterIsNotNull(client_name, "client_name");
        //Intrinsics.checkParameterIsNotNull(remark, "remark");
        //Intrinsics.checkParameterIsNotNull(pcode, "pcode");
        //Intrinsics.checkParameterIsNotNull(checked, "checked");
        this.id = id;
        this.express_num = express_num;
        this.express_com = express_com;
        this.client_tel = client_tel;
        this.client_name = client_name;
        this.remark = remark;
        this.pcode = pcode;
        this.checked = checked;
    }
    
    public final int component1() {
        return this.id;
    }
    
    public final String component2() {
        return this.express_num;
    }
    
    public final String component3() {
        return this.express_com;
    }
    
    public final String component4() {
        return this.client_tel;
    }
    
    public final String component5() {
        return this.client_name;
    }
    
    public final String component6() {
        return this.remark;
    }
    
    public final String component7() {
        return this.pcode;
    }
    
    public final String component8() {
        return this.checked;
    }
    
    public final PackageBean copy(final int n, final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final String s7) {
        //Intrinsics.checkParameterIsNotNull(s, "express_num");
        //Intrinsics.checkParameterIsNotNull(s2, "express_com");
        //Intrinsics.checkParameterIsNotNull(s3, "client_tel");
        //Intrinsics.checkParameterIsNotNull(s4, "client_name");
        //Intrinsics.checkParameterIsNotNull(s5, "remark");
        //Intrinsics.checkParameterIsNotNull(s6, "pcode");
        //Intrinsics.checkParameterIsNotNull(s7, "checked");
        return new PackageBean(n, s, s2, s3, s4, s5, s6, s7);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PackageBean) {
                final PackageBean packageBean = (PackageBean)o;
                if (this.id == packageBean.id && Intrinsics.areEqual(this.express_num, packageBean.express_num) && Intrinsics.areEqual(this.express_com, packageBean.express_com) && Intrinsics.areEqual(this.client_tel, packageBean.client_tel) && Intrinsics.areEqual(this.client_name, packageBean.client_name) && Intrinsics.areEqual(this.remark, packageBean.remark) && Intrinsics.areEqual(this.pcode, packageBean.pcode) && Intrinsics.areEqual(this.checked, packageBean.checked)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getChecked() {
        return this.checked;
    }
    
    public final String getClient_name() {
        return this.client_name;
    }
    
    public final String getClient_tel() {
        return this.client_tel;
    }
    
    public final String getExpress_com() {
        return this.express_com;
    }
    
    public final String getExpress_num() {
        return this.express_num;
    }
    
    public final int getId() {
        return this.id;
    }
    
    public final String getPcode() {
        return this.pcode;
    }
    
    public final String getRemark() {
        return this.remark;
    }
    
    @Override
    public int hashCode() {
        final int id = this.id;
        final String express_num = this.express_num;
        int hashCode = 0;
        int hashCode2;
        if (express_num != null) {
            hashCode2 = express_num.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String express_com = this.express_com;
        int hashCode3;
        if (express_com != null) {
            hashCode3 = express_com.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String client_tel = this.client_tel;
        int hashCode4;
        if (client_tel != null) {
            hashCode4 = client_tel.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String client_name = this.client_name;
        int hashCode5;
        if (client_name != null) {
            hashCode5 = client_name.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final String remark = this.remark;
        int hashCode6;
        if (remark != null) {
            hashCode6 = remark.hashCode();
        }
        else {
            hashCode6 = 0;
        }
        final String pcode = this.pcode;
        int hashCode7;
        if (pcode != null) {
            hashCode7 = pcode.hashCode();
        }
        else {
            hashCode7 = 0;
        }
        final String checked = this.checked;
        if (checked != null) {
            hashCode = checked.hashCode();
        }
        return ((((((id * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PackageBean(id=");
        sb.append(this.id);
        sb.append(", express_num=");
        sb.append(this.express_num);
        sb.append(", express_com=");
        sb.append(this.express_com);
        sb.append(", client_tel=");
        sb.append(this.client_tel);
        sb.append(", client_name=");
        sb.append(this.client_name);
        sb.append(", remark=");
        sb.append(this.remark);
        sb.append(", pcode=");
        sb.append(this.pcode);
        sb.append(", checked=");
        sb.append(this.checked);
        sb.append(")");
        return sb.toString();
    }
}
