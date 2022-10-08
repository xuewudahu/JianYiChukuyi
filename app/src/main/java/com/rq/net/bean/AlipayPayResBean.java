package com.rq.net.bean;


import com.rq.net.util.Intrinsics;

public final class AlipayPayResBean
{
    private String out_trade_no;
    private String qr_code;
    
    public AlipayPayResBean(final String out_trade_no, final String qr_code) {
        /*//Intrinsics.checkParameterIsNotNull(out_trade_no, "out_trade_no");
        //Intrinsics.checkParameterIsNotNull(qr_code, "qr_code");*/
        this.out_trade_no = out_trade_no;
        this.qr_code = qr_code;
    }
    
    public final String component1() {
        return this.out_trade_no;
    }
    
    public final String component2() {
        return this.qr_code;
    }
    
    public final AlipayPayResBean copy(final String s, final String s2) {
        /*//Intrinsics.checkParameterIsNotNull(s, "out_trade_no");
        //Intrinsics.checkParameterIsNotNull(s2, "qr_code");*/
        return new AlipayPayResBean(s, s2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof AlipayPayResBean) {
                final AlipayPayResBean alipayPayResBean = (AlipayPayResBean)o;
                if (Intrinsics.areEqual(this.out_trade_no, alipayPayResBean.out_trade_no) && Intrinsics.areEqual(this.qr_code, alipayPayResBean.qr_code)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getOut_trade_no() {
        return this.out_trade_no;
    }
    
    public final String getQr_code() {
        return this.qr_code;
    }
    
    @Override
    public int hashCode() {
        final String out_trade_no = this.out_trade_no;
        int hashCode = 0;
        int hashCode2;
        if (out_trade_no != null) {
            hashCode2 = out_trade_no.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String qr_code = this.qr_code;
        if (qr_code != null) {
            hashCode = qr_code.hashCode();
        }
        return hashCode2 * 31 + hashCode;
    }
    
    public final void setOut_trade_no(final String out_trade_no) {
        ////Intrinsics.checkParameterIsNotNull(out_trade_no, "<set-?>");
        this.out_trade_no = out_trade_no;
    }
    
    public final void setQr_code(final String qr_code) {
       // //Intrinsics.checkParameterIsNotNull(qr_code, "<set-?>");
        this.qr_code = qr_code;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AlipayPayResBean(out_trade_no=");
        sb.append(this.out_trade_no);
        sb.append(", qr_code=");
        sb.append(this.qr_code);
        sb.append(")");
        return sb.toString();
    }
}
