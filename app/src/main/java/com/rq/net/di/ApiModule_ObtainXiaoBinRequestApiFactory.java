package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainXiaoBinRequestApiFactory implements Factory<RequestApiXiaoBin>
{
    private final ApiModule module;
    
    public ApiModule_ObtainXiaoBinRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainXiaoBinRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainXiaoBinRequestApiFactory(apiModule);
    }
    
    public static RequestApiXiaoBin provideInstance(final ApiModule apiModule) {
        return proxyObtainXiaoBinRequestApi(apiModule);
    }
    
    public static RequestApiXiaoBin proxyObtainXiaoBinRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainXiaoBinRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiXiaoBin get() {
        return provideInstance(this.module);
    }
}
