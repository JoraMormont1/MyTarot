package com.example.mytarot.presentation.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.ListAdapter
import com.example.mytarot.databinding.ItemMeaningBinding
import com.example.mytarot.domain.entity.Meaning
import com.example.mytarot.presentation.viewholders.MeaningViewHolder
import org.w3c.dom.Text


class MeaningListAdapter : ListAdapter<Meaning, MeaningViewHolder>(MeaningDiffCallback()) {

    private var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeaningViewHolder {
        context = parent.context
        val binding = ItemMeaningBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MeaningViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: MeaningViewHolder, position: Int) {
        val binding = viewHolder.binding
        val meaning = getItem(position)
        if (meaning.type != "Общее значение") {
            binding.tvMeaningName.text = meaning.type
            binding.tvMeaningDesc.text = meaning.description
        }
        binding.root.setOnClickListener {
            setToggleCardLength(binding)

        }

    }

    private fun setToggleCardLength(binding: ItemMeaningBinding ){
        val state = binding.tvMeaningDesc.maxLines
        if (state > 4) {
            binding.tvMeaningDesc.maxLines = 4
            binding.tvMeaningDesc.setTextColor(Color.parseColor("#b8aaad"))
            binding.tvMeaningName.setTextColor(Color.parseColor("#b8aaad"))
            binding.ivArrowExpand.rotation = -90F
        } else {
            binding.tvMeaningDesc.maxLines = Int.MAX_VALUE
            binding.tvMeaningDesc.setTextColor(Color.WHITE)
            binding.tvMeaningName.setTextColor(Color.WHITE)
            binding.ivArrowExpand.rotation = 0F
        }
    }


}