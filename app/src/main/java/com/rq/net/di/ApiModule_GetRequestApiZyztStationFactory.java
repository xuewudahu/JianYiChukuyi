package com.rq.net.di;

import com.rq.net.*;
import com.rq.net.request.RequestApiZyzt;

import dagger.internal.*;

public final class ApiModule_GetRequestApiZyztStationFactory implements Factory<RequestApiZyzt>
{
    private final ApiModule module;
    
    public ApiModule_GetRequestApiZyztStationFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_GetRequestApiZyztStationFactory create(final ApiModule apiModule) {
        return new ApiModule_GetRequestApiZyztStationFactory(apiModule);
    }
    
    public static RequestApiZyzt provideInstance(final ApiModule apiModule) {
        return proxyGetRequestApiZyztStation(apiModule);
    }
    
    public static RequestApiZyzt proxyGetRequestApiZyztStation(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.getRequestApiZyztStation(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiZyzt get() {
        return provideInstance(this.module);
    }
}
