package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var movies:  ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movies = resources.getStringArray(R.array.movies).toCollection(ArrayList())


        buttonGo.setOnClickListener{
            val intent  = Intent(this, GuessActivity::class.java)
            intent.putExtra("left", editTextLeft.text.toString().toInt())
            intent.putExtra("right", editTextRight.text.toString().toInt())
            startActivity(intent)
        }

    }
}