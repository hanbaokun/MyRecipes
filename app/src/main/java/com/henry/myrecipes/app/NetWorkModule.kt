package com.henry.myrecipes.app

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by hanbaokun on 2018/3/24.
 */
@Module
class NetWorkModule {

    @Provides
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
//                .addInterceptor(AuthInterceptor())
                //                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(HttpLoggingInterceptor(NetLogger()).setLevel(HttpLoggingInterceptor.Level.BODY))
//                .addInterceptor(proxyInterceptor)
                //            .addInterceptor(new ChuckInterceptor(MyApplication.getInstance().getApplicationContext()))
                .readTimeout(15, TimeUnit.SECONDS)
                .build()
    }
}