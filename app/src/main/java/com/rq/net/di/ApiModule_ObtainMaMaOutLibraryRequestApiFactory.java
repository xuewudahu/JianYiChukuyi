package com.rq.net.di;

import com.rq.net.request.*;
import dagger.internal.*;

public final class ApiModule_ObtainMaMaOutLibraryRequestApiFactory implements Factory<RequestApiMaMaOutLibrary>
{
    private final ApiModule module;
    
    public ApiModule_ObtainMaMaOutLibraryRequestApiFactory(final ApiModule module) {
        this.module = module;
    }
    
    public static ApiModule_ObtainMaMaOutLibraryRequestApiFactory create(final ApiModule apiModule) {
        return new ApiModule_ObtainMaMaOutLibraryRequestApiFactory(apiModule);
    }
    
    public static RequestApiMaMaOutLibrary provideInstance(final ApiModule apiModule) {
        return proxyObtainMaMaOutLibraryRequestApi(apiModule);
    }
    
    public static RequestApiMaMaOutLibrary proxyObtainMaMaOutLibraryRequestApi(final ApiModule apiModule) {
        return Preconditions.checkNotNull(apiModule.obtainMaMaOutLibraryRequestApi(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    @Override
    public RequestApiMaMaOutLibrary get() {
        return provideInstance(this.module);
    }
}
