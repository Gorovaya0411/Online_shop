package com.firecode.onlineshop.di.component

import com.firecode.onlineshop.di.modul.app.AppModule
import com.firecode.onlineshop.di.modul.app.AppScope
import com.firecode.onlineshop.di.modul.ui.main.MainActivityModule
import com.firecode.onlineshop.di.modul.ui.main.MainActivitySubcomponent
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun with(mainActivityModule: MainActivityModule): MainActivitySubcomponent
}