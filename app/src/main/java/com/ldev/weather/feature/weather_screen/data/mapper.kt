package com.ldev.weather.feature.weather_screen.data

import com.ldev.weather.feature.weather_screen.data.api.model.WeatherModel
import com.ldev.weather.feature.weather_screen.domain.model.WeatherDomainModel

fun WeatherModel.toDomain() : WeatherDomainModel {
    return WeatherDomainModel(
        this.main.temp,
        this.main.humidity,
        this.main.tempMax,
        this.main.tempMin
    )
}