package com.example.mytarot.presentation

import android.app.Application
import androidx.lifecycle.*
import com.example.mytarot.data.TarotRepositoryImpl
import com.example.mytarot.domain.usecases.GetCardsByArcanaUseCase
import kotlinx.coroutines.launch

class CardListViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = TarotRepositoryImpl(application)

    private val getCardsByArcanaUseCase = GetCardsByArcanaUseCase(repository)

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _shopItem = MutableLiveData<ShopItem>()
    val shopItem: LiveData<ShopItem>
        get() = _shopItem

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    fun getShopItem(shopItemId: Int) {
        viewModelScope.launch {
            val item = getShopItemUseCase.getShopItem(shopItemId)
            _shopItem.value = item
        }

    }
}