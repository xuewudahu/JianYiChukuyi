package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainSplaiquRequestApiFactory implements Factory<RequestApiSplaiqu>
{
    private final ApiModule module;
    
    public ApiModule_ObtainSplaiquRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainSplaiquRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainSplaiquRequestApiFactory(apiModule);
    }
    
    public static RequestApiSplaiqu provideInstance(final ApiModule apiModule) {
        return proxyObtainSplaiquRequestApi(apiModule);
    }
    
    public static RequestApiSplaiqu proxyObtainSplaiquRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainSplaiquRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiSplaiqu get() {
        return provideInstance(this.module);
    }
}
