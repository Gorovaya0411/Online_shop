package com.firecode.onlineshop.ui.general_navigation.profile.login

import com.firecode.onlineshop.model.AnswerCategories
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndStrategy::class)
interface LoginView : MvpView {

}

abstract class CommunityActivityPresenter : MvpPresenter<LoginView>() {
    abstract fun getCheckDetailedFragment(): String?
    abstract fun setCheckDetailedFragment(mark: String?)
}