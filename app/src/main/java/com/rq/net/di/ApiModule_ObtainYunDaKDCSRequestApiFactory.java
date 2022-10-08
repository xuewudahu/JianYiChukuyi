package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainYunDaKDCSRequestApiFactory implements Factory<RequestApiYunDaKDCS>
{
    private final ApiModule module;
    
    public ApiModule_ObtainYunDaKDCSRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainYunDaKDCSRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainYunDaKDCSRequestApiFactory(apiModule);
    }
    
    public static RequestApiYunDaKDCS provideInstance(final ApiModule apiModule) {
        return proxyObtainYunDaKDCSRequestApi(apiModule);
    }
    
    public static RequestApiYunDaKDCS proxyObtainYunDaKDCSRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainYunDaKDCSRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiYunDaKDCS get() {
        return provideInstance(this.module);
    }
}
