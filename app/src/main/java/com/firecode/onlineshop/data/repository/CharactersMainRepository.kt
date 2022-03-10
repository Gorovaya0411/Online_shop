package com.firecode.onlineshop.data.repository

import com.firecode.onlineshop.data.service.OnlineShopApiService
import com.firecode.onlineshop.model.DataCat
import com.firecode.onlineshop.model.DataProd
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharactersMainRepository @Inject constructor(private val apiService: OnlineShopApiService) {
    private var increment: Int = 1

    fun swipeRefreshCat(): Observable<DataCat> {
        increment = 1
        return apiService.getCategories(page = increment).flatMap { it ->

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