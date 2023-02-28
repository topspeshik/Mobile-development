package com.example.recyclerweather

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerweather.databinding.ActivityMainBinding
import com.example.recyclerweather.weatherAdapter.WeatherAdapter
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.io.InputStream
import java.net.URL
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var weatherAdapter: WeatherAdapter
    private var weatherList = mutableListOf<WeatherData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        weatherAdapter = WeatherAdapter()
        binding.rvWeather.adapter = weatherAdapter
        binding.btnSubmit.setOnClickListener{
            buttonListener()
        }


    }
    private suspend fun loadWeather(city: String?) {
        val API_KEY = getString(R.string.API_KEY) // TODO: ключ загрузить из строковых ресурсов
        // TODO: в строку подставлять API_KEY и город (выбирается из списка или вводится в поле)
        val weatherURL = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$API_KEY&units=metric"

        try {

            val stream = withContext(Dispatchers.IO) {
                URL(weatherURL).content
            } as InputStream
            Log.d("mainActivty", stream.toString())
            val data = Scanner(stream).nextLine()
            val weather = Gson().fromJson(data, WeatherData::class.java)
            Log.d("mainActivty", weather.toString())
            weatherList.add(weather)
            withContext(Dispatchers.Main) {
                weatherAdapter.submitList(weatherList)
            }

        } catch (e: java.lang.Exception)
        {
            withContext(Dispatchers.Main) {
                Toast.makeText(applicationContext, "Wrong city name", Toast.LENGTH_SHORT).show()
            }
        }

    }
    @OptIn(DelicateCoroutinesApi::class)
    fun buttonListener() {
        val city = binding.etCity.text.toString()
        // Используем IO-диспетчер вместо Main (основного потока)
        GlobalScope.launch (Dispatchers.IO) {
            loadWeather(city)
        }
    }
}