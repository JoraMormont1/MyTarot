package com.example.mytarot.domain.usecases

import androidx.lifecycle.LiveData
import com.example.mytarot.domain.entity.*
import java.util.*

interface TarotRepository {
    suspend fun getArchetypeById(cardId: Int): ArchetypeCard
    fun getCardsByArcana(arcana: String): LiveData<List<Card>>
    fun getCardMeaningById(cardId: Int): LiveData<List<Meaning>>
    fun getDealPositionsById(cardId: Int): LiveData<List<DealPos>>
    fun getDeals(): LiveData<List<Deal>>
}