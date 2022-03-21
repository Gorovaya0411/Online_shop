package com.firecode.onlineshop.data.service

import com.firecode.onlineshop.model.*
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface OnlineShopApiService {
    @GET("categories/")
    fun getCategories(
        @Query("page") page: Int
    ): Observable<DataCatalog>

    @GET("products/")
    fun getProducts(
        @Query("page") page: Int
    ): Observable<DataProduct>

    companion object Factory {
        private lateinit var retrofit: Retrofit
        fun create(): OnlineShopApiService {
            retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://qa.firecode.ru/api/practice/shop/v1/")
                .build()

            return retrofit.create(OnlineShopApiService::class.java)
        }
    }
}