package com.firecode.onlineshop.di.modul.ui.main

import com.firecode.onlineshop.ui.main.MainActivityPresenter
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
@MainActivityScope
interface MainActivitySubcomponent {
    val presenter: MainActivityPresenter
}