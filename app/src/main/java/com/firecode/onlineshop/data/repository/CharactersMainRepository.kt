package com.firecode.onlineshop.data.repository

import android.util.Log
import com.firecode.onlineshop.data.service.OnlineShopApiService
import com.firecode.onlineshop.model.*
import com.firecode.onlineshop.ui.main.MainActivity
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import rx.Single.just
import javax.inject.Inject

class CharactersMainRepository @Inject constructor(
    private val apiService: OnlineShopApiService
) {
    private var increment: Int = 1
    private lateinit var token: String

    fun swipeRefreshCat(): Observable<DataCat> {
        increment = 1
        return apiService.getCategories(page = increment).flatMap { it ->

            return@flatMap Observable.just(it)
        }.subscribeOn(Schedulers.io())
    }

    fun getToken(email: String, password: String, callback: (String) -> Unit) {
        val user = Credentials2()
        user.email = email
        user.password = password
        user.device_name = "Ipone"
        apiService.getToken(
            user
        ).enqueue(object :
            Callback<GetTokenAnswer> {
            override fun onResponse(call: Call<GetTokenAnswer>, response: Response<GetTokenAnswer>?) {
                callback.invoke(response?.body()?.token.toString())
            }

            override fun onFailure(call: Call<GetTokenAnswer>, t: Throwable?) {
                Log.e("ere", t.toString())
            }
        })
    }

    fun setToken(email: String, password: String, callback: (String) -> Unit) {
        val user = Credentials()
        user.email = email
        user.password = password
        user.password_confirmation = password
        apiService.setToken(
            user
        ).enqueue(object :
            Callback<token> {
             override fun onResponse(call: Call<token>, response: Response<token>?) {
                 callback.invoke(response?.body()?.token.toString())
             }

            override fun onFailure(call: Call<token>, t: Throwable?) {
                Log.e("ere", t.toString())
            }
        })
    }

    fun getMoreItemsCat(): Observable<DataCat> {
        increment += 1

        return apiService.getCategories(page = increment).flatMap { data ->
            return@flatMap Observable.just(data)
        }.subscribeOn(Schedulers.io())
    }

    fun swipeRefreshProd(): Observable<DataProd> {
        increment = 1
        return apiService.getProducts(page = increment).flatMap { it ->

            return@flatMap Observable.just(it)
        }.subscribeOn(Schedulers.io())
    }

    fun getMoreItemsProd(): Observable<DataProd> {
        increment += 1

        return apiService.getProducts(page = increment).flatMap { data ->
            return@flatMap Observable.just(data)
        }.subscribeOn(Schedulers.io())
    }
}