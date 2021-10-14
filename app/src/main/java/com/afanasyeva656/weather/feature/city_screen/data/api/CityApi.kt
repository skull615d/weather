package com.afanasyeva656.weather.feature.city_screen.data.api

import com.afanasyeva656.weather.feature.city_screen.data.api.model.CityModel
import retrofit2.http.GET
import retrofit2.http.Query
//http://geodb-free-service.wirefreethought.com/
interface CityApi {
    @GET("v1/geo/cities")
    suspend fun getCities(
        @Query("namePrefix") namePrefix: String = "",
        @Query("hateoasMode") hateoasMode: Boolean = false,
        @Query("limit") limit: String = "5",
        @Query("offset") offset: String = "0"
    ): CityModel
}