package com.example.mytarot.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.mytarot.domain.entity.*
import com.example.mytarot.domain.usecases.TarotRepository
import java.util.*

class TarotRepositoryImpl(
    application: Application
): TarotRepository {

    private val tarotDao = AppDatabase.getInstance(application).tarotDao()
    private val mapper = TarotMapper()

    override fun getArchetypeById(cardId: Int): ArchetypeCard {
        return mapper.mapDbArchetypesToEntity(tarotDao.getArchetypesById(cardId))
    }

    override fun getCardsByArcana(arcana: String): LiveData<List<Card>> =
        Transformations.map(
            tarotDao.getCardsByArcana(arcana)
        ){
            mapper.mapListDbCardToListEntity(it)
        }

    override fun getCardMeaningById(cardId: Int): LiveData<List<Meaning>> =
        Transformations.map(
            tarotDao.getCardMeaningById(cardId)
        ){
            mapper.mapListDbMeaningsToListEntity(it)
        }

    override fun getDealPositionsById(cardId: Int): LiveData<List<DealPos>> =
        Transformations.map(
            tarotDao.getDealPositionsById(cardId)
        ){
            mapper.mapListDbDealPosToListEntity(it)
        }

    override fun getDealsUseCase(): LiveData<List<Deal>> =
        Transformations.map(
            tarotDao.getDeals()
        ){
            mapper.mapListDbDealsToListEntity(it)
        }


    override fun calculateArchetypeUseCase(birthDate: Date): Int {
        TODO("Not yet implemented")
    }
}