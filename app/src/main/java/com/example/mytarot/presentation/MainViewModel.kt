package com.example.mytarot.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytarot.data.TarotRepositoryImpl
import com.example.mytarot.domain.usecases.GetCardsByArcanaUseCase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TarotRepositoryImpl(application)

    private val getCardsByArcanaUseCase = GetCardsByArcanaUseCase(repository)


    val cardList = getCardsByArcanaUseCase.getCardsByArcana("старшая")


}