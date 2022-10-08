package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainAdvertRequestApiFactory implements Factory<RequestApiAdvert>
{
    private final ApiModule module;
    
    public ApiModule_ObtainAdvertRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainAdvertRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainAdvertRequestApiFactory(apiModule);
    }
    
    public static RequestApiAdvert provideInstance(final ApiModule apiModule) {
        return proxyObtainAdvertRequestApi(apiModule);
    }
    
    public static RequestApiAdvert proxyObtainAdvertRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainAdvertRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiAdvert get() {
        return provideInstance(this.module);
    }
}
