package com.example.mytarot.domain.entity

data class ArchetypeCard(
    val id: Int = UNDEFINED_ID,
    val pos1: String,
    val pos2: String,
    val pos3: String,
    val pos4: String,
    val pos5: String,
    val pos6: String,
    val pos7: String,
    val pos8: String,
    val pos9: String
) {
    companion object {
        const val UNDEFINED_ID = 0
    }

    fun getPosByNum(num: Int):String {
        return when (num) {
            1 -> pos1
            2 -> pos2
            3 -> pos3
            4 -> pos4
            5 -> pos5
            6 -> pos6
            7 -> pos7
            8 -> pos8
            9 -> pos9
            else -> ""
        }
    }
}
