package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

public final class ResultData
{
    private final String contextId;
    private final ResultDataBean data;
    
    public ResultData(final String contextId, final ResultDataBean data) {
        //Intrinsics.checkParameterIsNotNull(contextId, "contextId");
        //Intrinsics.checkParameterIsNotNull(data, "data");
        this.contextId = contextId;
        this.data = data;
    }
    
    public final String component1() {
        return this.contextId;
    }
    
    public final ResultDataBean component2() {
        return this.data;
    }
    
    public final ResultData copy(final String s, final ResultDataBean resultDataBean) {
        //Intrinsics.checkParameterIsNotNull(s, "contextId");
        //Intrinsics.checkParameterIsNotNull(resultDataBean, "data");
        return new ResultData(s, resultDataBean);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof ResultData) {
                final ResultData resultData = (ResultData)o;
                if (Intrinsics.areEqual(this.contextId, resultData.contextId) && Intrinsics.areEqual(this.data, resultData.data)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getContextId() {
        return this.contextId;
    }
    
    public final ResultDataBean getData() {
        return this.data;
    }
    
    @Override
    public int hashCode() {
        final String contextId = this.contextId;
        int hashCode = 0;
        int hashCode2;
        if (contextId != null) {
            hashCode2 = contextId.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final ResultDataBean data = this.data;
        if (data != null) {
            hashCode = data.hashCode();
        }
        return hashCode2 * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ResultData(contextId=");
        sb.append(this.contextId);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(")");
        return sb.toString();
    }
}
