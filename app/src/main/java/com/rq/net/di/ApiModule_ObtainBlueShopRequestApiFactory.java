package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainBlueShopRequestApiFactory implements Factory<RequestApiBlueShop>
{
    private final ApiModule module;
    
    public ApiModule_ObtainBlueShopRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainBlueShopRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainBlueShopRequestApiFactory(apiModule);
    }
    
    public static RequestApiBlueShop provideInstance(final ApiModule apiModule) {
        return proxyObtainBlueShopRequestApi(apiModule);
    }
    
    public static RequestApiBlueShop proxyObtainBlueShopRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainBlueShopRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiBlueShop get() {
        return provideInstance(this.module);
    }
}
