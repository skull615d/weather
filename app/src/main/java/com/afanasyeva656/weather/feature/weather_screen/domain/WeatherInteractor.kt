package com.afanasyeva656.weather.feature.weather_screen.domain

import com.afanasyeva656.weather.feature.weather_screen.data.api.WeatherRepo

// можем объединить тут несколько репозиториев
class WeatherInteractor(private val repository: WeatherRepo) {
    suspend fun getWeather(): String {
        return repository.getWeather()
    }
}