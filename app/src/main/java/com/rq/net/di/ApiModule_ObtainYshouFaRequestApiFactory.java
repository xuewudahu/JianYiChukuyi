package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainYshouFaRequestApiFactory implements Factory<RequestApiYshouFa>
{
    private final ApiModule module;
    
    public ApiModule_ObtainYshouFaRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainYshouFaRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainYshouFaRequestApiFactory(apiModule);
    }
    
    public static RequestApiYshouFa provideInstance(final ApiModule apiModule) {
        return proxyObtainYshouFaRequestApi(apiModule);
    }
    
    public static RequestApiYshouFa proxyObtainYshouFaRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainYshouFaRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiYshouFa get() {
        return provideInstance(this.module);
    }
}
