package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainJiTuRequestApiFactory implements Factory<RequestApiJiTu>
{
    private final ApiModule module;
    
    public ApiModule_ObtainJiTuRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainJiTuRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainJiTuRequestApiFactory(apiModule);
    }
    
    public static RequestApiJiTu provideInstance(final ApiModule apiModule) {
        return proxyObtainJiTuRequestApi(apiModule);
    }
    
    public static RequestApiJiTu proxyObtainJiTuRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainJiTuRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiJiTu get() {
        return provideInstance(this.module);
    }
}
