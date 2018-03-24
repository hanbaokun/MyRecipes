package com.henry.myrecipes.app

import com.orhanobut.logger.Logger
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hanbaokun on 2018/3/24.
 */

class NetLogger : HttpLoggingInterceptor.Logger {

    override fun log(message: String) {
        if (isJsonArray(message) || isJsonObject(message)) {
            Logger.json(message)
        } else if (isXml(message)) {
            Logger.xml(message)
        } else {
            HttpLoggingInterceptor.Logger.DEFAULT.log(message)
        }
    }

    private fun isJsonArray(input: String): Boolean {
        var isJsonArray = true
        try {
            JSONArray(input)
        } catch (e: JSONException) {
            isJsonArray = false
        }

        return isJsonArray
    }

    private fun isJsonObject(input: String): Boolean {
        var isJsonObject = true
        try {
            JSONObject(input)
        } catch (e: JSONException) {
            isJsonObject = false
        }

        return isJsonObject
    }

    private fun isXml(input: String): Boolean {
        return false
    }

}