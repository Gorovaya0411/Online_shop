package com.firecode.onlineshop.data.repository

import android.util.Log
import com.firecode.onlineshop.data.service.OnlineShopApiService
import com.firecode.onlineshop.data.service.ProfileApiService
import com.firecode.onlineshop.model.*
import com.squareup.okhttp.MediaType
import com.squareup.okhttp.RequestBody
import com.squareup.okhttp.ResponseBody
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CharactersMainRepository @Inject constructor(
    private val apiService: OnlineShopApiService,
    private val profileService: ProfileApiService
) {
    private var increment: Int = 1

    fun getToken(email: String, password: String, callback: (String) -> Unit) {
        val user = RequestBodyLogin()
        user.email = email
        user.password = password
        user.device_name = "Iphone"
        profileService.getToken(
            user
        ).enqueue(object :
            Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>?
            ) {
                callback.invoke(response?.body().toString())
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable?) {
                Log.e("error", t.toString())
            }
        })
    }

    fun setToken(email: String, password: String, callback: (String) -> Unit) {
        val user = RequestBodyRegistration(
            RequestBody.create(MediaType.parse("application/json"), email),
            RequestBody.create(MediaType.parse("application/json"), password),
            RequestBody.create(MediaType.parse("application/json"), password)
        )

        profileService.setToken(
            user
        ).enqueue(object :
            Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>?) {
                if (response != null) {
                    callback.invoke(response.body()?.string().toString())
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable?) {
                Log.e("error", t.toString())
            }
        })
    }

    fun swipeRefreshCatalog(): Observable<DataCatalog> {
        increment = 1
        return apiService.getCategories(page = increment).flatMap { it ->

            return@flatMap Observable.just(it)
        }.subscribeOn(Schedulers.io())
    }

    fun getMoreItemsCatalog(): Observable<DataCatalog> {
        increment += 1

        return apiService.getCategories(page = increment).flatMap { data ->
            return@flatMap Observable.just(data)
        }.subscribeOn(Schedulers.io())
    }

    fun swipeRefreshProduct(): Observable<DataProduct> {
        increment = 1
        return apiService.getProducts(page = increment).flatMap { it ->

            return@flatMap Observable.just(it)
        }.subscribeOn(Schedulers.io())
    }

    fun getMoreItemsProduct(): Observable<DataProduct> {
        increment += 1

        return apiService.getProducts(page = increment).flatMap { data ->
            return@flatMap Observable.just(data)
        }.subscribeOn(Schedulers.io())
    }
}