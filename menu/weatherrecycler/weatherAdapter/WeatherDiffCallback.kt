package com.example.weatherrecycler.weatherAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherrecycler.data.WeatherData


object WeatherDiffCallback : DiffUtil.ItemCallback<WeatherData>() {

    override fun areItemsTheSame(oldItem: WeatherData, newItem: WeatherData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: WeatherData, newItem: WeatherData): Boolean {
        return oldItem == newItem
    }
}