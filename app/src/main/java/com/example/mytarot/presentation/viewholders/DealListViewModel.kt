package com.example.mytarot.presentation.viewholders

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mytarot.data.TarotRepositoryImpl
import com.example.mytarot.domain.usecases.GetDealsUseCase

class DealListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TarotRepositoryImpl(application)
    private val getDealsUseCase = GetDealsUseCase(repository)
    val dealList = getDealsUseCase.getDeals()
}