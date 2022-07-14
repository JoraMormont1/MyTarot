package com.example.mytarot.presentation.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mytarot.databinding.ItemCardBinding
import com.example.mytarot.domain.entity.Card
import com.example.mytarot.presentation.viewholders.CardViewHolder
import java.io.InputStream


class CardListAdapter : ListAdapter<Card, CardViewHolder>(CardDiffCallback()) {


    private var context: Context? = null
    var onCardItemClickListener: ((Card) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        context = parent.context
        val binding = ItemCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: CardViewHolder, position: Int) {
        val binding = viewHolder.binding
        val card = getItem(position)
        binding.buttonCardDetailed.setOnClickListener {
            onCardItemClickListener?.invoke(card)
        }
        if (card.arcana == "Старшая") {
            if (card.id != 0) {
                binding.tvCardShortName.text = String.format("%s %s", card.id, card.name)
            } else {
                binding.tvCardShortName.text = String.format("0/22 %s", card.name)
            }
        } else {
            binding.tvCardShortName.text = String.format("%s", card.name)
        }

        binding.tvCardShortDesc.text = card.title
        binding.ivCardShortImg.setImageDrawable(getImageBitmap(String.format("%s.jpg", card.img1)))
    }

    fun getImageBitmap(img: String): Drawable? {
        context?.let {
            val ims: InputStream = it.assets.open(String.format("cards_img/sp/%s", img))
            val d = Drawable.createFromStream(ims, null)
            return d
        }
        return null
    }

}