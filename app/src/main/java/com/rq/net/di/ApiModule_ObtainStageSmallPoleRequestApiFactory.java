package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainStageSmallPoleRequestApiFactory implements Factory<RequestApiStageSmallPole>
{
    private final ApiModule module;
    
    public ApiModule_ObtainStageSmallPoleRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainStageSmallPoleRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainStageSmallPoleRequestApiFactory(apiModule);
    }
    
    public static RequestApiStageSmallPole provideInstance(final ApiModule apiModule) {
        return proxyObtainStageSmallPoleRequestApi(apiModule);
    }
    
    public static RequestApiStageSmallPole proxyObtainStageSmallPoleRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainStageSmallPoleRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiStageSmallPole get() {
        return provideInstance(this.module);
    }
}
