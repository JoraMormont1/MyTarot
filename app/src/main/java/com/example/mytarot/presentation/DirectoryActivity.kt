package com.example.mytarot.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.mytarot.R

class DirectoryActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_directory)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.cardList.observe(this) {
            Log.d("Tag_VMM", it.toString())
        }
    }
}