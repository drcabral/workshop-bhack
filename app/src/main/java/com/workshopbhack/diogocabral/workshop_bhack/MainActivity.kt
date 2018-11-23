package com.workshopbhack.diogocabral.workshop_bhack

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var clicked = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myToast = Toast.makeText(applicationContext, "Minha primeira toast", Toast.LENGTH_SHORT)
        myToast.setGravity(Gravity.CENTER, Gravity.CENTER, 0)

        toastButton.setOnClickListener({
            myToast.show()
        })


        generatePhrase.setOnClickListener{
            clicked++
            generatedPhrase.text = "fui clicado! $clicked"
        }

    }
}
