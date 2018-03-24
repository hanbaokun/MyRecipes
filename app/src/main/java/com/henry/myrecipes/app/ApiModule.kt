package com.henry.myrecipes.app

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.fastjson.FastJsonConverterFactory
import javax.inject.Named

/**
 * Created by hanbaokun on 2018/3/24.
 */
@Module(includes = [NetWorkModule::class])
class ApiModule {

    @Provides
    fun api(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun retrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://apicloud.mob.com/")
                .client(client)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}