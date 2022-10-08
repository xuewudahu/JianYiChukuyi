package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainApiPandaHarvestApiFactory implements Factory<RequestApiPandaHarvest>
{
    private final ApiModule module;
    
    public ApiModule_ObtainApiPandaHarvestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainApiPandaHarvestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainApiPandaHarvestApiFactory(apiModule);
    }
    
    public static RequestApiPandaHarvest provideInstance(final ApiModule apiModule) {
        return proxyObtainApiPandaHarvestApi(apiModule);
    }
    
    public static RequestApiPandaHarvest proxyObtainApiPandaHarvestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainApiPandaHarvestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiPandaHarvest get() {
        return provideInstance(this.module);
    }
}
