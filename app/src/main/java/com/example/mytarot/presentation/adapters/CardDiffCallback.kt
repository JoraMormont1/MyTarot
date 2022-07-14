package com.example.mytarot.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.mytarot.domain.entity.Card

class CardDiffCallback: DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem == newItem
    }
}