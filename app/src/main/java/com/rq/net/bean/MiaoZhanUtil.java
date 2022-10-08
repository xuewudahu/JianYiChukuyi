package com.rq.net.bean;

//import kotlin.jvm.internal.*;
import static okhttp3.internal.Util.UTF_8;

//import kotlin.*;
import com.rq.net.util.Base64;

import java.security.*;
import java.nio.charset.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¨\u0006\u0007" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/MiaoZhanUtil;", "", "()V", "doSign", "", "content", "secretKey", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class MiaoZhanUtil
{
    public static final MiaoZhanUtil INSTANCE;
    
    static {
        INSTANCE = new MiaoZhanUtil();
    }
    
    private MiaoZhanUtil() {
    }
    
    public final String doSign(final String s, String string) {
        //Intrinsics.checkParameterIsNotNull(s, "content");
        while (true) {
            if (string != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append(string);
                string = sb.toString();
                try {
                    final MessageDigest instance = MessageDigest.getInstance("MD5");
                    final Charset utf_8 = UTF_8;
                    //Intrinsics.checkExpressionValueIsNotNull(utf_8, "StandardCharsets.UTF_8");
                    if (string != null) {
                        final byte[] bytes = string.getBytes(utf_8);
                        //Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                        return Base64.encodeBase64String(instance.digest(bytes));
                    }
                    //throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    throw new RuntimeException("\u79d8\u94a5\u4e3a\u7a7a\uff0c\u975e\u6cd5\u8bbf\u95ee");
                }
                catch (NoSuchAlgorithmException ex) {}
                return "";
            }
            continue;
        }
    }
}
