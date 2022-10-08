package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainJoyFinderRequestApiFactory implements Factory<RequestApiJoyFinder>
{
    private final ApiModule module;
    
    public ApiModule_ObtainJoyFinderRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainJoyFinderRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainJoyFinderRequestApiFactory(apiModule);
    }
    
    public static RequestApiJoyFinder provideInstance(final ApiModule apiModule) {
        return proxyObtainJoyFinderRequestApi(apiModule);
    }
    
    public static RequestApiJoyFinder proxyObtainJoyFinderRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainJoyFinderRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiJoyFinder get() {
        return provideInstance(this.module);
    }
}
