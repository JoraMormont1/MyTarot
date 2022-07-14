package com.example.mytarot.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Card(
    val id:Int = UNDEFINED_ID,
    val name:String,
    val title:String,
    val arcana:String,
    val img1: String,
    val img2: String = "",
    val img3: String = ""
): Parcelable{
    companion object{
        const val UNDEFINED_ID = 0
    }
}
