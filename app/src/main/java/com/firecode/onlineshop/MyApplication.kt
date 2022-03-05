package com.firecode.onlineshop

import android.app.Application
import com.firecode.onlineshop.di.component.AppComponent
import com.firecode.onlineshop.di.component.DaggerAppComponent
import com.firecode.onlineshop.di.modul.app.AppModule

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var appComponent: AppComponent
            private set
    }
}