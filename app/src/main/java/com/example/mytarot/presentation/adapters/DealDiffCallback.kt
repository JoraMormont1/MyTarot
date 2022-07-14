package com.example.mytarot.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.mytarot.domain.entity.Deal

class DealDiffCallback: DiffUtil.ItemCallback<Deal>() {
    override fun areItemsTheSame(oldItem: Deal, newItem: Deal): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Deal, newItem: Deal): Boolean {
        return oldItem == newItem
    }

}