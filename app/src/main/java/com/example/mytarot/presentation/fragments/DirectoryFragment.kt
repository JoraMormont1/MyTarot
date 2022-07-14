package com.example.mytarot.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mytarot.databinding.FragmentDirectoryBinding


class DirectoryFragment : Fragment() {

    private var _binding: FragmentDirectoryBinding? = null
    private val binding: FragmentDirectoryBinding
        get() = _binding ?: throw RuntimeException("FragmentDirectoryBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDirectoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonOnClickListeners()
    }

    private fun launchCardListFragment(arcana: String) {
        findNavController().navigate(
            DirectoryFragmentDirections.actionDirectoryFragmentToCardListFragment2(
                arcana
            )
        )
    }

    private fun setButtonOnClickListeners() {
        with(binding) {
            buttonHighArc.setOnClickListener {
                launchCardListFragment("Старшая")
            }
            buttonCups.setOnClickListener {
                launchCardListFragment("Кубки")
            }
            buttonSwords.setOnClickListener {
                launchCardListFragment("Мечи")
            }
            buttonPentacles.setOnClickListener {
                launchCardListFragment("Пентакли")
            }
            buttonWands.setOnClickListener {
                launchCardListFragment("Жезлы")
            }
        }
    }

}