package com.henry.myrecipes.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by hanbaokun on 2018/3/24.
 */
abstract class InjectActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent
    private lateinit var compositeDisposable: CompositeDisposable

    private val INJECT_METHOD = "inject"

    fun getCompositeDisposable(): CompositeDisposable {
        if (null == compositeDisposable) {
            compositeDisposable = CompositeDisposable()
        }
        return compositeDisposable
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(MyApplication.current.mComponent)
                .activityModule(ActivityModule(this))
                .build()
//        activityComponent.inject(this)
        try {
            ActivityComponent::class.java.getMethod(INJECT_METHOD, this::class.java).invoke(activityComponent, this)
        } catch (e: Exception) {
            //            throw new RuntimeException(this.getClass().getSimpleName() + ":inject error", e);
        }

    }

    override fun onPause() {
        super.onPause()
        compositeDisposable?.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }
}