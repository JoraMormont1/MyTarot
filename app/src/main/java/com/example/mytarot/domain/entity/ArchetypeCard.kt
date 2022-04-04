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
}
