package com.example.mytarot.data

import com.example.mytarot.domain.entity.*

class TarotMapper {


    fun mapDbArchetypesToEntity(archetypeCardDbModel: ArchetypeCardDbModel) = ArchetypeCard(
        id = archetypeCardDbModel.id,
        pos1 = archetypeCardDbModel.pos1,
        pos2 = archetypeCardDbModel.pos2,
        pos3 = archetypeCardDbModel.pos3,
        pos4 = archetypeCardDbModel.pos4,
        pos5 = archetypeCardDbModel.pos5,
        pos6 = archetypeCardDbModel.pos6,
        pos7 = archetypeCardDbModel.pos7,
        pos8 = archetypeCardDbModel.pos8,
        pos9 = archetypeCardDbModel.pos9
    )

    fun mapDbCardToEntity(cardDbModel: CardDbModel) = Card(
        id = cardDbModel.id,
        name = cardDbModel.name,
        arcana = cardDbModel.arcana,
        img1  = cardDbModel.img1,
        img2 = cardDbModel.img2,
        img3 = cardDbModel.img3
    )

    fun mapDbDealToEntity(dealDbModel: DealDbModel) = Deal(
        id = dealDbModel.id,
        name = dealDbModel.name,
        description = dealDbModel.description,
        img = dealDbModel.img,
        title = dealDbModel.title
    )

    fun mapDbDealPosToEntity(dealPosDbModel: DealPosDbModel) = DealPos(
        deal_id = dealPosDbModel.deal_id,
        position = dealPosDbModel.position,
        description = dealPosDbModel.description
    )

    fun mapDbMeaningToEntity(meaningDbModel: MeaningDbModel) = Meaning(
        id = meaningDbModel.id,
        type = meaningDbModel.type,
        description = meaningDbModel.description
    )

    fun mapListDbCardToListEntity(list: List<CardDbModel>) = list.map{
        mapDbCardToEntity(it)
    }


    fun mapListDbMeaningsToListEntity(list: List<MeaningDbModel>) = list.map{
        mapDbMeaningToEntity(it)
    }

    fun mapListDbDealsToListEntity(list: List<DealDbModel>) = list.map{
        mapDbDealToEntity(it)
    }

    fun mapListDbDealPosToListEntity(list: List<DealPosDbModel>) = list.map{
        mapDbDealPosToEntity(it)
    }



}