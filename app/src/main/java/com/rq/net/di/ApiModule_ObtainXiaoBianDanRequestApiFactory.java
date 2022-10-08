package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainXiaoBianDanRequestApiFactory implements Factory<RequestApiXbdUploadPicture>
{
    private final ApiModule module;
    
    public ApiModule_ObtainXiaoBianDanRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainXiaoBianDanRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainXiaoBianDanRequestApiFactory(apiModule);
    }
    
    public static RequestApiXbdUploadPicture provideInstance(final ApiModule apiModule) {
        return proxyObtainXiaoBianDanRequestApi(apiModule);
    }
    
    public static RequestApiXbdUploadPicture proxyObtainXiaoBianDanRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainXiaoBianDanRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiXbdUploadPicture get() {
        return provideInstance(this.module);
    }
}
