package com.timelysoft.kainarapp.cachingRetrofit

import com.timelysoft.kainarapp.service.AppPreferences
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        val cacheControl = CacheControl.Builder().maxAge(5, TimeUnit.SECONDS)
            .build()

        return response.newBuilder()
            .removeHeader(AppPreferences.HEADER_CACHE_CONTROL)
            .header(AppPreferences.HEADER_CACHE_CONTROL, cacheControl.toString())
            .build()
    }

}