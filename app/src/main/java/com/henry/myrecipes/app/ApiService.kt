package com.henry.myrecipes.app

import com.alibaba.fastjson.JSONObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by hanbaokun on 2018/3/24.
 */
interface ApiService {
    @GET("/v1/cook/category/query?key=110dd0913cd78")
    fun cookCategory(): Observable<JSONObject>
}