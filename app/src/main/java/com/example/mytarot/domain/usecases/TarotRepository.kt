package com.example.mytarot.domain.usecases

import com.example.mytarot.domain.entity.*
import java.util.*

interface TarotRepository {
    fun getArcanas(): List<Arcana>
    fun getArchetypeById(cardId: Int): ArchetypeCard
    fun getCardsByArcana(arcana: Arcana): List<Card>
    fun getCardMeaningById(cardId: Int): List<Meaning>
    fun getDealPositionsById(cardId: Int): List<DealPos>
    fun getDealsUseCase(): List<Deal>
    fun getMinorArcanas(): List<MinorArcana>
    fun calculateArchetypeUseCase(birthDate: Date): Int
}