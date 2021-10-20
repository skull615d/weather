package com.afanasyeva656.weather.feature.weather_screen.ui

import com.afanasyeva656.weather.base.Event
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel

data class ViewState(
    val weatherData: WeatherDomainModel,
    val errorMessage: String
)

sealed class UiEvent : Event {
    data class GetWeather(val city: String) : UiEvent()
}

sealed class DataEvent : Event {
    object OnLoadData : DataEvent()
    data class SuccessWeatherRequest(val weatherData: WeatherDomainModel) : DataEvent()
    data class ErrorWeatherRequest(val errorMessage: String) : DataEvent()
}