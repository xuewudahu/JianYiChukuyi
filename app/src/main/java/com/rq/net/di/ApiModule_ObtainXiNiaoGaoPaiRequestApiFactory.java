package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainXiNiaoGaoPaiRequestApiFactory implements Factory<RequestApiXiNiaoGaoPai>
{
    private final ApiModule module;
    
    public ApiModule_ObtainXiNiaoGaoPaiRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainXiNiaoGaoPaiRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainXiNiaoGaoPaiRequestApiFactory(apiModule);
    }
    
    public static RequestApiXiNiaoGaoPai provideInstance(final ApiModule apiModule) {
        return proxyObtainXiNiaoGaoPaiRequestApi(apiModule);
    }
    
    public static RequestApiXiNiaoGaoPai proxyObtainXiNiaoGaoPaiRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainXiNiaoGaoPaiRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiXiNiaoGaoPai get() {
        return provideInstance(this.module);
    }
}
