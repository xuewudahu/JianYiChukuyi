package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainJinLinBaoRequestApiFactory implements Factory<RequestApiJinLinBao>
{
    private final ApiModule module;
    
    public ApiModule_ObtainJinLinBaoRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainJinLinBaoRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainJinLinBaoRequestApiFactory(apiModule);
    }
    
    public static RequestApiJinLinBao provideInstance(final ApiModule apiModule) {
        return proxyObtainJinLinBaoRequestApi(apiModule);
    }
    
    public static RequestApiJinLinBao proxyObtainJinLinBaoRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainJinLinBaoRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiJinLinBao get() {
        return provideInstance(this.module);
    }
}
