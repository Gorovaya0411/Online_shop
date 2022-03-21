package com.firecode.onlineshop.ui.product

import com.firecode.onlineshop.domain.MainUseCaseImpl
import com.firecode.onlineshop.model.AnswerProducts
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import javax.inject.Inject

class ProductPresenter @Inject constructor(private val charactersMainUseCase: MainUseCaseImpl) :
    MvpPresenter<ProductView>() {

    private var isRequest: Boolean = false
    private val defined = mutableListOf<AnswerProducts>()

    fun swipeRefresh(title:String): Boolean {

        val disposable = charactersMainUseCase.swipeRefreshProd()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.data.forEach { model ->
                   if (model.category.title == title) {
                       defined.add(model)
                   }
                }
                viewState.populateData(defined)
                viewState.visibilityProgressBar(false)
            }, {

            })
        return true
    }

    fun getMoreItems(title:String) {

        if (!isRequest) {
            isRequest = true
            viewState.visibilityProgressBar(true)
            val disposable = charactersMainUseCase.getMoreItemsProd()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.data.forEach { model ->
                        if (model.category.title == title) {
                            defined.add(model)
                        }
                    }
                    viewState.populateData(defined)
                    isRequest = false
                    viewState.visibilityProgressBar(false)

                }, {
                    viewState.visibilityProgressBar(false)
                })
        }
    }
}