package com.example.mytarot.domain.entity

data class Deal(
    val id:Int = UNDEFINED_ID,
    val name:String,
    val description:String,
    val img1: String,
    val title:String = ""
){
    companion object{
        const val UNDEFINED_ID = 0
    }
}

