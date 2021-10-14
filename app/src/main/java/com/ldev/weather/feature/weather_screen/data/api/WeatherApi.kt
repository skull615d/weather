package com.ldev.weather.feature.weather_screen.data.api

import com.ldev.weather.feature.weather_screen.data.api.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

// api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") appId: String = "db7cb225f53464f43cc2d30475aff794",
        @Query("units") units: String = "metric"
    ) : WeatherModel
}