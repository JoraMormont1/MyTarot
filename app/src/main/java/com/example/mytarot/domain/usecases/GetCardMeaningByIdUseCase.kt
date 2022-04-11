package com.example.mytarot.domain.usecases

import androidx.lifecycle.LiveData
import com.example.mytarot.domain.entity.Meaning

class GetCardMeaningByIdUseCase(private val repository: TarotRepository) {
    fun getCardMeaningById(cardId: Int): LiveData<List<Meaning>>{
        return repository.getCardMeaningById(cardId)
    }
}