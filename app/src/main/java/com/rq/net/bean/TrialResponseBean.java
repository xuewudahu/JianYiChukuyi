package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

import java.util.*;

public final class TrialResponseBean
{
    private final int count;
    private final List<TrialTimeInif> results;
    private final TrialInfo trial_info;
    
    public TrialResponseBean(final int count, final List<TrialTimeInif> results, final TrialInfo trial_info) {
        this.count = count;
        this.results = results;
        this.trial_info = trial_info;
    }
    
    public final int component1() {
        return this.count;
    }
    
    public final List<TrialTimeInif> component2() {
        return this.results;
    }
    
    public final TrialInfo component3() {
        return this.trial_info;
    }
    
    public final TrialResponseBean copy(final int n, final List<TrialTimeInif> list, final TrialInfo trialInfo) {
        return new TrialResponseBean(n, list, trialInfo);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof TrialResponseBean) {
                final TrialResponseBean trialResponseBean = (TrialResponseBean)o;
                if (this.count == trialResponseBean.count && Intrinsics.areEqual(this.results, trialResponseBean.results) && Intrinsics.areEqual(this.trial_info, trialResponseBean.trial_info)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final int getCount() {
        return this.count;
    }
    
    public final List<TrialTimeInif> getResults() {
        return this.results;
    }
    
    public final TrialInfo getTrial_info() {
        return this.trial_info;
    }
    
    @Override
    public int hashCode() {
        final int count = this.count;
        final List<TrialTimeInif> results = this.results;
        int hashCode = 0;
        int hashCode2;
        if (results != null) {
            hashCode2 = results.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final TrialInfo trial_info = this.trial_info;
        if (trial_info != null) {
            hashCode = trial_info.hashCode();
        }
        return (count * 31 + hashCode2) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TrialResponseBean(count=");
        sb.append(this.count);
        sb.append(", results=");
        sb.append(this.results);
        sb.append(", trial_info=");
        sb.append(this.trial_info);
        sb.append(")");
        return sb.toString();
    }
}
