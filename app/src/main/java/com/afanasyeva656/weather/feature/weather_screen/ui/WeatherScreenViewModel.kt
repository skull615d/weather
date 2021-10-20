package com.afanasyeva656.weather.feature.weather_screen.ui

import com.afanasyeva656.weather.base.BaseViewModel
import com.afanasyeva656.weather.base.Event
import com.afanasyeva656.weather.feature.weather_screen.domain.WeatherInteractor
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel

class WeatherScreenViewModel(private val weatherInteractor: WeatherInteractor) :
    BaseViewModel<ViewState>() {

    /*fun requestWeather(city: String) {
        viewModelScope.launch {
            liveData.postValue(weatherInteractor.getWeather(city))
        }
    }*/

    override fun initialViewState(): ViewState {
        return ViewState(WeatherDomainModel(), "")
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.GetWeather -> {
                weatherInteractor.getWeather(event.city).fold(
                    onError = {
                        processDataEvent(DataEvent.ErrorWeatherRequest(it.localizedMessage ?: ""))
                    },
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessWeatherRequest(it))
                    }
                )
            }
            is DataEvent.OnLoadData -> {

            }
            is DataEvent.SuccessWeatherRequest -> {
                return previousState.copy(weatherData = event.weatherData)
            }
            is DataEvent.ErrorWeatherRequest -> {

            }
        }
        return null
    }
}