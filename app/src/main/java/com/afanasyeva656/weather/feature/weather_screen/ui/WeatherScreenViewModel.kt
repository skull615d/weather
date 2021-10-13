package com.afanasyeva656.weather.feature.weather_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afanasyeva656.weather.feature.weather_screen.domain.WeatherInteractor
import kotlinx.coroutines.launch

class WeatherScreenViewModel(private val weatherInteractor: WeatherInteractor) : ViewModel(){
    private val lifeData: MutableLiveData<String> = MutableLiveData("")

    fun requestWeather() {
        viewModelScope.launch {
            lifeData.postValue(weatherInteractor.getWeather())
        }
    }
}