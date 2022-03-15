package com.firecode.onlineshop.data.service

import com.firecode.onlineshop.model.Credentials
import com.firecode.onlineshop.model.DataCat
import com.firecode.onlineshop.model.DataProd
import com.firecode.onlineshop.model.GetTokenAnswer
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

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
    fun getToken(@Body credentials: Credentials): Call<GetTokenAnswer>

    @POST("practice/shop/registration/")
    fun setToken(
        @Query("email") email: String,
        @Query("password") password: String
    ): Observable<GetTokenAnswer>

    companion object Factory {
        fun create(): OnlineShopApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://qa.firecode.ru/api/")
                .build()

            return retrofit.create(OnlineShopApiService::class.java)
        }
    }
}