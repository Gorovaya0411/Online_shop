package com.firecode.onlineshop.domain

import com.firecode.onlineshop.data.repository.CharactersMainRepository
import com.firecode.onlineshop.model.DataCat
import com.firecode.onlineshop.model.DataProd
import io.reactivex.Observable
import javax.inject.Inject

interface MainUseCase

class MainUseCaseImpl @Inject constructor(
    private val charactersMainRepository: CharactersMainRepository
) : MainUseCase {
    fun swipeRefreshCat(): Observable<DataCat> = charactersMainRepository.swipeRefreshCat()
    fun getMoreItemsCat(): Observable<DataCat> = charactersMainRepository.getMoreItemsCat()
    fun swipeRefreshProd(): Observable<DataProd> = charactersMainRepository.swipeRefreshProd()
    fun getMoreItemsProd(): Observable<DataProd> = charactersMainRepository.swipeRefreshProd()
}