package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainHylRequestApiFactory implements Factory<RequestApiHyl>
{
    private final ApiModule module;
    
    public ApiModule_ObtainHylRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainHylRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainHylRequestApiFactory(apiModule);
    }
    
    public static RequestApiHyl provideInstance(final ApiModule apiModule) {
        return proxyObtainHylRequestApi(apiModule);
    }
    
    public static RequestApiHyl proxyObtainHylRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainHylRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiHyl get() {
        return provideInstance(this.module);
    }
}
