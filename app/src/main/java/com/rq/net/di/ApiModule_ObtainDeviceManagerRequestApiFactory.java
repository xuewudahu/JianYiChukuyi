package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainDeviceManagerRequestApiFactory implements Factory<RequestApiDeviceManager>
{
    private final ApiModule module;
    
    public ApiModule_ObtainDeviceManagerRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainDeviceManagerRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainDeviceManagerRequestApiFactory(apiModule);
    }
    
    public static RequestApiDeviceManager provideInstance(final ApiModule apiModule) {
        return proxyObtainDeviceManagerRequestApi(apiModule);
    }
    
    public static RequestApiDeviceManager proxyObtainDeviceManagerRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainDeviceManagerRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiDeviceManager get() {
        return provideInstance(this.module);
    }
}
