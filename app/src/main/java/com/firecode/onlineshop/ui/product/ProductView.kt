package com.firecode.onlineshop.ui.product

import com.firecode.onlineshop.model.AnswerProducts
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndStrategy::class)
interface ProductView : MvpView {
    fun populateData(model: List<AnswerProducts>)
    fun visibilityProgressBar(isVisible: Boolean)
    fun addData(model: List<AnswerProducts>)
}