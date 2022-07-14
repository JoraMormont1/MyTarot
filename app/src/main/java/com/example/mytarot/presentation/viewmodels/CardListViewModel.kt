package com.example.mytarot.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.mytarot.data.TarotRepositoryImpl
import com.example.mytarot.domain.usecases.GetCardsByArcanaUseCase

class CardListViewModel(application: Application, arcana: String) : ViewModel() {
    private val repository = TarotRepositoryImpl(application)

    private val getCardsByArcanaUseCase = GetCardsByArcanaUseCase(repository)

    val cardList = getCardsByArcanaUseCase.getCardsByArcana(arcana)





}