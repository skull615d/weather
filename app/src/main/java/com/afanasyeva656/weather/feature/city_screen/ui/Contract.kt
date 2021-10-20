package com.afanasyeva656.weather.feature.city_screen.ui

import com.afanasyeva656.weather.base.Event
import com.afanasyeva656.weather.feature.city_screen.domain.model.CityDomainModel

data class ViewState(
    val cityDomainModel: CityDomainModel,
    val errorMessage: String
)

sealed class UiEvent : Event {
    data class GetCity(val prefixName: String) : UiEvent()
}

sealed class DataEvent : Event {
    object OnLoadData : DataEvent()
    data class SuccessWeatherRequest(val cityDomainModel: CityDomainModel) : DataEvent()
    data class ErrorWeatherRequest(val errorMessage: String) : DataEvent()
}