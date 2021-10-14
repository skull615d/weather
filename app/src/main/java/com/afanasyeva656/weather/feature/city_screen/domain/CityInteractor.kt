package com.afanasyeva656.weather.feature.city_screen.domain

import com.afanasyeva656.weather.feature.city_screen.data.api.CityRepo
import com.afanasyeva656.weather.feature.city_screen.domain.model.CityDomainModel

class CityInteractor(private val repository: CityRepo) {
    suspend fun getCities(prefixName: String): CityDomainModel{
        return repository.getCities(prefixName)
    }
}