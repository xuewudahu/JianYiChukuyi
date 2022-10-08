package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainWjssoRequestApiFactory implements Factory<RequestApiLoginKDCS>
{
    private final ApiModule module;
    
    public ApiModule_ObtainWjssoRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainWjssoRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainWjssoRequestApiFactory(apiModule);
    }
    
    public static RequestApiLoginKDCS provideInstance(final ApiModule apiModule) {
        return proxyObtainWjssoRequestApi(apiModule);
    }
    
    public static RequestApiLoginKDCS proxyObtainWjssoRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainWjssoRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiLoginKDCS get() {
        return provideInstance(this.module);
    }
}
