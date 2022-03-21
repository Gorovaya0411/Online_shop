package com.firecode.onlineshop.data.service

import com.firecode.onlineshop.model.*
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.squareup.okhttp.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

interface ProfileApiService {

    @POST("auth/get_token/")
    fun getToken(
        @Body credentials: RequestBodyLogin
    ): Call<ResponseBody>

    @POST("practice/shop/registration/")
    fun setToken(@Body credentials: RequestBodyRegistration): Call<ResponseBody>

    companion object Factory {
        lateinit var retrofit: Retrofit
        fun create(): ProfileApiService {
            retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("https://qa.firecode.ru/api/")
                .build()

            return retrofit.create(ProfileApiService::class.java)
        }
    }
}