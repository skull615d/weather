package com.afanasyeva656.weather.feature.city_screen.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afanasyeva656.weather.feature.city_screen.domain.CityInteractor
import com.afanasyeva656.weather.feature.city_screen.domain.model.CityDomainModel
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import kotlinx.coroutines.launch

class CityScreenViewModel(private  val cityInteractor: CityInteractor): ViewModel() {

    val lifeData: MutableLiveData<CityDomainModel> = MutableLiveData()

    fun requestCities(prefixName: String){
        viewModelScope.launch {
            lifeData.postValue(cityInteractor.getCities(prefixName))
        }
    }
}