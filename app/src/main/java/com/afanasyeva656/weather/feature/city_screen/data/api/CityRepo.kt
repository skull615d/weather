package com.afanasyeva656.weather.feature.city_screen.data.api

import com.afanasyeva656.weather.feature.city_screen.domain.model.CityDomainModel

interface CityRepo {
    suspend fun getCities(prefixName: String): CityDomainModel
}