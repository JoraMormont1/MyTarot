package com.example.mytarot.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deals")
data class DealDbModel(
    @PrimaryKey
    val id:Int,
    val name:String,
    val description:String,
    val img: String,
    val title:String = ""
)

