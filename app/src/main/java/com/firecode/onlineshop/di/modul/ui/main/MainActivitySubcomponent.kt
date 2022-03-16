package com.firecode.onlineshop.di.modul.ui.main

import com.firecode.onlineshop.ui.general_navigation.catalog.CatalogPresenter
import com.firecode.onlineshop.ui.general_navigation.profile.login.LoginPresenter
import com.firecode.onlineshop.ui.general_navigation.profile.register.RegisterPresenter
import com.firecode.onlineshop.ui.main.MainActivityPresenter
import com.firecode.onlineshop.ui.main.MainActivityPresenterImpl
import com.firecode.onlineshop.ui.product.ProductPresenter
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
@MainActivityScope
interface MainActivitySubcomponent {
    val catalog: CatalogPresenter
    val main: MainActivityPresenterImpl
    val product: ProductPresenter
    val login: LoginPresenter
    val register: RegisterPresenter
}