package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainFenShiShengHuoRequestApiFactory implements Factory<RequestApiFssh>
{
    private final ApiModule module;
    
    public ApiModule_ObtainFenShiShengHuoRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainFenShiShengHuoRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainFenShiShengHuoRequestApiFactory(apiModule);
    }
    
    public static RequestApiFssh provideInstance(final ApiModule apiModule) {
        return proxyObtainFenShiShengHuoRequestApi(apiModule);
    }
    
    public static RequestApiFssh proxyObtainFenShiShengHuoRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainFenShiShengHuoRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiFssh get() {
        return provideInstance(this.module);
    }
}
