package com.example.weatherrecycler.weatherAdapter




import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.weatherrecycler.data.WeatherData
import com.example.weatherrecycler.databinding.ItemWeatherBinding

import com.squareup.picasso.Picasso


class WeatherAdapter : ListAdapter<WeatherData, WeatherViewHolder>(WeatherDiffCallback) {

    var onItemClickListener: ((WeatherData) -> Unit)? = null

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

            CardView.setOnClickListener{
                onItemClickListener?.invoke(weatherItem)
            }
        }





    }


}