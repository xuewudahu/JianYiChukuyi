package com.rq.net.util;

//import kotlin.*;
import java.util.*;
//import kotlin.jvm.internal.*;
//import kotlin.reflect.full.*;
//import kotlin.jvm.functions.*;
//import kotlin.collections.*;


public final class JinLinBaoSign {
    public final String get_sign(final Object var1) {
        ////Intrinsics.checkParameterIsNotNull(var1, "any");
        /*String var3 = CollectionsKt.joinToString$default((Iterable)KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(var1.getClass())), (CharSequence)"&", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)(new Function1() {
            // $FF: synthetic method
            // $FF: bridge method
            public Object invoke(Object var1x) {
                return this.invoke((KProperty1)var1x);
            }

            public final String invoke(KProperty1 var1x) {
                //Intrinsics.checkParameterIsNotNull(var1x, "it");
                StringBuilder var2 = new StringBuilder();
                var2.append(var1x.getName());
                var2.append('=');
                var2.append(var1x.getGetter().call(new Object[]{var1}));
                return var2.toString();
            }
        }), 30, (Object)null);*/
        StringBuilder var2 = new StringBuilder();
        //var2.append(var3);
        var2.append("&secret=SFPD0afjaLN?SFl0ad$?*&+=(*#21#$K");
        return var2.toString();
    }
}


