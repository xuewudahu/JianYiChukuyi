package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_GetRequestApiSuDiYiFactory implements Factory<RequestApiSuDiYi>
{
    private final ApiModule module;
    
    public ApiModule_GetRequestApiSuDiYiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_GetRequestApiSuDiYiFactory create(final ApiModule apiModule) {
        return new ApiModule_GetRequestApiSuDiYiFactory(apiModule);
    }
    
    public static RequestApiSuDiYi provideInstance(final ApiModule apiModule) {
        return proxyGetRequestApiSuDiYi(apiModule);
    }
    
    public static RequestApiSuDiYi proxyGetRequestApiSuDiYi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.getRequestApiSuDiYi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiSuDiYi get() {
        return provideInstance(this.module);
    }
}
