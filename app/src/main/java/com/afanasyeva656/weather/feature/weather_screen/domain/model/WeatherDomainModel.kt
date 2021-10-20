package com.afanasyeva656.weather.feature.weather_screen.domain.model

data class WeatherDomainModel(
    val temperature: Double = 0.0,
    val humidity: Int = 0,
    val tempMax: Double = 0.0,
    val tempMin: Double = 0.0,
    val windDomainModel: WindDomainModel = WindDomainModel()
)