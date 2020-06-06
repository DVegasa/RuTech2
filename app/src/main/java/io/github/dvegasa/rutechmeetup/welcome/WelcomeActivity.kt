package io.github.dvegasa.rutechmeetup.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.dvegasa.rutechmeetup.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    private val frags = listOf(
        Fragment0.newInstance(),
        Fragment1.newInstance(),
        Fragment2.newInstance(),
        Fragment3.newInstance(),
        Fragment4.newInstance()
    )

    var name: String = ""
    var job: String = ""

    private val nsvpAdapter = NsvpAdapter(frags, supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initNsvp()
    }

    fun endRegistration() {

    }

    fun nextPage() {
        nsvp.currentItem++
    }

    private fun initNsvp() {
        nsvp.adapter = nsvpAdapter
        nsvp.currentItem = 0
    }
}
