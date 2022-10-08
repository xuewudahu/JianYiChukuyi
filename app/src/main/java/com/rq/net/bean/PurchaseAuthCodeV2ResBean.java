package com.rq.net.bean;

import com.rq.net.util.Intrinsics;


public final class PurchaseAuthCodeV2ResBean<T>
{
    private final T data;
    private final boolean flag;
    private final String order_number;
    private final boolean payment_state;
    
    public PurchaseAuthCodeV2ResBean(final boolean flag, final boolean payment_state, final T data, final String order_number) {
        this.flag = flag;
        this.payment_state = payment_state;
        this.data = data;
        this.order_number = order_number;
    }
    
    public final boolean component1() {
        return this.flag;
    }
    
    public final boolean component2() {
        return this.payment_state;
    }
    
    public final T component3() {
        return this.data;
    }
    
    public final String component4() {
        return this.order_number;
    }
    
    public final PurchaseAuthCodeV2ResBean<T> copy(final boolean b, final boolean b2, final T t, final String s) {
        return new PurchaseAuthCodeV2ResBean<T>(b, b2, t, s);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PurchaseAuthCodeV2ResBean) {
                final PurchaseAuthCodeV2ResBean purchaseAuthCodeV2ResBean = (PurchaseAuthCodeV2ResBean)o;
                if (this.flag == purchaseAuthCodeV2ResBean.flag && this.payment_state == purchaseAuthCodeV2ResBean.payment_state && Intrinsics.areEqual(this.data, purchaseAuthCodeV2ResBean.data) && Intrinsics.areEqual(this.order_number, purchaseAuthCodeV2ResBean.order_number)) {
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
    
    public final boolean getPayment_state() {
        return this.payment_state;
    }
    
    @Override
    public int hashCode() {
        //throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
        return 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PurchaseAuthCodeV2ResBean(flag=");
        sb.append(this.flag);
        sb.append(", payment_state=");
        sb.append(this.payment_state);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", order_number=");
        sb.append(this.order_number);
        sb.append(")");
        return sb.toString();
    }
}
