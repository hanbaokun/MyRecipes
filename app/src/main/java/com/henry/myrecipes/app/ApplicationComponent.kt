package com.henry.myrecipes.app

import android.content.Context
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by hanbaokun on 2018/3/24.
 */
@ApiScope
@Component(modules = [ContextModule::class, ApiModule::class, NetWorkModule::class])
interface ApplicationComponent {
    fun api(): ApiService

    fun context(): Context
}