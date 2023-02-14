package com.example.gromik2sem1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        readFile()

        listView = findViewById(R.id.ListView)
        listView.adapter = MyAdapter(readFile())


    }


    private fun readFile(): List<Humans> {
        val content = assets.open("test.json").bufferedReader().use { it.readText() }
        val listHumans = object : TypeToken<List<Humans>>() {}.type

        return Gson().fromJson(content, listHumans)

//        humans.forEachIndexed { idx, human -> Log.i("data", "> Item $idx:\n$human") }
//
    }
}