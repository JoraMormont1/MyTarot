package com.example.mytarot.presentation.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mytarot.R
import com.example.mytarot.databinding.FragmentArchetypeListBinding
import com.example.mytarot.presentation.viewmodels.ArchetypeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ArchetypeListFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(
            this
        )[ArchetypeViewModel::class.java]
    }

    private val scope = CoroutineScope(Dispatchers.Main)

    private var _binding: FragmentArchetypeListBinding? = null
    private val binding: FragmentArchetypeListBinding
        get() = _binding ?: throw RuntimeException("FragmentArchetypeListBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArchetypeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etDate.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputDate()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.buttonCalcArchetypes.setOnClickListener {
            val str = binding.etDate.text.toString()
            scope.launch {
                viewModel.processDate(str)
                viewModel.archList.observe(viewLifecycleOwner) {
                    setArchetypes(it)
                }
            }

        }

        viewModel.errorInputDate.observe(viewLifecycleOwner) {
            val message = if (it) {
                "неверная дата"
            } else {
                null
            }
            binding.tilDate.error = message
        }
    }

    private fun setArchetypes(list: List<String>) {
        val listArcNames = mutableListOf<String>()
        var tempListNum = listOf<Int>()
        viewModel.numList.observe(viewLifecycleOwner) {
            tempListNum = it
        }
        viewModel.numListTemp.observe(viewLifecycleOwner) {
            for (i in tempListNum) {
                if (i != 22) {
                    listArcNames.add(it[i].name)
                } else {
                    listArcNames.add(it[0].name)
                }
            }

            with(binding) {
                tvArchetypeDesc1.text = String.format(
                    "${resources.getString(R.string.arc_pos1)}" +
                            "\n\nАркан - ${listArcNames[0]}\n\n${list[0]}"
                )
                tvArchetypeDesc2.text = String.format(
                    "${resources.getString(R.string.arc_pos2)}\n" +
                            "\nАркан - ${listArcNames[1]}\n\n${list[1]}"
                )
                tvArchetypeDesc3.text = String.format(
                    "${resources.getString(R.string.arc_pos3)}\n" +
                            "\nАркан - ${listArcNames[2]}\n\n${list[2]}"
                )
                tvArchetypeDesc4.text = String.format(
                    "${resources.getString(R.string.arc_pos4)}\n" +
                            "\nАркан - ${listArcNames[3]}\n\n${list[3]}"
                )
                tvArchetypeDesc5.text = String.format(
                    "${resources.getString(R.string.arc_pos5)}\n" +
                            "\nАркан - ${listArcNames[4]}\n\n${list[4]}"
                )
                tvArchetypeDesc6.text = String.format(
                    "${resources.getString(R.string.arc_pos6)}\n" +
                            "\nАркан - ${listArcNames[5]}\n\n${list[5]}"
                )
                tvArchetypeDesc7.text = String.format(
                    "${resources.getString(R.string.arc_pos7)}\n" +
                            "\nАркан - ${listArcNames[6]}\n\n${list[6]}"
                )
                tvArchetypeDesc8.text = String.format(
                    "${resources.getString(R.string.arc_pos8)}\n" +
                            "\nАркан - ${listArcNames[7]}\n\n${list[7]}"
                )
                tvArchetypeDesc9.text = String.format(
                    "${resources.getString(R.string.arc_pos9)}\n" +
                            "\nАркан - ${listArcNames[8]}\n\n${list[8]}"
                )

                cvArchetype1.setOnClickListener {
                    setToggleCardLength(tvArchetypeDesc1)
                }
                cvArchetype2.setOnClickListener {
                    setToggleCardLength(tvArchetypeDesc2)
                }
                cvArchetype3.setOnClickListener {
                    setToggleCardLength(tvArchetypeDesc3)
                }
                cvArchetype4.setOnClickListener {
                    setToggleCardLength(tvArchetypeDesc4)
                }
                cvArchetype5.setOnClickListener {
                    setToggleCardLength(tvArchetypeDesc5)
                }
                cvArchetype6.setOnClickListener {
                    setToggleCardLength(tvArchetypeDesc6)
                }
                cvArchetype7.setOnClickListener {
                    setToggleCardLength(tvArchetypeDesc7)
                }
                cvArchetype8.setOnClickListener {
                    setToggleCardLength(tvArchetypeDesc8)
                }
                cvArchetype9.setOnClickListener {
                    setToggleCardLength(tvArchetypeDesc9)
                }
            }
        }

    }

    private fun setToggleCardLength(textView: TextView) {
        val state = textView.maxLines
        if (state > 4) {
            textView.maxLines = 4
            textView.setTextColor(Color.parseColor("#b8aaad"))
        } else {
            textView.maxLines = Int.MAX_VALUE
            textView.setTextColor(Color.WHITE)
        }
    }


}