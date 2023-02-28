package com.example.weatherrecycler

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherrecycler.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.io.InputStream
import java.net.URL
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
    private suspend fun loadWeather(cityy: String?) {
        val API_KEY = getString(R.string.API_KEY) // TODO: ключ загрузить из строковых ресурсов
        // TODO: в строку подставлять API_KEY и город (выбирается из списка или вводится в поле)
        val city = "Irkutsk"
        val weatherURL = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$API_KEY&units=metric"

        try {

            val stream = withContext(Dispatchers.IO) {
                URL(weatherURL).content
            } as InputStream
            Log.d("mainddd", stream.toString())
            val data = Scanner(stream).nextLine()
            val weather = Gson().fromJson(data, WeatherData::class.java)
            Log.d("mainddd", weather.toString())

        } catch (e: java.lang.Exception)
        {
            Log.d("mainddd", "error")

        }

    }
    @OptIn(DelicateCoroutinesApi::class)
    fun onClick(v: View) {
        val city = binding.etCity.text.toString()
        // Используем IO-диспетчер вместо Main (основного потока)
        GlobalScope.launch (Dispatchers.IO) {
            loadWeather(city)
        }
    }
}
