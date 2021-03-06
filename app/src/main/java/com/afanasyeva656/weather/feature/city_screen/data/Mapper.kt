package com.afanasyeva656.weather.feature.city_screen.data

import android.util.Log
import com.afanasyeva656.weather.feature.city_screen.data.api.model.CityModel
import com.afanasyeva656.weather.feature.city_screen.domain.model.CityDomainModel

fun CityModel.toDomain(): CityDomainModel{
    val filterList = this.data.filter { it.type=="CITY"}
    val mapList = filterList.map { it.city }
    val sortedList = mapList.sortedBy { it }

    return CityDomainModel(
        sortedList
    )
}