package com.example.weatherrecycler

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.weatherrecycler.data.WeatherData
import com.example.weatherrecycler.databinding.FragmentMainBinding
import com.example.weatherrecycler.weatherAdapter.WeatherAdapter
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.io.InputStream
import java.net.URL
import java.util.*


class MainFragment : Fragment() {

    private lateinit var weatherAdapter: WeatherAdapter
    private var weatherList = mutableListOf<WeatherData>()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherAdapter = WeatherAdapter()
        binding.rvWeather.adapter = weatherAdapter
        weatherAdapter.submitList(weatherList)
        binding.btnSubmit.setOnClickListener{
            buttonListener()
        }
        weatherAdapter.onItemClickListener = {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToWeatherFragment(it))
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
                Toast.makeText(binding.root.context, "Wrong city name", Toast.LENGTH_SHORT).show()
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