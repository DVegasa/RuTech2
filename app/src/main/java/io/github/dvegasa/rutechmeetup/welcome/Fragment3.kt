package io.github.dvegasa.rutechmeetup.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import io.github.dvegasa.rutechmeetup.R
import kotlinx.android.synthetic.main.fragment_3.*
import kotlinx.android.synthetic.main.fragment_3.view.*
import kotlinx.android.synthetic.main.fragment_3.view.rvTags

/**
 * A simple [Fragment] subclass.
 */
class Fragment3 : Fragment() {

    val tags = listOf(
        Tag("Android"),
        Tag("Python"),
        Tag("iOS"),
        Tag("UX/UI дизайн"),
        Tag("Маркетинг"),
        Tag("GameDev"),
        Tag("Блоггинг"),
        Tag("Front-end"),
        Tag("Back-end"),
        Tag("Hardware")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_3, container, false)

        v.btn3.setOnClickListener {
            (activity as WelcomeActivity).tags = tags
            (activity as WelcomeActivity).nextPage()
        }

        val adapter = RvTagsAdapter(tags)
        v.rvTags.layoutManager = LinearLayoutManager(context)
        v.rvTags.adapter = adapter


        return v
    }
    companion object {
        @JvmStatic
        fun newInstance() = Fragment3()
    }
}
