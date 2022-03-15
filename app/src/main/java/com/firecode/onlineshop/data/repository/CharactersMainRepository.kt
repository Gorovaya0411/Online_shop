package com.firecode.onlineshop.data.repository

import com.firecode.onlineshop.data.service.OnlineShopApiService
import com.firecode.onlineshop.model.Credentials
import com.firecode.onlineshop.model.DataCat
import com.firecode.onlineshop.model.DataProd
import com.firecode.onlineshop.model.GetTokenAnswer
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rx.Single.just
import javax.inject.Inject

class CharactersMainRepository @Inject constructor(
    private val apiService: OnlineShopApiService
) {
    private var increment: Int = 1

    fun swipeRefreshCat(): Observable<DataCat> {
        increment = 1
        return apiService.getCategories(page = increment).flatMap { it ->

            return@flatMap Observable.just(it)
        }.subscribeOn(Schedulers.io())
    }

    fun getToken(email: String, password: String, device_name: String): GetTokenAnswer {
        var result :GetTokenAnswer
        apiService.getToken(Credentials(email, password, device_name)).enqueue(object :
            Callback<GetTokenAnswer> {
            override fun onResponse(call: Call<GetTokenAnswer>, response: Response<GetTokenAnswer>?) {
               response.
            }

            override fun onFailure(call: Call<GetTokenAnswer>, t: Throwable?) {
                //Произошла ошибка
            }
        })
        return result
    }

    fun setToken(email: String, password: String): Observable<GetTokenAnswer> {
        increment = 1
        return apiService.setToken(email, password).flatMap { it ->

            return@flatMap Observable.just(it)
        }.subscribeOn(Schedulers.io())
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