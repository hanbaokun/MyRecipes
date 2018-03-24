package com.henry.myrecipes.app

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * Created by hanbaokun on 2018/3/24.
 */
class MyApplication : Application() {
    private lateinit var component: ApplicationComponent
    val mComponent get() = component

    override fun onCreate() {
        super.onCreate()
        app = this
        component = DaggerApplicationComponent.builder()
                .contextModule(ContextModule(this))
                .build()
        initLogger()
    }

    private fun initLogger() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .tag("logger")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build()

        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return true
            }
        })
    }

    companion object {
        private lateinit var app: MyApplication
        val current get() = app
    }
}