package com.example.recyclerviewcolorsk

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // TODO: реализовать генерацию цветов определённой палитры
    private val colorsList = mutableListOf(Color.YELLOW, Color.RED, Color.GREEN, Color.MAGENTA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // пример использования RecyclerView с собственным адаптером
        val rv = findViewById<RecyclerView>(R.id.rview)
        val colorAdapter = ColorAdapter(LayoutInflater.from(this))
        // добавляем данные в список для отображения
        colorAdapter.submitList(genColorList("Lights"))
        colorAdapter.onItemClickListener = {
            Toast.makeText(
                applicationContext,
                "Color $it",
                Toast.LENGTH_SHORT).show();

        }
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = colorAdapter

    }

    private fun genColorList(color: String) : MutableList<Int>{
        return when(color){
            "Gray" -> mutableListOf(Color.GRAY, Color.DKGRAY, Color.LTGRAY)
            "Lights" -> mutableListOf(Color.YELLOW, Color.GREEN, Color.RED)
            else -> mutableListOf(Color.BLACK, Color.WHITE)
        }
    }

}