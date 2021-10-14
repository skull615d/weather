package com.afanasyeva656.weather.feature.city_screen.data.api

import com.afanasyeva656.weather.feature.city_screen.data.api.model.CityModel

class CityRemoteSource(private val api: CityApi) {
    suspend fun getCities(prefixName: String, limit: String, offset: String): CityModel{
        return api.getCities(prefixName,false,limit,offset)
    }
}