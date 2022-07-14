package com.example.mytarot.data

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "meanings", primaryKeys = ["id","type"],
    foreignKeys = [
        ForeignKey(entity = CardDbModel::class,
            parentColumns = ["id"],
            childColumns = ["id"]
        )])
data class MeaningDbModel(
    val id:Int,
    val type: String,
    val description: String
)