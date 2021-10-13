package com.afanasyeva656.weather.feature.weather_screen.data.api

class WeatherRepoImpl(private val source: WeatherRemoteSource): WeatherRepo {
    override suspend fun getWeather(): String {
        return source.getWeather("").main.temp
    }
}