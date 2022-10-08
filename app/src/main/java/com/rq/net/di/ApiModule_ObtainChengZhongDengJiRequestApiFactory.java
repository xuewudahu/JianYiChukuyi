package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainChengZhongDengJiRequestApiFactory implements Factory<RequestApiChengZhongDengJi>
{
    private final ApiModule module;
    
    public ApiModule_ObtainChengZhongDengJiRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainChengZhongDengJiRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainChengZhongDengJiRequestApiFactory(apiModule);
    }
    
    public static RequestApiChengZhongDengJi provideInstance(final ApiModule apiModule) {
        return proxyObtainChengZhongDengJiRequestApi(apiModule);
    }
    
    public static RequestApiChengZhongDengJi proxyObtainChengZhongDengJiRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainChengZhongDengJiRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiChengZhongDengJi get() {
        return provideInstance(this.module);
    }
}
