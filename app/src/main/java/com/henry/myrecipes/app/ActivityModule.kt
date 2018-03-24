package com.henry.myrecipes.app

import android.app.Activity
import com.henry.myrecipes.adapter.MainListAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by hanbaokun on 2018/3/24.
 */
@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    internal fun provideActivity(): Activity {
        return activity
    }

    @ActivityScope
    @Provides
    internal fun provideMainAdapter(): MainListAdapter {
        return MainListAdapter(activity)
    }
}