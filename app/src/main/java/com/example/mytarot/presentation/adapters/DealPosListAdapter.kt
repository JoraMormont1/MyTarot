package com.example.mytarot.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.ListAdapter
import com.example.mytarot.databinding.ItemDealPosBinding
import com.example.mytarot.domain.entity.DealPos
import com.example.mytarot.presentation.viewholders.DealPosViewHolder


class DealPosListAdapter : ListAdapter<DealPos, DealPosViewHolder>(DealPosDiffCallback()) {


    private var context: Context? = null
    var onDealPosClickListener: ((ConstraintLayout) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealPosViewHolder {
        context = parent.context
        val binding = ItemDealPosBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DealPosViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: DealPosViewHolder, position: Int) {
        val binding = viewHolder.binding
        val dealPos = getItem(position)
        binding.root.setOnClickListener {
            val v = when (binding.tvDealPosDesc.visibility) {
                View.GONE -> View.VISIBLE
                else -> View.GONE
            }
            val va = when (binding.arrowExpandLeft.visibility) {
                View.GONE -> View.VISIBLE
                else -> View.GONE
            }
            onDealPosClickListener?.invoke(binding.layout)
            binding.tvDealPosDesc.visibility = v
            binding.arrowExpandLeft.visibility = va
            binding.arrowExpandRight.visibility = va
        }
        binding.tvDealPosName.text = String.format("${dealPos.position + 1} карта")
        binding.tvDealPosDesc.text = dealPos.description
    }

}