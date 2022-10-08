package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainYundaNewKDCSRequestApiFactory implements Factory<RequestApiYundaNewKDCS>
{
    private final ApiModule module;
    
    public ApiModule_ObtainYundaNewKDCSRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainYundaNewKDCSRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainYundaNewKDCSRequestApiFactory(apiModule);
    }
    
    public static RequestApiYundaNewKDCS provideInstance(final ApiModule apiModule) {
        return proxyObtainYundaNewKDCSRequestApi(apiModule);
    }
    
    public static RequestApiYundaNewKDCS proxyObtainYundaNewKDCSRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainYundaNewKDCSRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiYundaNewKDCS get() {
        return provideInstance(this.module);
    }
}
