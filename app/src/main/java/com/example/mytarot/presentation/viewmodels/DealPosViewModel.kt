package com.example.mytarot.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.mytarot.data.TarotRepositoryImpl
import com.example.mytarot.domain.entity.Deal
import com.example.mytarot.domain.usecases.GetDealPositionsByIdUseCase

class DealPosViewModel(application: Application, deal: Deal) : ViewModel() {
    private val repository = TarotRepositoryImpl(application)

    private val getDealPositionsByIdUseCase = GetDealPositionsByIdUseCase(repository)
    val dealPosList = getDealPositionsByIdUseCase.getDealPositionsById(deal.id)


}