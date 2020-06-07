package io.github.dvegasa.rutechmeetup.welcome

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener

import io.github.dvegasa.rutechmeetup.R
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_1.view.*

/**
 * A simple [Fragment] subclass.
 */
class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_1, container, false)

        val span = SpannableString("Как тебя\nзовут?")
        span.setSpan(
            ForegroundColorSpan(Color.parseColor("#FFCC00")),
            9, 14,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        v.tvWhatName.text = span

        v.btn1.setOnClickListener {
            (activity as WelcomeActivity).name = etName.text.toString()
            (activity as WelcomeActivity).nextPage()
        }

        return v
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }

}
