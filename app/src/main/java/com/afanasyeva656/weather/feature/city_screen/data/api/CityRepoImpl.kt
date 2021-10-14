package com.afanasyeva656.weather.feature.city_screen.data.api

import com.afanasyeva656.weather.feature.city_screen.data.toDomain
import com.afanasyeva656.weather.feature.city_screen.domain.model.CityDomainModel

class CityRepoImpl(val source: CityRemoteSource):CityRepo {
    override suspend fun getCities(prefixName: String): CityDomainModel {
        return source.getCities(prefixName, "5","0").toDomain()
    }
}