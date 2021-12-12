package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.infra.MotivationContants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)
        textName.text = mSecurityPreferences.getString(MotivationContants.KEY.PERSON_NAME)

        buttonNewPhrase.setOnClickListener (this)
        imageFeliz.setOnClickListener (this)
        imageInfinity.setOnClickListener (this)
        imageSolzinho.setOnClickListener (this)
    }

    override fun onClick(view: View) {
        val id = view.id

        val listFilter = listOf(R.id.imageInfinity, R.id.imageFeliz, R.id.imageSolzinho)

        if (id == R.id.buttonNewPhrase) {
            handleNewPhrase()

        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun handleFilter(id: Int) {

        imageInfinity.setColorFilter((resources.getColor(R.color.white)))
        imageFeliz.setColorFilter((resources.getColor(R.color.white)))
        imageSolzinho.setColorFilter((resources.getColor(R.color.white)))


        when (id) {
            R.id.imageInfinity -> {
                imageInfinity.setColorFilter((resources.getColor(R.color.colorAccent)))

            }
            R.id.imageFeliz -> {
                imageFeliz.setColorFilter((resources.getColor(R.color.colorAccent)))

            }
            R.id.imageSolzinho -> {
                imageSolzinho.setColorFilter((resources.getColor(R.color.colorAccent)))

            }

        }
    }

    private fun handleNewPhrase() {

    }
}