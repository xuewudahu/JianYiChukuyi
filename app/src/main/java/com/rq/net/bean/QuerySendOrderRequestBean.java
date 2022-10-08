package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

import com.rq.net.util.Intrinsics;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/QuerySendOrderRequestBean;", "", "linkQuery", "", "mailno", "", "(ILjava/lang/String;)V", "getLinkQuery", "()I", "getMailno", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class QuerySendOrderRequestBean
{
    private final int linkQuery;
    private final String mailno;
    
    public QuerySendOrderRequestBean(final int linkQuery, final String mailno) {
        //Intrinsics.checkParameterIsNotNull(mailno, "mailno");
        this.linkQuery = linkQuery;
        this.mailno = mailno;
    }
    
    public final int component1() {
        return this.linkQuery;
    }
    
    public final String component2() {
        return this.mailno;
    }
    
    public final QuerySendOrderRequestBean copy(final int n, final String s) {
        //Intrinsics.checkParameterIsNotNull(s, "mailno");
        return new QuerySendOrderRequestBean(n, s);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof QuerySendOrderRequestBean) {
                final QuerySendOrderRequestBean querySendOrderRequestBean = (QuerySendOrderRequestBean)o;
                if (this.linkQuery == querySendOrderRequestBean.linkQuery && Intrinsics.areEqual(this.mailno, querySendOrderRequestBean.mailno)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public final int getLinkQuery() {
        return this.linkQuery;
    }
    
    public final String getMailno() {
        return this.mailno;
    }
    
    @Override
    public int hashCode() {
        final int linkQuery = this.linkQuery;
        final String mailno = this.mailno;
        int hashCode;
        if (mailno != null) {
            hashCode = mailno.hashCode();
        }
        else {
            hashCode = 0;
        }
        return linkQuery * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("QuerySendOrderRequestBean(linkQuery=");
        sb.append(this.linkQuery);
        sb.append(", mailno=");
        sb.append(this.mailno);
        sb.append(")");
        return sb.toString();
    }
}
