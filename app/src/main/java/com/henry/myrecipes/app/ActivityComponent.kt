package com.henry.myrecipes.app

import android.app.Activity
import com.henry.myrecipes.MainActivity
import dagger.Component

/**
 * Created by hanbaokun on 2018/3/24.
 */

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: InjectActivity)
    fun inject(activity: MainActivity)

    fun activityContext(): Activity

}
