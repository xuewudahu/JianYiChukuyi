package com.rq.net.bean;

//import kotlin.*;
import com.rq.net.util.Intrinsics;

//import kotlin.jvm.internal.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\bH\u00c6\u0003J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u000bH\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003Jw\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001J\t\u00100\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001b¨\u00061" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/TrialTimeInif;", "", "order_id", "", "order_number", "", "flow_number", "amount", "", "payment_type", "payment_state", "", "create_date", "finished_date", "old_trial_date", "new_trial_date", "trial_days", "(ILjava/lang/String;Ljava/lang/String;FIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAmount", "()F", "getCreate_date", "()Ljava/lang/String;", "getFinished_date", "getFlow_number", "getNew_trial_date", "getOld_trial_date", "getOrder_id", "()I", "getOrder_number", "getPayment_state", "()Z", "getPayment_type", "getTrial_days", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class TrialTimeInif
{
    private final float amount;
    private final String create_date;
    private final String finished_date;
    private final String flow_number;
    private final String new_trial_date;
    private final String old_trial_date;
    private final int order_id;
    private final String order_number;
    private final boolean payment_state;
    private final int payment_type;
    private final int trial_days;
    
    public TrialTimeInif(final int order_id, final String order_number, final String flow_number, final float amount, final int payment_type, final boolean payment_state, final String create_date, final String finished_date, final String old_trial_date, final String new_trial_date, final int trial_days) {
        //Intrinsics.checkParameterIsNotNull(order_number, "order_number");
        //Intrinsics.checkParameterIsNotNull(flow_number, "flow_number");
        //Intrinsics.checkParameterIsNotNull(create_date, "create_date");
        //Intrinsics.checkParameterIsNotNull(finished_date, "finished_date");
        //Intrinsics.checkParameterIsNotNull(old_trial_date, "old_trial_date");
        //Intrinsics.checkParameterIsNotNull(new_trial_date, "new_trial_date");
        this.order_id = order_id;
        this.order_number = order_number;
        this.flow_number = flow_number;
        this.amount = amount;
        this.payment_type = payment_type;
        this.payment_state = payment_state;
        this.create_date = create_date;
        this.finished_date = finished_date;
        this.old_trial_date = old_trial_date;
        this.new_trial_date = new_trial_date;
        this.trial_days = trial_days;
    }
    
    public final int component1() {
        return this.order_id;
    }
    
    public final String component10() {
        return this.new_trial_date;
    }
    
    public final int component11() {
        return this.trial_days;
    }
    
    public final String component2() {
        return this.order_number;
    }
    
    public final String component3() {
        return this.flow_number;
    }
    
    public final float component4() {
        return this.amount;
    }
    
    public final int component5() {
        return this.payment_type;
    }
    
    public final boolean component6() {
        return this.payment_state;
    }
    
    public final String component7() {
        return this.create_date;
    }
    
    public final String component8() {
        return this.finished_date;
    }
    
    public final String component9() {
        return this.old_trial_date;
    }
    
    public final TrialTimeInif copy(final int n, final String s, final String s2, final float n2, final int n3, final boolean b, final String s3, final String s4, final String s5, final String s6, final int n4) {
        //Intrinsics.checkParameterIsNotNull(s, "order_number");
        //Intrinsics.checkParameterIsNotNull(s2, "flow_number");
        //Intrinsics.checkParameterIsNotNull(s3, "create_date");
        //Intrinsics.checkParameterIsNotNull(s4, "finished_date");
        //Intrinsics.checkParameterIsNotNull(s5, "old_trial_date");
        //Intrinsics.checkParameterIsNotNull(s6, "new_trial_date");
        return new TrialTimeInif(n, s, s2, n2, n3, b, s3, s4, s5, s6, n4);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof TrialTimeInif) {
                final TrialTimeInif trialTimeInif = (TrialTimeInif)o;
                if (this.order_id == trialTimeInif.order_id && Intrinsics.areEqual(this.order_number, trialTimeInif.order_number) && Intrinsics.areEqual(this.flow_number, trialTimeInif.flow_number) && Float.compare(this.amount, trialTimeInif.amount) == 0 && this.payment_type == trialTimeInif.payment_type && this.payment_state == trialTimeInif.payment_state && Intrinsics.areEqual(this.create_date, trialTimeInif.create_date) && Intrinsics.areEqual(this.finished_date, trialTimeInif.finished_date) && Intrinsics.areEqual(this.old_trial_date, trialTimeInif.old_trial_date) && Intrinsics.areEqual(this.new_trial_date, trialTimeInif.new_trial_date) && this.trial_days == trialTimeInif.trial_days) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final float getAmount() {
        return this.amount;
    }
    
    public final String getCreate_date() {
        return this.create_date;
    }
    
    public final String getFinished_date() {
        return this.finished_date;
    }
    
    public final String getFlow_number() {
        return this.flow_number;
    }
    
    public final String getNew_trial_date() {
        return this.new_trial_date;
    }
    
    public final String getOld_trial_date() {
        return this.old_trial_date;
    }
    
    public final int getOrder_id() {
        return this.order_id;
    }
    
    public final String getOrder_number() {
        return this.order_number;
    }
    
    public final boolean getPayment_state() {
        return this.payment_state;
    }
    
    public final int getPayment_type() {
        return this.payment_type;
    }
    
    public final int getTrial_days() {
        return this.trial_days;
    }
    
    @Override
    public int hashCode() {
        return 0;
        //throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TrialTimeInif(order_id=");
        sb.append(this.order_id);
        sb.append(", order_number=");
        sb.append(this.order_number);
        sb.append(", flow_number=");
        sb.append(this.flow_number);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", payment_type=");
        sb.append(this.payment_type);
        sb.append(", payment_state=");
        sb.append(this.payment_state);
        sb.append(", create_date=");
        sb.append(this.create_date);
        sb.append(", finished_date=");
        sb.append(this.finished_date);
        sb.append(", old_trial_date=");
        sb.append(this.old_trial_date);
        sb.append(", new_trial_date=");
        sb.append(this.new_trial_date);
        sb.append(", trial_days=");
        sb.append(this.trial_days);
        sb.append(")");
        return sb.toString();
    }
}
