package com.example.mytarot.domain.usecases

import androidx.lifecycle.LiveData
import com.example.mytarot.domain.entity.Deal
import com.example.mytarot.domain.entity.DealPos

class GetDealsUseCase(private val repository: TarotRepository) {
    fun getDeals(): LiveData<List<Deal>> {
        return repository.getDeals()
    }
}