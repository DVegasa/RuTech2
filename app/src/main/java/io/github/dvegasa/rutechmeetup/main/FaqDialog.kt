package io.github.dvegasa.rutechmeetup.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import io.github.dvegasa.rutechmeetup.R
import kotlinx.android.synthetic.main.layout_faq_dialog.view.*

/**
 * Created by Ed Khalturin @DVegasa
 */
class FaqDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.layout_faq_dialog, container, false)
        v.btnStart.setOnClickListener {
            dismiss()
        }

        if (dialog != null && dialog!!.window != null) {
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        }

        return v
    }
}