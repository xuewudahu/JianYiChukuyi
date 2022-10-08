package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001J\t\u0010 \u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006!" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/UserVerifyResponseBean;", "", "error_code", "", "error_message", "", "result", "success", "", "(ILjava/lang/String;Ljava/lang/String;Z)V", "getError_code", "()I", "setError_code", "(I)V", "getError_message", "()Ljava/lang/String;", "setError_message", "(Ljava/lang/String;)V", "getResult", "setResult", "getSuccess", "()Z", "setSuccess", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class UserVerifyResponseBean
{
    private int error_code;
    private String error_message;
    private String result;
    private boolean success;
    
    public UserVerifyResponseBean(final int error_code, final String error_message, final String result, final boolean success) {
        //Intrinsics.checkParameterIsNotNull(error_message, "error_message");
        //Intrinsics.checkParameterIsNotNull(result, "result");
        this.error_code = error_code;
        this.error_message = error_message;
        this.result = result;
        this.success = success;
    }
    
    public final int component1() {
        return this.error_code;
    }
    
    public final String component2() {
        return this.error_message;
    }
    
    public final String component3() {
        return this.result;
    }
    
    public final boolean component4() {
        return this.success;
    }
    
    public final UserVerifyResponseBean copy(final int n, final String s, final String s2, final boolean b) {
        //Intrinsics.checkParameterIsNotNull(s, "error_message");
        //Intrinsics.checkParameterIsNotNull(s2, "result");
        return new UserVerifyResponseBean(n, s, s2, b);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof UserVerifyResponseBean) {
                final UserVerifyResponseBean userVerifyResponseBean = (UserVerifyResponseBean)o;
                if (this.error_code == userVerifyResponseBean.error_code && Intrinsics.areEqual(this.error_message, userVerifyResponseBean.error_message) && Intrinsics.areEqual(this.result, userVerifyResponseBean.result) && this.success == userVerifyResponseBean.success) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final int getError_code() {
        return this.error_code;
    }
    
    public final String getError_message() {
        return this.error_message;
    }
    
    public final String getResult() {
        return this.result;
    }
    
    public final boolean getSuccess() {
        return this.success;
    }
    
    @Override
    public int hashCode() {
        return 0;
        //throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    public final void setError_code(final int error_code) {
        this.error_code = error_code;
    }
    
    public final void setError_message(final String error_message) {
        //Intrinsics.checkParameterIsNotNull(error_message, "<set-?>");
        this.error_message = error_message;
    }
    
    public final void setResult(final String result) {
        //Intrinsics.checkParameterIsNotNull(result, "<set-?>");
        this.result = result;
    }
    
    public final void setSuccess(final boolean success) {
        this.success = success;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("UserVerifyResponseBean(error_code=");
        sb.append(this.error_code);
        sb.append(", error_message=");
        sb.append(this.error_message);
        sb.append(", result=");
        sb.append(this.result);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(")");
        return sb.toString();
    }
}
