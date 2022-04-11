package com.example.mytarot.domain.usecases

import androidx.lifecycle.LiveData
import com.example.mytarot.domain.entity.DealPos
import com.example.mytarot.domain.entity.Meaning

class GetDealPositionsByIdUseCase(private val repository: TarotRepository) {
    fun getDealPositionsById(cardId: Int): LiveData<List<DealPos>> {
        return repository.getDealPositionsById(cardId)
    }
}