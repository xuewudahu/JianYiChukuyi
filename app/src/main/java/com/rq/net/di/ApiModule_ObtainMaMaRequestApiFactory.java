package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainMaMaRequestApiFactory implements Factory<RequestApiMaMa>
{
    private final ApiModule module;
    
    public ApiModule_ObtainMaMaRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainMaMaRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainMaMaRequestApiFactory(apiModule);
    }
    
    public static RequestApiMaMa provideInstance(final ApiModule apiModule) {
        return proxyObtainMaMaRequestApi(apiModule);
    }
    
    public static RequestApiMaMa proxyObtainMaMaRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainMaMaRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiMaMa get() {
        return provideInstance(this.module);
    }
}
