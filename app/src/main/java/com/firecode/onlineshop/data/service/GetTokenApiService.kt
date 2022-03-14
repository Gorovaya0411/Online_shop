package com.firecode.onlineshop.data.service

import com.firecode.onlineshop.model.GetTokenAnswer
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Path

interface GetTokenApiService {
    @POST("get_token/")
    fun getCategories(
        @Path("email") email: String,
        @Path("password") password: String
    ): Observable<GetTokenAnswer>

    companion object Factory {
        fun create(): GetTokenApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://qa.firecode.ru/api/auth/")
                .build()

            return retrofit.create(GetTokenApiService::class.java)
        }
    }
}