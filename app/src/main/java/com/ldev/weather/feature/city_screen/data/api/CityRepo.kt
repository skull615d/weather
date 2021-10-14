package com.ldev.weather.feature.city_screen.data.api

import com.ldev.weather.feature.city_screen.domain.model.CityDomainModel

interface CityRepo {
    suspend fun getCities(prefixName: String): CityDomainModel
}