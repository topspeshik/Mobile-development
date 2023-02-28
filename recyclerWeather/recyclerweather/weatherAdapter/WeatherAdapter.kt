package com.example.recyclerweather.weatherAdapter




import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerweather.R
import com.example.recyclerweather.WeatherData
import com.example.recyclerweather.databinding.ItemWeatherBinding
import com.squareup.picasso.Picasso


class WeatherAdapter : ListAdapter<WeatherData, WeatherViewHolder>(WeatherDiffCallback) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = ItemWeatherBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weatherItem = getItem(position)
        with(holder.binding){
            with(weatherItem){
                tvDescription.text = this.weather[0].description
                tvCity.text = this.name
                tvTemp.text = this.temperature.temp
                Picasso.get().load("http://openweathermap.org/img/w/${this.weather[0].icon}.png").into(ivIcon)


            }
        }



    }


}