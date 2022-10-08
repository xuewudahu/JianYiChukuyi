package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainFcboxRequestApiFactory implements Factory<RequestApiFcbox>
{
    private final ApiModule module;
    
    public ApiModule_ObtainFcboxRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainFcboxRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainFcboxRequestApiFactory(apiModule);
    }
    
    public static RequestApiFcbox provideInstance(final ApiModule apiModule) {
        return proxyObtainFcboxRequestApi(apiModule);
    }
    
    public static RequestApiFcbox proxyObtainFcboxRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainFcboxRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiFcbox get() {
        return provideInstance(this.module);
    }
}
