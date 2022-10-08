package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainRequestApiFactory implements Factory<RequestApi>
{
    private final ApiModule module;
    
    public ApiModule_ObtainRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainRequestApiFactory(apiModule);
    }
    
    public static RequestApi provideInstance(final ApiModule apiModule) {
        return proxyObtainRequestApi(apiModule);
    }
    
    public static RequestApi proxyObtainRequestApi(final ApiModule apiModule) {
        return (RequestApi)apiModule.obtainRequestApi();//Preconditions.checkNotNull(apiModule.obtainRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApi get() {
        return provideInstance(this.module);
    }
}
