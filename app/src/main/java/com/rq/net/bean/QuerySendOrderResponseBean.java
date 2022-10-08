package com.rq.net.bean;

//import kotlin.*;
import com.rq.net.util.Intrinsics;

import java.util.*;
//import kotlin.jvm.internal.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J\t\u0010$\u001a\u00020%H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R%\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006&" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/QuerySendOrderResponseBean;", "", "code", "", "currentPage", "data", "Ljava/util/ArrayList;", "Lcom/yunpan/cobaaidlservice/bean/QuerySendOrderDataResponseBean;", "Lkotlin/collections/ArrayList;", "hasNextPage", "", "msg", "pageSize", "total", "(IILjava/util/ArrayList;ZIII)V", "getCode", "()I", "getCurrentPage", "getData", "()Ljava/util/ArrayList;", "getHasNextPage", "()Z", "getMsg", "getPageSize", "getTotal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class QuerySendOrderResponseBean
{
    private final int code;
    private final int currentPage;
    private final ArrayList<QuerySendOrderDataResponseBean> data;
    private final boolean hasNextPage;
    private final int msg;
    private final int pageSize;
    private final int total;
    
    public QuerySendOrderResponseBean(final int code, final int currentPage, final ArrayList<QuerySendOrderDataResponseBean> data, final boolean hasNextPage, final int msg, final int pageSize, final int total) {
        //Intrinsics.checkParameterIsNotNull(data, "data");
        this.code = code;
        this.currentPage = currentPage;
        this.data = data;
        this.hasNextPage = hasNextPage;
        this.msg = msg;
        this.pageSize = pageSize;
        this.total = total;
    }
    
    public final int component1() {
        return this.code;
    }
    
    public final int component2() {
        return this.currentPage;
    }
    
    public final ArrayList<QuerySendOrderDataResponseBean> component3() {
        return this.data;
    }
    
    public final boolean component4() {
        return this.hasNextPage;
    }
    
    public final int component5() {
        return this.msg;
    }
    
    public final int component6() {
        return this.pageSize;
    }
    
    public final int component7() {
        return this.total;
    }
    
    public final QuerySendOrderResponseBean copy(final int n, final int n2, final ArrayList<QuerySendOrderDataResponseBean> list, final boolean b, final int n3, final int n4, final int n5) {
        //Intrinsics.checkParameterIsNotNull(list, "data");
        return new QuerySendOrderResponseBean(n, n2, list, b, n3, n4, n5);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof QuerySendOrderResponseBean) {
                final QuerySendOrderResponseBean querySendOrderResponseBean = (QuerySendOrderResponseBean)o;
                if (this.code == querySendOrderResponseBean.code && this.currentPage == querySendOrderResponseBean.currentPage && Intrinsics.areEqual(this.data, querySendOrderResponseBean.data) && this.hasNextPage == querySendOrderResponseBean.hasNextPage && this.msg == querySendOrderResponseBean.msg && this.pageSize == querySendOrderResponseBean.pageSize && this.total == querySendOrderResponseBean.total) {
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
    
    public final int getCurrentPage() {
        return this.currentPage;
    }
    
    public final ArrayList<QuerySendOrderDataResponseBean> getData() {
        return this.data;
    }
    
    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }
    
    public final int getMsg() {
        return this.msg;
    }
    
    public final int getPageSize() {
        return this.pageSize;
    }
    
    public final int getTotal() {
        return this.total;
    }
    
    @Override
    public int hashCode() {
        return 0;
        //throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("QuerySendOrderResponseBean(code=");
        sb.append(this.code);
        sb.append(", currentPage=");
        sb.append(this.currentPage);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", hasNextPage=");
        sb.append(this.hasNextPage);
        sb.append(", msg=");
        sb.append(this.msg);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(", total=");
        sb.append(this.total);
        sb.append(")");
        return sb.toString();
    }
}
