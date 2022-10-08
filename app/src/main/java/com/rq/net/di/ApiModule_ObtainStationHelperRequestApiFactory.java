package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainStationHelperRequestApiFactory implements Factory<RequestApiStationHelper>
{
    private final ApiModule module;
    
    public ApiModule_ObtainStationHelperRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainStationHelperRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainStationHelperRequestApiFactory(apiModule);
    }
    
    public static RequestApiStationHelper provideInstance(final ApiModule apiModule) {
        return proxyObtainStationHelperRequestApi(apiModule);
    }
    
    public static RequestApiStationHelper proxyObtainStationHelperRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainStationHelperRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiStationHelper get() {
        return provideInstance(this.module);
    }
}
