package com.example.mytarot.domain.usecases

import androidx.lifecycle.LiveData
import com.example.mytarot.domain.entity.Card
import com.example.mytarot.domain.entity.Meaning

class GetCardsByArcanaUseCase(private val repository: TarotRepository) {
    fun getCardsByArcana(arcana: String): LiveData<List<Card>> {
        return repository.getCardsByArcana(arcana)
    }
}