package com.rq.net.bean;

public final class RenewConfig
{
    private final Programme large;
    private final Programme middle;
    
    public RenewConfig(final Programme middle, final Programme large) {
        //Intrinsics.checkParameterIsNotNull(middle, "middle");
        //Intrinsics.checkParameterIsNotNull(large, "large");
        this.middle = middle;
        this.large = large;
    }
    
    public final Programme getLarge() {
        return this.large;
    }
    
    public final Programme getMiddle() {
        return this.middle;
    }
}
