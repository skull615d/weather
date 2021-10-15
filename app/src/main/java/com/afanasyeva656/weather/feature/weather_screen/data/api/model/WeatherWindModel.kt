package com.afanasyeva656.weather.feature.weather_screen.data.api.model

import com.google.gson.annotations.SerializedName
/*"wind": {
    "speed": 1.5,
    "deg": 350
}*/
class WeatherWindModel(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val degree: Int
) {
}