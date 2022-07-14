package com.example.mytarot.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytarot.domain.entity.Deal
import java.lang.RuntimeException

class DealPosViewModelFactory(
    private val deal: Deal,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DealPosViewModel::class.java)) {
            return DealPosViewModel(application, deal) as T
        }
        throw RuntimeException("Unknown ViewModel class $modelClass")

    }
}