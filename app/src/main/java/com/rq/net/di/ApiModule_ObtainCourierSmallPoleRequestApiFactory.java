package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainCourierSmallPoleRequestApiFactory implements Factory<RequestApiCourSmallPole>
{
    private final ApiModule module;
    
    public ApiModule_ObtainCourierSmallPoleRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainCourierSmallPoleRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainCourierSmallPoleRequestApiFactory(apiModule);
    }
    
    public static RequestApiCourSmallPole provideInstance(final ApiModule apiModule) {
        return proxyObtainCourierSmallPoleRequestApi(apiModule);
    }
    
    public static RequestApiCourSmallPole proxyObtainCourierSmallPoleRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainCourierSmallPoleRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiCourSmallPole get() {
        return provideInstance(this.module);
    }
}
