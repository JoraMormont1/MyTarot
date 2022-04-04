package com.example.mytarot.domain.entity

data class Meaning(
    val id:Int = UNDEFINED_ID,
    val type: String,
    val description: String
){
    companion object{
        const val UNDEFINED_ID = 0
    }
}
