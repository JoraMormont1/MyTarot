package com.example.mytarot.presentation

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("cardTitle")
fun bindCardShortTitle(textView: TextView, num: Int, name: String) {
    if(num == 0){
        textView.text = String.format(
            "%s/22 %s",
            num.toString(), name
        )
    } else {
        textView.text = String.format(
            "%s %s",
            num.toString(), name
        )
    }

}