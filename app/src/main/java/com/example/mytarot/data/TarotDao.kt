package com.example.mytarot.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TarotDao {

    @Query("SELECT * FROM cards WHERE arcana =:arcanaName")
    fun getCardsByArcana(arcanaName: String): LiveData<List<CardDbModel>>

    @Query("SELECT * FROM archetypes_card WHERE id =:cardId LIMIT 1")
    fun getArchetypesById(cardId: Int): ArchetypeCardDbModel

    @Query("SELECT * FROM meanings WHERE id =:cardId")
    fun getCardMeaningById(cardId: Int): LiveData<List<MeaningDbModel>>

    @Query("SELECT * FROM deals")
    fun getDeals(): LiveData<List<DealDbModel>>

    @Query("SELECT * FROM deal_positions WHERE deal_id =:id")
    fun getDealPositionsById(id: Int): LiveData<List<DealPosDbModel>>
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun addShopItem(shopItemDbModel: ShopItemDbModel)

//    @Query("DELETE FROM shop_items WHERE id =:shopItemId")
//    fun deleteShopItem(shopItemId: Int)


}