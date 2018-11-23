package com.workshopbhack.diogocabral.workshop_bhack

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var clicked = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generatePhrase.setOnClickListener{
            clicked++
            generatedPhrase.text = getString(R.string.button_clicked_counter, clicked.toString())

            val intent =  Intent(this, SecondActivity::class.java)
            intent.putExtra("clicked", clicked)

            startActivity(intent)
        }

    }
}
