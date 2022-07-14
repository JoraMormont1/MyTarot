package com.example.mytarot.presentation.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.mytarot.databinding.FragmentCardItemBinding
import com.example.mytarot.presentation.adapters.MeaningListAdapter
import com.example.mytarot.presentation.viewmodels.CardItemViewModel
import com.example.mytarot.presentation.viewmodels.CardItemViewModelFactory
import java.io.InputStream


class CardItemFragment : Fragment() {

    private val args by navArgs<CardItemFragmentArgs>()

    private var _binding: FragmentCardItemBinding? = null
    private val binding: FragmentCardItemBinding
        get() = _binding ?: throw RuntimeException("FragmentCardItemBinding == null")

    private lateinit var meaningListAdapter: MeaningListAdapter
    private val viewModelFactory by lazy {
        CardItemViewModelFactory(
            args.card,
            requireActivity().application
        )
    }

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[CardItemViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCardItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivCardImg1.setImageDrawable(
            getImageBitmap(
                String.format(
                    "sp/%s.jpg",
                    args.card.img2
                )
            )
        )
        binding.ivCardImg2.setImageDrawable(
            getImageBitmap(
                String.format(
                    "waite/%s.jpg",
                    args.card.img1
                )
            )
        )
        binding.ivCardImg3.setImageDrawable(
            getImageBitmap(
                String.format(
                    "cat/%s.jpg",
                    args.card.img3
                )
            )
        )

        if (args.card.id != 0) {
            binding.tvCardItemTitle.text = String.format("%s %s", args.card.id, args.card.name)
        } else {
            binding.tvCardItemTitle.text = String.format("0/22 %s", args.card.name)
        }
        binding.tvMeaningNameReg.text = "Общее значение"
        binding.tvMeaningDescReg.text = args.card.title

        meaningListAdapter = MeaningListAdapter()
        binding.rvMeaningList.adapter = meaningListAdapter
        viewModel.meaningList.observe(viewLifecycleOwner) {
            Log.d("check_meaning", it.toString())
            meaningListAdapter.submitList(it)
        }
    }

    private fun getImageBitmap(img: String): Drawable? {
        context?.let {
            val ims: InputStream = it.assets.open(String.format("cards_img/%s", img))
            return Drawable.createFromStream(ims, null)
        }
        return null
    }
}