package io.github.dvegasa.rutechmeetup.welcome

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
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
    var photo: Bitmap? = null

    private val nsvpAdapter = NsvpAdapter(frags, supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initNsvp()

        btnConfirm.setOnClickListener {
            endRegistration()
        }

        btnPhotoAgain.setOnClickListener {
            makePhoto()
        }
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

    private fun showPreview() {
        nsvp.visibility = View.GONE
        ivPreview.setImageBitmap(photo)
    }

    fun makePhoto() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, 42)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 42 && resultCode == RESULT_OK) {
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            photo = imageBitmap
            showPreview()
        }
    }

}
