package com.rq.net.bean;

public final class Peoblem
{
    private String problem;
    private String sign;
    private String sn;
    private String timestamp;
    
    public Peoblem(final String sn, final String problem, final String timestamp, final String sign) {
        //Intrinsics.checkParameterIsNotNull(sn, "sn");
        //Intrinsics.checkParameterIsNotNull(problem, "problem");
        //Intrinsics.checkParameterIsNotNull(timestamp, "timestamp");
        //Intrinsics.checkParameterIsNotNull(sign, "sign");
        this.sn = sn;
        this.problem = problem;
        this.timestamp = timestamp;
        this.sign = sign;
    }
    
    public final String getProblem() {
        return this.problem;
    }
    
    public final String getSign() {
        return this.sign;
    }
    
    public final String getSn() {
        return this.sn;
    }
    
    public final String getTimestamp() {
        return this.timestamp;
    }
    
    public final void setProblem(final String problem) {
        //Intrinsics.checkParameterIsNotNull(problem, "<set-?>");
        this.problem = problem;
    }
    
    public final void setSign(final String sign) {
        //Intrinsics.checkParameterIsNotNull(sign, "<set-?>");
        this.sign = sign;
    }
    
    public final void setSn(final String sn) {
        //Intrinsics.checkParameterIsNotNull(sn, "<set-?>");
        this.sn = sn;
    }
    
    public final void setTimestamp(final String timestamp) {
        //Intrinsics.checkParameterIsNotNull(timestamp, "<set-?>");
        this.timestamp = timestamp;
    }
}
