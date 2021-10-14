package com.ldev.weather.feature.weather_screen.domain.model

data class WeatherDomainModel(
    val temperature: String,
    val humidity: String,
    val tempMax: String,
    val tempMin: String
)