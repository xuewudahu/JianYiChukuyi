package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainBaoGuoVipRequestApiFactory implements Factory<RequestApiBaoGuoVip>
{
    private final ApiModule module;
    
    public ApiModule_ObtainBaoGuoVipRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainBaoGuoVipRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainBaoGuoVipRequestApiFactory(apiModule);
    }
    
    public static RequestApiBaoGuoVip provideInstance(final ApiModule apiModule) {
        return proxyObtainBaoGuoVipRequestApi(apiModule);
    }
    
    public static RequestApiBaoGuoVip proxyObtainBaoGuoVipRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainBaoGuoVipRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiBaoGuoVip get() {
        return provideInstance(this.module);
    }
}
