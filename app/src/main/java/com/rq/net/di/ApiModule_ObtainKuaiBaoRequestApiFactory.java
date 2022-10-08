package com.rq.net.di;

import com.rq.net.request.RequestApiKuaibao;

import dagger.internal.*;

public final class ApiModule_ObtainKuaiBaoRequestApiFactory implements Factory<RequestApiKuaibao>
{
    private final ApiModule module;
    
    public ApiModule_ObtainKuaiBaoRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainKuaiBaoRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainKuaiBaoRequestApiFactory(apiModule);
    }
    
    public static RequestApiKuaibao provideInstance(final ApiModule apiModule) {
        return proxyObtainKuaiBaoRequestApi(apiModule);
    }
    
    public static RequestApiKuaibao proxyObtainKuaiBaoRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainKuaiBaoRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiKuaibao get() {
        return provideInstance(this.module);
    }
}
