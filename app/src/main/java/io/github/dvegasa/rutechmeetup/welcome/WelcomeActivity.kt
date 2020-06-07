package io.github.dvegasa.rutechmeetup.welcome

import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.github.dvegasa.rutechmeetup.R
import io.github.dvegasa.rutechmeetup.main.MainActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import java.io.ByteArrayOutputStream
import kotlin.random.Random


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
    var tags: List<Tag>? = null

    private val nsvpAdapter = NsvpAdapter(frags, supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initNsvp()

        btnConfirm.setOnClickListener {
            btnConfirm.visibility = View.INVISIBLE
            btnConfirm.isEnabled = false
            endRegistration()
        }

        btnPhotoAgain.setOnClickListener {
            makePhoto()
        }
    }

    fun endRegistration() {
        val bitmap: Bitmap =
            photo ?: BitmapFactory.decodeResource(resources, R.drawable.ava_no_photo)
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray: ByteArray = byteArrayOutputStream.toByteArray()
        val encoded: String = Base64.encodeToString(byteArray, Base64.DEFAULT)
        Log.d("ed__", "Base64:\n$encoded")

        val uid: String = "" + System.currentTimeMillis() + "" + Random.nextInt(100, 999)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
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
