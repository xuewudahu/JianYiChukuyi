package com.rq.net.di;


import com.rq.net.request.RequestApiPinDuoDuo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApiModule_GetRequestApiDuoDuoStationFactory implements Factory{
    private final ApiModule module;

    public ApiModule_GetRequestApiDuoDuoStationFactory(ApiModule var1) {
        this.module = var1;
    }

    public static ApiModule_GetRequestApiDuoDuoStationFactory create(ApiModule var0) {
        return new ApiModule_GetRequestApiDuoDuoStationFactory(var0);
    }

    public static RequestApiPinDuoDuo provideInstance(ApiModule var0) {
        return proxyGetRequestApiDuoDuoStation(var0);
    }

    public static RequestApiPinDuoDuo proxyGetRequestApiDuoDuoStation(ApiModule var0) {
        return (RequestApiPinDuoDuo)Preconditions.checkNotNull(var0.getRequestApiDuoDuoStation(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public RequestApiPinDuoDuo get() {
        return provideInstance(this.module);
    }
}
