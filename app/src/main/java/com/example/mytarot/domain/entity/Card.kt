package com.example.mytarot.domain.entity

data class Card(
    val id:Int = UNDEFINED_ID,
    val name:String,
    val arcana:String,
    val img1: String,
    val img2: String = "",
    val img3: String = ""
){
    companion object{
        const val UNDEFINED_ID = 0
    }
}
