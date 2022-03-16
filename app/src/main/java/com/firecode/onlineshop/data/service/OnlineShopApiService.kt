package com.firecode.onlineshop.data.service

import android.provider.ContactsContract
import com.firecode.onlineshop.model.*
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.io.IOException

interface OnlineShopApiService {
    @GET("practice/shop/v1/categories/")
    fun getCategories(
        @Query("page") page: Int
    ): Observable<DataCat>

    @GET("practice/shop/v1/products/")
    fun getProducts(
        @Query("page") page: Int
    ): Observable<DataProd>

    @POST("auth/get_token/")
    fun getToken(
        @Body credentials: Credentials2
    ): Call<GetTokenAnswer>

    @POST("practice/shop/registration/")
    fun setToken(  @Body credentials: Credentials): Call<token>

    companion object Factory {
        private lateinit var retrofit :Retrofit
        fun create(): OnlineShopApiService {
             retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://qa.firecode.ru/api/")
                .build()

            return retrofit.create(OnlineShopApiService::class.java)
        }
    }
}