package com.afanasyeva656.weather.feature.weather_screen.data.api

class WeatherRepoImpl(val weatherRemoteSource: WeatherRemoteSource): WeatherRepo {
    override fun getWeather(): String {
        return "-"
    }
}