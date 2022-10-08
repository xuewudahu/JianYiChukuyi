package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/TrialInfo;", "", "trial_date", "", "surplus_days", "", "(Ljava/lang/String;I)V", "getSurplus_days", "()I", "getTrial_date", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class TrialInfo
{
    private final int surplus_days;
    private final String trial_date;
    
    public TrialInfo(final String trial_date, final int surplus_days) {
        //Intrinsics.checkParameterIsNotNull(trial_date, "trial_date");
        this.trial_date = trial_date;
        this.surplus_days = surplus_days;
    }
    
    public final String component1() {
        return this.trial_date;
    }
    
    public final int component2() {
        return this.surplus_days;
    }
    
    public final TrialInfo copy(final String s, final int n) {
        //Intrinsics.checkParameterIsNotNull(s, "trial_date");
        return new TrialInfo(s, n);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof TrialInfo) {
                final TrialInfo trialInfo = (TrialInfo)o;
                if (Intrinsics.areEqual(this.trial_date, trialInfo.trial_date) && this.surplus_days == trialInfo.surplus_days) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final int getSurplus_days() {
        return this.surplus_days;
    }
    
    public final String getTrial_date() {
        return this.trial_date;
    }
    
    @Override
    public int hashCode() {
        final String trial_date = this.trial_date;
        int hashCode;
        if (trial_date != null) {
            hashCode = trial_date.hashCode();
        }
        else {
            hashCode = 0;
        }
        return hashCode * 31 + this.surplus_days;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TrialInfo(trial_date=");
        sb.append(this.trial_date);
        sb.append(", surplus_days=");
        sb.append(this.surplus_days);
        sb.append(")");
        return sb.toString();
    }
}
