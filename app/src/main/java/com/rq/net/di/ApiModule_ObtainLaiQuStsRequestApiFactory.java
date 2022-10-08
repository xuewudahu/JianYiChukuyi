package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainLaiQuStsRequestApiFactory implements Factory<RequestApiLaiquSts>
{
    private final ApiModule module;
    
    public ApiModule_ObtainLaiQuStsRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainLaiQuStsRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainLaiQuStsRequestApiFactory(apiModule);
    }
    
    public static RequestApiLaiquSts provideInstance(final ApiModule apiModule) {
        return proxyObtainLaiQuStsRequestApi(apiModule);
    }
    
    public static RequestApiLaiquSts proxyObtainLaiQuStsRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainLaiQuStsRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiLaiquSts get() {
        return provideInstance(this.module);
    }
}
