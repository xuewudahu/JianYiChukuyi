package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainXingHuoRequestApiFactory implements Factory<RequestApiXingHuo>
{
    private final ApiModule module;
    
    public ApiModule_ObtainXingHuoRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainXingHuoRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainXingHuoRequestApiFactory(apiModule);
    }
    
    public static RequestApiXingHuo provideInstance(final ApiModule apiModule) {
        return proxyObtainXingHuoRequestApi(apiModule);
    }
    
    public static RequestApiXingHuo proxyObtainXingHuoRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainXingHuoRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiXingHuo get() {
        return provideInstance(this.module);
    }
}
