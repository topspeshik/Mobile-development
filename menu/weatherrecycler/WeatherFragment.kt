package com.example.weatherrecycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.weatherrecycler.databinding.FragmentWeatherBinding


class WeatherFragment : Fragment() {

    private val args by navArgs<WeatherFragmentArgs>()

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            with(args.weatherData){
                tvCityName.text = name
                tvTemp.text = temperature.temp
                tvHumidity.text = temperature.humidity
                tvPressure.text = temperature.pressure
                tvTempFeel.text = temperature.feels_like
                tvTempMax.text = temperature.temp_max
                tvTempMin.text = temperature.temp_min
            }
        }

    }
}