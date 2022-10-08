package com.rq.net.bean;

import com.rq.net.util.Intrinsics;

import java.util.*;

public final class AuthorizationStationInfoResBean
{
    private final List<PostStationInfoBean> free;
    private final List<PostStationInfoBean> paid;
    private final Boolean three_free_mark;
    
    public AuthorizationStationInfoResBean(final Boolean three_free_mark, final List<PostStationInfoBean> free, final List<PostStationInfoBean> paid) {
        this.three_free_mark = three_free_mark;
        this.free = free;
        this.paid = paid;
    }
    
    public final Boolean component1() {
        return this.three_free_mark;
    }
    
    public final List<PostStationInfoBean> component2() {
        return this.free;
    }
    
    public final List<PostStationInfoBean> component3() {
        return this.paid;
    }
    
    public final AuthorizationStationInfoResBean copy(final Boolean b, final List<PostStationInfoBean> list, final List<PostStationInfoBean> list2) {
        return new AuthorizationStationInfoResBean(b, list, list2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof AuthorizationStationInfoResBean) {
                final AuthorizationStationInfoResBean authorizationStationInfoResBean = (AuthorizationStationInfoResBean)o;
                if (Intrinsics.areEqual(this.three_free_mark, authorizationStationInfoResBean.three_free_mark) && Intrinsics.areEqual(this.free, authorizationStationInfoResBean.free) && Intrinsics.areEqual(this.paid, authorizationStationInfoResBean.paid)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final List<PostStationInfoBean> getFree() {
        return this.free;
    }
    
    public final List<PostStationInfoBean> getPaid() {
        return this.paid;
    }
    
    public final Boolean getThree_free_mark() {
        return this.three_free_mark;
    }
    
    @Override
    public int hashCode() {
        final Boolean three_free_mark = this.three_free_mark;
        int hashCode = 0;
        int hashCode2;
        if (three_free_mark != null) {
            hashCode2 = three_free_mark.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final List<PostStationInfoBean> free = this.free;
        int hashCode3;
        if (free != null) {
            hashCode3 = free.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final List<PostStationInfoBean> paid = this.paid;
        if (paid != null) {
            hashCode = paid.hashCode();
        }
        return (hashCode2 * 31 + hashCode3) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AuthorizationStationInfoResBean(three_free_mark=");
        sb.append(this.three_free_mark);
        sb.append(", free=");
        sb.append(this.free);
        sb.append(", paid=");
        sb.append(this.paid);
        sb.append(")");
        return sb.toString();
    }
}
