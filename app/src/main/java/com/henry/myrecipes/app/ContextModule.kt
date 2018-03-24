package com.henry.myrecipes.app

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by hanbaokun on 2018/3/24.
 */
@Module
class ContextModule(context: Context) {

    private var mContext: Context

    init {
        this.mContext = context.applicationContext
    }

    @Provides
    fun context(): Context {
        return mContext
    }
}