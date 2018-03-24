package com.henry.myrecipes

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.alibaba.fastjson.JSONObject
import com.google.gson.GsonBuilder
import com.henry.myrecipes.adapter.MainListAdapter
import com.henry.myrecipes.app.ApiService
import com.henry.myrecipes.app.InjectActivity
import com.henry.myrecipes.data.Category
import com.orhanobut.logger.Logger
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : InjectActivity() {

    @Inject
    lateinit var api: ApiService
    @Inject
    lateinit var adapter: MainListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_main_list.layoutManager = LinearLayoutManager(activityComponent.activityContext())
        rv_main_list.adapter = adapter

        api.cookCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<JSONObject> {
                    override fun onSubscribe(d: Disposable) {
                        getCompositeDisposable().add(d)
                    }

                    override fun onNext(jsonObject: JSONObject) {
                        Logger.e("Json" + jsonObject.toJSONString())
                        var category = GsonBuilder().create().fromJson(jsonObject.toJSONString(), Category::class.java)
//                        var category = jsonObject.toJavaObject(Category::class.java)
                        adapter.setData(category.result.childs!!)
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                    override fun onComplete() {

                    }
                })
    }
}
