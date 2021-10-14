package com.ldev.weather.feature.weather_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ldev.weather.feature.weather_screen.domain.WeatherInteractor
import com.ldev.weather.feature.weather_screen.domain.model.WeatherDomainModel
import kotlinx.coroutines.launch

class WeatherScreenViewModel(private val weatherInteractor: WeatherInteractor) : ViewModel(){
    val lifeData: MutableLiveData<WeatherDomainModel> = MutableLiveData()

    fun requestWeather(city: String) {
        viewModelScope.launch {
            lifeData.postValue(weatherInteractor.getWeather(city))
        }
    }
}