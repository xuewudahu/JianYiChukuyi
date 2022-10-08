package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/LoginRequestBean;", "", "type", "", "tel", "password", "sign", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPassword", "()Ljava/lang/String;", "getSign", "getTel", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class LoginRequestBean
{
    private final String password;
    private final String sign;
    private final String tel;
    private final String type;
    
    public LoginRequestBean(final String type, final String tel, final String password, final String sign) {
        //Intrinsics.checkParameterIsNotNull(type, "type");
        //Intrinsics.checkParameterIsNotNull(tel, "tel");
        //Intrinsics.checkParameterIsNotNull(password, "password");
        //Intrinsics.checkParameterIsNotNull(sign, "sign");
        this.type = type;
        this.tel = tel;
        this.password = password;
        this.sign = sign;
    }
    
    public final String component1() {
        return this.type;
    }
    
    public final String component2() {
        return this.tel;
    }
    
    public final String component3() {
        return this.password;
    }
    
    public final String component4() {
        return this.sign;
    }
    
    public final LoginRequestBean copy(final String s, final String s2, final String s3, final String s4) {
        //Intrinsics.checkParameterIsNotNull(s, "type");
        //Intrinsics.checkParameterIsNotNull(s2, "tel");
        //Intrinsics.checkParameterIsNotNull(s3, "password");
        //Intrinsics.checkParameterIsNotNull(s4, "sign");
        return new LoginRequestBean(s, s2, s3, s4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof LoginRequestBean) {
                final LoginRequestBean loginRequestBean = (LoginRequestBean)o;
                if (Intrinsics.areEqual(this.type, loginRequestBean.type) && Intrinsics.areEqual(this.tel, loginRequestBean.tel) && Intrinsics.areEqual(this.password, loginRequestBean.password) && Intrinsics.areEqual(this.sign, loginRequestBean.sign)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getPassword() {
        return this.password;
    }
    
    public final String getSign() {
        return this.sign;
    }
    
    public final String getTel() {
        return this.tel;
    }
    
    public final String getType() {
        return this.type;
    }
    
    @Override
    public int hashCode() {
        final String type = this.type;
        int hashCode = 0;
        int hashCode2;
        if (type != null) {
            hashCode2 = type.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String tel = this.tel;
        int hashCode3;
        if (tel != null) {
            hashCode3 = tel.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String password = this.password;
        int hashCode4;
        if (password != null) {
            hashCode4 = password.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String sign = this.sign;
        if (sign != null) {
            hashCode = sign.hashCode();
        }
        return ((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LoginRequestBean(type=");
        sb.append(this.type);
        sb.append(", tel=");
        sb.append(this.tel);
        sb.append(", password=");
        sb.append(this.password);
        sb.append(", sign=");
        sb.append(this.sign);
        sb.append(")");
        return sb.toString();
    }
}
