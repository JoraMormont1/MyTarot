package com.example.mytarot.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "archetypes_card",
    foreignKeys = [
        ForeignKey(entity = CardDbModel::class,
            parentColumns = ["id"],
            childColumns = ["id"]
            )])
data class ArchetypeCardDbModel(
    @PrimaryKey
    val id: Int,
    val pos1: String,
    val pos2: String,
    val pos3: String,
    val pos4: String,
    val pos5: String,
    val pos6: String,
    val pos7: String,
    val pos8: String,
    val pos9: String
)
