package com.example.mytarot.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Deal(
    val id:Int = UNDEFINED_ID,
    val name:String,
    val description:String,
    val img: String,
    val title:String = ""
): Parcelable{
    companion object{
        const val UNDEFINED_ID = 0
    }
}

