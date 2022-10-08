package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainLaiquRequestApiFactory implements Factory<RequestApiLaiqu>
{
    private final ApiModule module;
    
    public ApiModule_ObtainLaiquRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainLaiquRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainLaiquRequestApiFactory(apiModule);
    }
    
    public static RequestApiLaiqu provideInstance(final ApiModule apiModule) {
        return proxyObtainLaiquRequestApi(apiModule);
    }
    
    public static RequestApiLaiqu proxyObtainLaiquRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainLaiquRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiLaiqu get() {
        return provideInstance(this.module);
    }
}
