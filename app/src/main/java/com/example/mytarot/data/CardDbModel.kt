package com.example.mytarot.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class CardDbModel(
    @PrimaryKey
    val id:Int,
    val name:String,
    val arcana:String,
    val img1: String,
    val img2: String = "",
    val img3: String = ""
)
