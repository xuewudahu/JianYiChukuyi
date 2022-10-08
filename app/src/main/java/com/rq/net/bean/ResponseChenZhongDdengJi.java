package com.rq.net.bean;


import com.rq.net.util.Intrinsics;

public final class ResponseChenZhongDdengJi
{
    private final int code;
    private final String msg;
    private final ResultData result;
    private final String subCode;
    
    public ResponseChenZhongDdengJi(final int code, final String msg, final ResultData result, final String subCode) {
       /* //Intrinsics.checkParameterIsNotNull(msg, "msg");
        //Intrinsics.checkParameterIsNotNull(result, "result");
        //Intrinsics.checkParameterIsNotNull(subCode, "subCode");*/
        this.code = code;
        this.msg = msg;
        this.result = result;
        this.subCode = subCode;
    }
    
    public final int component1() {
        return this.code;
    }
    
    public final String component2() {
        return this.msg;
    }
    
    public final ResultData component3() {
        return this.result;
    }
    
    public final String component4() {
        return this.subCode;
    }
    
    public final ResponseChenZhongDdengJi copy(final int n, final String s, final ResultData resultData, final String s2) {
        /*//Intrinsics.checkParameterIsNotNull(s, "msg");
        //Intrinsics.checkParameterIsNotNull(resultData, "result");
        //Intrinsics.checkParameterIsNotNull(s2, "subCode");*/
        return new ResponseChenZhongDdengJi(n, s, resultData, s2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof ResponseChenZhongDdengJi) {
                final ResponseChenZhongDdengJi responseChenZhongDdengJi = (ResponseChenZhongDdengJi)o;
                if (this.code == responseChenZhongDdengJi.code && Intrinsics.areEqual(this.msg, responseChenZhongDdengJi.msg) && Intrinsics.areEqual(this.result, responseChenZhongDdengJi.result) && Intrinsics.areEqual(this.subCode, responseChenZhongDdengJi.subCode)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final int getCode() {
        return this.code;
    }
    
    public final String getMsg() {
        return this.msg;
    }
    
    public final ResultData getResult() {
        return this.result;
    }
    
    public final String getSubCode() {
        return this.subCode;
    }
    
    @Override
    public int hashCode() {
        final int code = this.code;
        final String msg = this.msg;
        int hashCode = 0;
        int hashCode2;
        if (msg != null) {
            hashCode2 = msg.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final ResultData result = this.result;
        int hashCode3;
        if (result != null) {
            hashCode3 = result.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String subCode = this.subCode;
        if (subCode != null) {
            hashCode = subCode.hashCode();
        }
        return ((code * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ResponseChenZhongDdengJi(code=");
        sb.append(this.code);
        sb.append(", msg=");
        sb.append(this.msg);
        sb.append(", result=");
        sb.append(this.result);
        sb.append(", subCode=");
        sb.append(this.subCode);
        sb.append(")");
        return sb.toString();
    }
}
