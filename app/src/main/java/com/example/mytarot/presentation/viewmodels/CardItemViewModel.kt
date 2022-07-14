package com.example.mytarot.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.mytarot.data.TarotRepositoryImpl
import com.example.mytarot.domain.entity.Card
import com.example.mytarot.domain.usecases.GetCardMeaningByIdUseCase

class CardItemViewModel(application: Application, card: Card) : ViewModel() {
    private val repository = TarotRepositoryImpl(application)


    private val getCardMeaningByIdUseCase = GetCardMeaningByIdUseCase(repository)

    val meaningList = getCardMeaningByIdUseCase.getCardMeaningById(card.id)


}