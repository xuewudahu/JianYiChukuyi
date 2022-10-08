package com.rq.net.bean;

//import kotlin.*;
import com.rq.net.util.Intrinsics;

import java.util.*;
//import kotlin.jvm.internal.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/PackageDataBean;", "", "package_list", "Ljava/util/ArrayList;", "Lcom/yunpan/cobaaidlservice/bean/PackageBean;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getPackage_list", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class PackageDataBean
{
    private final ArrayList<PackageBean> package_list;
    
    public PackageDataBean(final ArrayList<PackageBean> package_list) {
        //Intrinsics.checkParameterIsNotNull(package_list, "package_list");
        this.package_list = package_list;
    }
    
    public final ArrayList<PackageBean> component1() {
        return this.package_list;
    }
    
    public final PackageDataBean copy(final ArrayList<PackageBean> list) {
        //Intrinsics.checkParameterIsNotNull(list, "package_list");
        return new PackageDataBean(list);
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof PackageDataBean && Intrinsics.areEqual(this.package_list, ((PackageDataBean)o).package_list));
    }
    
    public final ArrayList<PackageBean> getPackage_list() {
        return this.package_list;
    }
    
    @Override
    public int hashCode() {
        final ArrayList<PackageBean> package_list = this.package_list;
        if (package_list != null) {
            return package_list.hashCode();
        }
        return 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PackageDataBean(package_list=");
        sb.append(this.package_list);
        sb.append(")");
        return sb.toString();
    }
}
