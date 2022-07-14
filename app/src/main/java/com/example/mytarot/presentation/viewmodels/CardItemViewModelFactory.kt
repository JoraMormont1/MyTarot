package com.example.mytarot.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytarot.domain.entity.Card

class CardItemViewModelFactory(
    private val card: Card,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardItemViewModel::class.java)) {
            return CardItemViewModel(application, card) as T
        }
        throw RuntimeException("Unknown ViewModel class $modelClass")

    }
}