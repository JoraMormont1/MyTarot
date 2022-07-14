package com.example.mytarot.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.mytarot.domain.entity.DealPos

class DealPosDiffCallback: DiffUtil.ItemCallback<DealPos>() {
    override fun areItemsTheSame(oldItem: DealPos, newItem: DealPos): Boolean {
        return oldItem.position == newItem.position
    }
    override fun areContentsTheSame(oldItem: DealPos, newItem: DealPos): Boolean {
        return oldItem == newItem
    }

}