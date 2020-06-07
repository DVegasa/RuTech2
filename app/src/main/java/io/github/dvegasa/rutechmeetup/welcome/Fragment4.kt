package io.github.dvegasa.rutechmeetup.welcome

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.dvegasa.rutechmeetup.R
import kotlinx.android.synthetic.main.fragment_2.view.*
import kotlinx.android.synthetic.main.fragment_4.*
import kotlinx.android.synthetic.main.fragment_4.view.*
import kotlinx.android.synthetic.main.fragment_4.view.ivAddPhoto

/**
 * A simple [Fragment] subclass.
 */
class Fragment4 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_4, container, false)

        val span = SpannableString("Загрузи свою\nфотографию")
        span.setSpan(
            ForegroundColorSpan(Color.parseColor("#FFCC00")),
            7, 23,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        v.tvUploadPhoto.text = span

        v.btn4.setOnClickListener {
            v.btn4.visibility = View.INVISIBLE
            v.btn4.isEnabled = false
            (activity as WelcomeActivity).endRegistration()
        }
        v.ivAddPhoto.setOnClickListener {
            (activity as WelcomeActivity).makePhoto()
        }
        return v
    }

    override fun onResume() {
        super.onResume()
        if ((activity as WelcomeActivity).photo != null) {
            ivAddPhoto.setImageBitmap((activity as WelcomeActivity).photo)

        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = Fragment4()
    }
}
