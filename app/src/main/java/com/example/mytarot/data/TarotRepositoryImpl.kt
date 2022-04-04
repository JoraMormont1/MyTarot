package com.example.mytarot.data

import com.example.mytarot.domain.entity.*
import com.example.mytarot.domain.usecases.TarotRepository
import java.util.*

object TarotRepositoryImpl: TarotRepository {
    override fun getArcanas(): List<Arcana> {
        TODO("Not yet implemented")
    }

    override fun getArchetypeById(cardId: Int): ArchetypeCard {
        TODO("Not yet implemented")
    }

    override fun getCardsByArcana(arcana: Arcana): List<Card> {
        TODO("Not yet implemented")
    }

    override fun getCardMeaningById(cardId: Int): List<Meaning> {
        TODO("Not yet implemented")
    }

    override fun getDealPositionsById(cardId: Int): List<DealPos> {
        TODO("Not yet implemented")
    }

    override fun getDealsUseCase(): List<Deal> {
        TODO("Not yet implemented")
    }

    override fun getMinorArcanas(): List<MinorArcana> {
        TODO("Not yet implemented")
    }

    override fun calculateArchetypeUseCase(birthDate: Date): Int {
        TODO("Not yet implemented")
    }
}