package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

//import kotlin.*;
//import kotlin.jvm.internal.*;

public final class AuthFlowsBean
{
    private String authenticated_date;
    private String code;
    private String deadline;
    private String icon;
    private String name;
    private String order_number;
    private Boolean payment_state;
    private Integer payment_type;
    private Double price;
    private Boolean support_multi;
    
    public AuthFlowsBean(final String order_number, final String code, final String name, final String icon, final Double price, final Boolean support_multi, final Integer payment_type, final Boolean payment_state, final String authenticated_date, final String deadline) {
        this.order_number = order_number;
        this.code = code;
        this.name = name;
        this.icon = icon;
        this.price = price;
        this.support_multi = support_multi;
        this.payment_type = payment_type;
        this.payment_state = payment_state;
        this.authenticated_date = authenticated_date;
        this.deadline = deadline;
    }
    
    public final String component1() {
        return this.order_number;
    }
    
    public final String component10() {
        return this.deadline;
    }
    
    public final String component2() {
        return this.code;
    }
    
    public final String component3() {
        return this.name;
    }
    
    public final String component4() {
        return this.icon;
    }
    
    public final Double component5() {
        return this.price;
    }
    
    public final Boolean component6() {
        return this.support_multi;
    }
    
    public final Integer component7() {
        return this.payment_type;
    }
    
    public final Boolean component8() {
        return this.payment_state;
    }
    
    public final String component9() {
        return this.authenticated_date;
    }
    
    public final AuthFlowsBean copy(final String s, final String s2, final String s3, final String s4, final Double n, final Boolean b, final Integer n2, final Boolean b2, final String s5, final String s6) {
        return new AuthFlowsBean(s, s2, s3, s4, n, b, n2, b2, s5, s6);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof AuthFlowsBean) {
                final AuthFlowsBean authFlowsBean = (AuthFlowsBean)o;
                if (Intrinsics.areEqual(this.order_number, authFlowsBean.order_number) && Intrinsics.areEqual(this.code, authFlowsBean.code) && Intrinsics.areEqual(this.name, authFlowsBean.name) && Intrinsics.areEqual(this.icon, authFlowsBean.icon) && Intrinsics.areEqual(this.price, (Object)authFlowsBean.price) && Intrinsics.areEqual(this.support_multi, authFlowsBean.support_multi) && Intrinsics.areEqual(this.payment_type, authFlowsBean.payment_type) && Intrinsics.areEqual(this.payment_state, authFlowsBean.payment_state) && Intrinsics.areEqual(this.authenticated_date, authFlowsBean.authenticated_date) && Intrinsics.areEqual(this.deadline, authFlowsBean.deadline)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final String getAuthenticated_date() {
        return this.authenticated_date;
    }
    
    public final String getCode() {
        return this.code;
    }
    
    public final String getDeadline() {
        return this.deadline;
    }
    
    public final String getIcon() {
        return this.icon;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public final String getOrder_number() {
        return this.order_number;
    }
    
    public final Boolean getPayment_state() {
        return this.payment_state;
    }
    
    public final Integer getPayment_type() {
        return this.payment_type;
    }
    
    public final Double getPrice() {
        return this.price;
    }
    
    public final Boolean getSupport_multi() {
        return this.support_multi;
    }
    
    @Override
    public int hashCode() {
        final String order_number = this.order_number;
        int hashCode = 0;
        int hashCode2;
        if (order_number != null) {
            hashCode2 = order_number.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final String code = this.code;
        int hashCode3;
        if (code != null) {
            hashCode3 = code.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final String name = this.name;
        int hashCode4;
        if (name != null) {
            hashCode4 = name.hashCode();
        }
        else {
            hashCode4 = 0;
        }
        final String icon = this.icon;
        int hashCode5;
        if (icon != null) {
            hashCode5 = icon.hashCode();
        }
        else {
            hashCode5 = 0;
        }
        final Double price = this.price;
        int hashCode6;
        if (price != null) {
            hashCode6 = price.hashCode();
        }
        else {
            hashCode6 = 0;
        }
        final Boolean support_multi = this.support_multi;
        int hashCode7;
        if (support_multi != null) {
            hashCode7 = support_multi.hashCode();
        }
        else {
            hashCode7 = 0;
        }
        final Integer payment_type = this.payment_type;
        int hashCode8;
        if (payment_type != null) {
            hashCode8 = payment_type.hashCode();
        }
        else {
            hashCode8 = 0;
        }
        final Boolean payment_state = this.payment_state;
        int hashCode9;
        if (payment_state != null) {
            hashCode9 = payment_state.hashCode();
        }
        else {
            hashCode9 = 0;
        }
        final String authenticated_date = this.authenticated_date;
        int hashCode10;
        if (authenticated_date != null) {
            hashCode10 = authenticated_date.hashCode();
        }
        else {
            hashCode10 = 0;
        }
        final String deadline = this.deadline;
        if (deadline != null) {
            hashCode = deadline.hashCode();
        }
        return ((((((((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode8) * 31 + hashCode9) * 31 + hashCode10) * 31 + hashCode;
    }
    
    public final void setAuthenticated_date(final String authenticated_date) {
        this.authenticated_date = authenticated_date;
    }
    
    public final void setCode(final String code) {
        this.code = code;
    }
    
    public final void setDeadline(final String deadline) {
        this.deadline = deadline;
    }
    
    public final void setIcon(final String icon) {
        this.icon = icon;
    }
    
    public final void setName(final String name) {
        this.name = name;
    }
    
    public final void setOrder_number(final String order_number) {
        this.order_number = order_number;
    }
    
    public final void setPayment_state(final Boolean payment_state) {
        this.payment_state = payment_state;
    }
    
    public final void setPayment_type(final Integer payment_type) {
        this.payment_type = payment_type;
    }
    
    public final void setPrice(final Double price) {
        this.price = price;
    }
    
    public final void setSupport_multi(final Boolean support_multi) {
        this.support_multi = support_multi;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AuthFlowsBean(order_number=");
        sb.append(this.order_number);
        sb.append(", code=");
        sb.append(this.code);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", price=");
        sb.append(this.price);
        sb.append(", support_multi=");
        sb.append(this.support_multi);
        sb.append(", payment_type=");
        sb.append(this.payment_type);
        sb.append(", payment_state=");
        sb.append(this.payment_state);
        sb.append(", authenticated_date=");
        sb.append(this.authenticated_date);
        sb.append(", deadline=");
        sb.append(this.deadline);
        sb.append(")");
        return sb.toString();
    }
}
