package com.ldev.weather.feature.weather_screen.domain

import com.ldev.weather.feature.weather_screen.data.api.WeatherRepo
import com.ldev.weather.feature.weather_screen.domain.model.WeatherDomainModel

// можем объединить тут несколько репозиториев
class WeatherInteractor(private val repository: WeatherRepo) {
    suspend fun getWeather(city: String): WeatherDomainModel {
        return repository.getWeather(city)
    }
}