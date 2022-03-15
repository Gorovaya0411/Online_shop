package com.firecode.onlineshop.ui.general_navigation.profile.register

import com.firecode.onlineshop.ui.general_navigation.profile.login.LoginView
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndStrategy::class)
interface RegisterView : MvpView {

}

abstract class CommunityActivityPresente : MvpPresenter<RegisterView>() {

}
