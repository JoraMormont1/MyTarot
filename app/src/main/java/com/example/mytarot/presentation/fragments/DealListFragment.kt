package com.example.mytarot.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mytarot.R
import com.example.mytarot.databinding.FragmentDealListBinding
import com.example.mytarot.domain.entity.Deal
import com.example.mytarot.presentation.adapters.DealListAdapter
import com.example.mytarot.presentation.viewholders.DealListViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class DealListFragment : Fragment() {

    private var _binding: FragmentDealListBinding? = null
    private val binding: FragmentDealListBinding
        get() = _binding?: throw RuntimeException("FragmentDealListBinding == null")


    private lateinit var dealListAdapter: DealListAdapter


    private val viewModel by lazy {
        ViewModelProvider(
            this
        )[DealListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        _binding =  FragmentDealListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dealListAdapter = DealListAdapter()
        binding.rvDealList.adapter = dealListAdapter
        viewModel.dealList.observe(viewLifecycleOwner) {
            dealListAdapter.submitList(it)
        }
        dealListAdapter.onDealItemClickListener = {
            launchDealItemFragment(it)
        }
    }


    private fun launchDealItemFragment(deal: Deal){
        findNavController().navigate(
            DealListFragmentDirections.actionDealListFragmentToDealItemFragment(
                deal
            )
        )
    }
}