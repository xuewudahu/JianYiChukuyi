package com.rq.net.bean;

//import kotlin.*;
//import kotlin.jvm.internal.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/GuoGuoYiZhan;", "", "()V", "apiId", "", "getApiId", "()Ljava/lang/String;", "setApiId", "(Ljava/lang/String;)V", "apiKey", "getApiKey", "setApiKey", "device", "getDevice", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class GuoGuoYiZhan
{
    public static final GuoGuoYiZhan INSTANCE;
    private static String apiId;
    private static String apiKey;
    private static final String device = "6";
    
    static {
        INSTANCE = new GuoGuoYiZhan();
        GuoGuoYiZhan.apiId = "DSQQOdwT";
        GuoGuoYiZhan.apiKey = "hQsoGYxdHxIpLKO7Jy5ZOFSTs8bV8FgO";
    }
    
    private GuoGuoYiZhan() {
    }
    
    public final String getApiId() {
        return GuoGuoYiZhan.apiId;
    }
    
    public final String getApiKey() {
        return GuoGuoYiZhan.apiKey;
    }
    
    public final String getDevice() {
        return GuoGuoYiZhan.device;
    }
    
    public final void setApiId(final String apiId) {
        //Intrinsics.checkParameterIsNotNull(apiId, "<set-?>");
        GuoGuoYiZhan.apiId = apiId;
    }
    
    public final void setApiKey(final String apiKey) {
        //Intrinsics.checkParameterIsNotNull(apiKey, "<set-?>");
        GuoGuoYiZhan.apiKey = apiKey;
    }
}
