package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainJuShuiTanRequestApiFactory implements Factory<RequestApiJuShuiTan>
{
    private final ApiModule module;
    
    public ApiModule_ObtainJuShuiTanRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainJuShuiTanRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainJuShuiTanRequestApiFactory(apiModule);
    }
    
    public static RequestApiJuShuiTan provideInstance(final ApiModule apiModule) {
        return proxyObtainJuShuiTanRequestApi(apiModule);
    }
    
    public static RequestApiJuShuiTan proxyObtainJuShuiTanRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainJuShuiTanRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiJuShuiTan get() {
        return provideInstance(this.module);
    }
}
