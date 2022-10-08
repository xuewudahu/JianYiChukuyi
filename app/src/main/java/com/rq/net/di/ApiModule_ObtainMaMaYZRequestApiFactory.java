package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainMaMaYZRequestApiFactory implements Factory<RequestApiMaMaYZ>
{
    private final ApiModule module;
    
    public ApiModule_ObtainMaMaYZRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainMaMaYZRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainMaMaYZRequestApiFactory(apiModule);
    }
    
    public static RequestApiMaMaYZ provideInstance(final ApiModule apiModule) {
        return proxyObtainMaMaYZRequestApi(apiModule);
    }
    
    public static RequestApiMaMaYZ proxyObtainMaMaYZRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainMaMaYZRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiMaMaYZ get() {
        return provideInstance(this.module);
    }
}
