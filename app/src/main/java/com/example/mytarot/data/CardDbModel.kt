package com.example.mytarot.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class CardDbModel(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id:Int,
    @ColumnInfo(name = "name")
    val name:String,
    @ColumnInfo(name = "title")
    val title:String,
    @ColumnInfo(name = "arcana")
    val arcana:String,
    @ColumnInfo(name = "img1")
    val img1: String,
    @ColumnInfo(name = "img2")
    val img2: String = "",
    @ColumnInfo(name = "img3")
    val img3: String = ""
)
