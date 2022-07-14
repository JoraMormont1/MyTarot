package com.example.mytarot.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mytarot.R
import com.example.mytarot.databinding.CardListFragmentBinding
import com.example.mytarot.domain.entity.Card
import com.example.mytarot.presentation.adapters.CardListAdapter
import com.example.mytarot.presentation.viewmodels.CardListViewModel
import com.example.mytarot.presentation.viewmodels.CardListViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView


class CardListFragment : Fragment() {

    private val args by navArgs<CardListFragmentArgs>()

    private var _binding: CardListFragmentBinding? = null
    private val binding: CardListFragmentBinding
        get() = _binding ?: throw RuntimeException("CardListFragmentBinding == null")



    private lateinit var cardListAdapter: CardListAdapter

    private val viewModelFactory by lazy {
        CardListViewModelFactory(
            args.arcana,
            requireActivity().application
        )
    }

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[CardListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CardListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardListAdapter = CardListAdapter()
        binding.rvCardList.adapter = cardListAdapter
        viewModel.cardList.observe(viewLifecycleOwner) {
            cardListAdapter.submitList(it)
        }
        cardListAdapter.onCardItemClickListener = {
            launchCardItemFragment(it)
        }

    }

    override fun onStart() {
        super.onStart()
        val mBottomNavigationView: BottomNavigationView =
            requireActivity().findViewById(R.id.menu)
        mBottomNavigationView.selectedItemId = R.id.directoryFragment
        mBottomNavigationView.isSelected
    }

    private fun launchCardItemFragment(card: Card) {
        findNavController().navigate(
            CardListFragmentDirections.actionCardListFragment2ToCardItemFragment(
                card
            )
        )
    }

    companion object {
        fun newInstance(): CardListFragment {
            return CardListFragment()
        }
    }
}