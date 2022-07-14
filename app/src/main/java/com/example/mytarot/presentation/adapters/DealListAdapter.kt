package com.example.mytarot.presentation.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mytarot.databinding.ItemDealBinding
import com.example.mytarot.domain.entity.Deal
import com.example.mytarot.presentation.viewholders.DealViewHolder
import java.io.InputStream


class DealListAdapter : ListAdapter<Deal, DealViewHolder>(DealDiffCallback()) {


    private var context: Context? = null
    var onDealItemClickListener: ((Deal) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealViewHolder {
        context = parent.context
        val binding = ItemDealBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DealViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: DealViewHolder, position: Int) {
        val binding = viewHolder.binding
        val deal = getItem(position)
        binding.root.setOnClickListener {
            onDealItemClickListener?.invoke(deal)
        }
        binding.tvDealCardName.text = deal.name
        binding.tvDealCardDesc.text = deal.title
        binding.ivDealCardIg.setImageDrawable(getImageBitmap(deal.img))
    }

    fun getImageBitmap(img: String): Drawable? {
        context?.let {
            val ims: InputStream = it.assets.open(String.format("deals/%s.png", img))
            val d = Drawable.createFromStream(ims, null)
            return d
        }
        return null
    }


}