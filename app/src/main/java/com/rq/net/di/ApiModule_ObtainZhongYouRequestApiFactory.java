package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainZhongYouRequestApiFactory implements Factory<RequestApiZhongYouKT>
{
    private final ApiModule module;
    
    public ApiModule_ObtainZhongYouRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainZhongYouRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainZhongYouRequestApiFactory(apiModule);
    }
    
    public static RequestApiZhongYouKT provideInstance(final ApiModule apiModule) {
        return proxyObtainZhongYouRequestApi(apiModule);
    }
    
    public static RequestApiZhongYouKT proxyObtainZhongYouRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainZhongYouRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiZhongYouKT get() {
        return provideInstance(this.module);
    }
}
