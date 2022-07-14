package com.example.mytarot.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.mytarot.domain.entity.Meaning

class MeaningDiffCallback : DiffUtil.ItemCallback<Meaning>() {
    override fun areItemsTheSame(oldItem: Meaning, newItem: Meaning): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Meaning, newItem: Meaning): Boolean {
        return oldItem == newItem
    }

}