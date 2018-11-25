package com.workshopbhack.diogocabral.workshop_bhack

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import service.PhraseService
import android.widget.Toast
import entity.PhraseResultEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    var clicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generatedPhrase.text = getString(R.string.main_generated_phrase_text)
        val myToast = Toast.makeText(applicationContext, "Minha primeira toast", Toast.LENGTH_SHORT)
        myToast.setGravity(Gravity.CENTER, Gravity.CENTER, 0)

        toastButton.setOnClickListener({
            myToast.show()
        })


        generatePhrase.setOnClickListener{
            clicked++
            generatedPhrase.text = "fui clicado! $clicked"

            val intent =  Intent(this, SecondActivity::class.java)

            getPhraseFromApi(clicked, intent)
        }

    }

    fun getPhraseFromApi(id: Int, intent: Intent) {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://api.icndb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(PhraseService::class.java)
        val call = api.fetchRandomPhrase(id)

        call.enqueue(object: Callback<PhraseResultEntity> {

            override fun onResponse(call: Call<PhraseResultEntity>, response: Response<PhraseResultEntity>) {
                val phraseResultEntity = response.body()
                intent.putExtra("phrase", phraseResultEntity?.phrase?.joke)
                startActivity(intent)
            }

            override fun onFailure(call: Call<PhraseResultEntity>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
