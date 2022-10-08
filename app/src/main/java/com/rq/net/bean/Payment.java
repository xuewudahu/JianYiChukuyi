package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public final class Payment<T>
{
    private final T data;
    private final boolean flag;
    private final String order_number;
    
    public Payment(final boolean flag, final T data, final String order_number) {
        //Intrinsics.checkParameterIsNotNull(order_number, "order_number");
        this.flag = flag;
        this.data = data;
        this.order_number = order_number;
    }
    
    public final boolean component1() {
        return this.flag;
    }
    
    public final T component2() {
        return this.data;
    }
    
    public final String component3() {
        return this.order_number;
    }
    
    public final Payment<T> copy(final boolean b, final T t, final String s) {
        //Intrinsics.checkParameterIsNotNull(s, "order_number");
        return new Payment<T>(b, t, s);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof Payment) {
                final Payment payment = (Payment)o;
                if (this.flag == payment.flag && Intrinsics.areEqual(this.data, payment.data) && Intrinsics.areEqual(this.order_number, payment.order_number)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final T getData() {
        return this.data;
    }
    
    public final boolean getFlag() {
        return this.flag;
    }
    
    public final String getOrder_number() {
        return this.order_number;
    }
    
    @Override
    public int hashCode() {
        return 0;
        //throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Payment(flag=");
        sb.append(this.flag);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", order_number=");
        sb.append(this.order_number);
        sb.append(")");
        return sb.toString();
    }
}
