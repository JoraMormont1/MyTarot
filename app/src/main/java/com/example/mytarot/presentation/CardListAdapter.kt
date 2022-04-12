package com.example.mytarot.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.example.mytarot.R
import com.example.mytarot.domain.entity.Card
import java.lang.RuntimeException

class CardListAdapter : ListAdapter<Card, CardViewHolder>(CardDiffCallback()) {



    var onShopItemClickListener: ((Card) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {

        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_card,
            parent,
            false
        )
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: CardViewHolder, position: Int) {
        val binding = viewHolder.binding
        val card = getItem(position)

        binding.root.setOnClickListener {
            onShopItemClickListener?.invoke(card)
        }

    }




    companion object {

        const val MAX_POOL_SIZE = 30
    }
}