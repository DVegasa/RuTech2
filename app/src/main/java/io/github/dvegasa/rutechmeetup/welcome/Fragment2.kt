package io.github.dvegasa.rutechmeetup.welcome

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.dvegasa.rutechmeetup.R
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_1.view.*
import kotlinx.android.synthetic.main.fragment_2.*
import kotlinx.android.synthetic.main.fragment_2.view.*
import kotlinx.android.synthetic.main.fragment_2.view.etJob

/**
 * A simple [Fragment] subclass.
 */
class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_2, container, false)

        val span = SpannableString("Кем ты\nработаешь?")
        span.setSpan(
            ForegroundColorSpan(Color.parseColor("#FFCC00")),
            0, 4,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        v.tvWhatJob.text = span

        v.btn2.setOnClickListener {
            (activity as WelcomeActivity).job = etJob.text.toString()
            (activity as WelcomeActivity).nextPage()
        }
        return v
    }
    companion object {
        @JvmStatic
        fun newInstance() = Fragment2()
    }
}
