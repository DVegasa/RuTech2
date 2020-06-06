package io.github.dvegasa.rutechmeetup.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
