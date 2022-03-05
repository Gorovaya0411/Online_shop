package com.firecode.onlineshop.di.modul.app

import android.content.Context
import android.net.ConnectivityManager
import com.firecode.onlineshop.MyApplication
import com.firecode.onlineshop.domain.MainUseCase
import com.firecode.onlineshop.domain.MainUseCaseImpl
import dagger.Module
import dagger.Provides

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
    ): MainUseCase {
        return MainUseCaseImpl()
    }
}