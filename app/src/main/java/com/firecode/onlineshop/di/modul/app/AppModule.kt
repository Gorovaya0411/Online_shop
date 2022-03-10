package com.firecode.onlineshop.di.modul.app

import android.content.Context
import android.net.ConnectivityManager
import com.firecode.onlineshop.MyApplication
import com.firecode.onlineshop.data.repository.CharactersMainRepository
import com.firecode.onlineshop.data.service.OnlineShopApiService
import com.firecode.onlineshop.domain.MainUseCase
import com.firecode.onlineshop.domain.MainUseCaseImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module()
class AppModule(private val myApplication: MyApplication) {

    @Provides
    @AppScope
    @AppContext
    fun provideAppContext(): Context = myApplication.applicationContext

    @Provides
    @AppScope
    fun provideConnectivityManager(@AppContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    @AppScope
    fun provideMainUseCase(
        charactersMainRepository: CharactersMainRepository
    ): MainUseCase {
        return MainUseCaseImpl(charactersMainRepository)
    }

    @AppScope
    @Provides
    fun provideOKHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(1200, TimeUnit.SECONDS)
            .connectTimeout(1200, TimeUnit.SECONDS)
            .build()
    }

    @AppScope
    @Provides
    fun provideGSON(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @AppScope
    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {

        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://qa.firecode.ru/api/practice/shop/v1/")
            .build()
    }

    @AppScope
    @Provides
    fun providesService(retrofit: Retrofit): OnlineShopApiService =
        retrofit.create(OnlineShopApiService::class.java)

    @AppScope
    @Provides
    fun providesMainRepository(apiService: OnlineShopApiService): CharactersMainRepository =
        CharactersMainRepository(apiService)
}