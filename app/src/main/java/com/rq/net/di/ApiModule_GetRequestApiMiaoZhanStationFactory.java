package com.rq.net.di;

import com.rq.net.request.RequestApiMiaoZhan;
import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_GetRequestApiMiaoZhanStationFactory implements Factory<RequestApiMiaoZhan>
{
    private final ApiModule module;
    
    public ApiModule_GetRequestApiMiaoZhanStationFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_GetRequestApiMiaoZhanStationFactory create(final ApiModule apiModule) {
        return new ApiModule_GetRequestApiMiaoZhanStationFactory(apiModule);
    }
    
    public static RequestApiMiaoZhan provideInstance(final ApiModule apiModule) {
        return proxyGetRequestApiMiaoZhanStation(apiModule);
    }
    
    public static RequestApiMiaoZhan proxyGetRequestApiMiaoZhanStation(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.getRequestApiMiaoZhanStation(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiMiaoZhan get() {
        return provideInstance(this.module);
    }
}
