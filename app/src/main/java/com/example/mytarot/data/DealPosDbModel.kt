package com.example.mytarot.data

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "deal_positions", primaryKeys = ["deal_id", "position"], foreignKeys = [
    ForeignKey(entity = DealDbModel::class,
        parentColumns = ["id"],
        childColumns = ["deal_id"]
    )])
data class DealPosDbModel(
    val deal_id: Int,
    val position: Int,
    val description: String
)
