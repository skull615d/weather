package com.afanasyeva656.weather.feature.weather_screen.data.api

interface WeatherRepo {
    suspend fun getWeather(): String
}