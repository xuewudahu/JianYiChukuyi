package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainZtwjgatewayRequestApiFactory implements Factory<RequestApiKDCS>
{
    private final ApiModule module;
    
    public ApiModule_ObtainZtwjgatewayRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainZtwjgatewayRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainZtwjgatewayRequestApiFactory(apiModule);
    }
    
    public static RequestApiKDCS provideInstance(final ApiModule apiModule) {
        return proxyObtainZtwjgatewayRequestApi(apiModule);
    }
    
    public static RequestApiKDCS proxyObtainZtwjgatewayRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainZtwjgatewayRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiKDCS get() {
        return provideInstance(this.module);
    }
}
