package com.example.mytarot.domain.usecases

import com.example.mytarot.domain.entity.ArchetypeCard

class GetArchetypesByIdUseCase (private val repository: TarotRepository) {
    fun getArchetypesById(cardId: Int):ArchetypeCard {
        return repository.getArchetypeById(cardId)
    }
}