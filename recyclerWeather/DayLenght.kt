package com.example.weatherrecycler

class DayLenght {

    var dayLength: Int = 0
        set(value) {
            field = value / 3600
        }


}