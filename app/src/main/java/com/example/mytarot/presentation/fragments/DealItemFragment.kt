package com.example.mytarot.presentation.fragments

import android.animation.LayoutTransition
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.mytarot.databinding.FragmentDealItemBinding
import com.example.mytarot.presentation.adapters.DealPosListAdapter
import com.example.mytarot.presentation.viewmodels.DealPosViewModel
import com.example.mytarot.presentation.viewmodels.DealPosViewModelFactory
import java.io.InputStream


class DealItemFragment : Fragment() {

    private val args by navArgs<DealItemFragmentArgs>()

    private var _binding: FragmentDealItemBinding? = null
    private val binding: FragmentDealItemBinding
        get() = _binding ?: throw RuntimeException("FragmentDealItemBinding == null")

    private lateinit var dealPosListAdapter: DealPosListAdapter
    private val viewModelFactory by lazy {
        DealPosViewModelFactory(
            args.deal,
            requireActivity().application
        )
    }

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[DealPosViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDealItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDealItemName.text = args.deal.name
        binding.tvDealItemDesc.text = args.deal.description
        binding.ivDealCardIg.setImageDrawable(getImageBitmap(args.deal.img))

        dealPosListAdapter = DealPosListAdapter()
        binding.rvDealPosList.adapter = dealPosListAdapter
        viewModel.dealPosList.observe(viewLifecycleOwner) {
            dealPosListAdapter.submitList(it)
        }
        dealPosListAdapter.onDealPosClickListener = {
            it.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        }
    }

    private fun getImageBitmap(img: String): Drawable? {
        context?.let {
            val ims: InputStream = it.assets.open(String.format("deals/%s.png", img))
            val d = Drawable.createFromStream(ims, null)
            return d
        }
        return null
    }

}