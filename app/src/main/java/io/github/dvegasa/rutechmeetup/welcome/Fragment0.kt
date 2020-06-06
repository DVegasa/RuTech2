package io.github.dvegasa.rutechmeetup.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.dvegasa.rutechmeetup.R
import io.github.dvegasa.rutechmeetup.main.MainActivity
import kotlinx.android.synthetic.main.fragment_0.view.*


class Fragment0 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_0, container, false)

        v.btn0.setOnClickListener {
            (activity as WelcomeActivity).nextPage()
        }

        return v
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment0()
    }
}
