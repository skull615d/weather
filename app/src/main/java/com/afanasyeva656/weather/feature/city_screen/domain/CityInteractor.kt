package com.afanasyeva656.weather.feature.city_screen.domain

import com.afanasyeva656.weather.base.attempt
import com.afanasyeva656.weather.feature.city_screen.data.api.CityRepo

class CityInteractor(private val repository: CityRepo) {
    suspend fun getCities(prefixName: String) = attempt { repository.getCities(prefixName) }
}