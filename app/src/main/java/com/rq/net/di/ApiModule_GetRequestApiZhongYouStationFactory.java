package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_GetRequestApiZhongYouStationFactory implements Factory<RequestApiZhongYouStation>
{
    private final ApiModule module;
    
    public ApiModule_GetRequestApiZhongYouStationFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_GetRequestApiZhongYouStationFactory create(final ApiModule apiModule) {
        return new ApiModule_GetRequestApiZhongYouStationFactory(apiModule);
    }
    
    public static RequestApiZhongYouStation provideInstance(final ApiModule apiModule) {
        return proxyGetRequestApiZhongYouStation(apiModule);
    }
    
    public static RequestApiZhongYouStation proxyGetRequestApiZhongYouStation(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.getRequestApiZhongYouStation(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiZhongYouStation get() {
        return provideInstance(this.module);
    }
}
