package com.afanasyeva656.weather

import com.afanasyeva656.weather.feature.weather_screen.data.api.WeatherRepo
import java.math.BigDecimal

class MockWeatherRepo : WeatherRepo {
    companion object {
        private val DEFAULT_WEATHER = "В Москве сегодня солнечно"
        private val EMPTY_STRING = ""
    }

    private val weatherYandex = hashMapOf<String, BigDecimal>(
        "Zurich" to BigDecimal("-11.3"),
        "Tokyo" to BigDecimal("15"),
        "New York" to BigDecimal("0"),
        "London" to BigDecimal("-7"),
        "Paris" to BigDecimal("15.1"),
        "Moscow" to BigDecimal("25.6")
    )

    override suspend fun getWeather(): String =
        weatherYandex
//            .filterValues { it > BigDecimal.ZERO }
            .map { (city, temperature) ->
                when {
                    temperature.compareTo(BigDecimal.ZERO) == 0 -> "В городе $city нулевая температура"
                    temperature > BigDecimal.ZERO -> "В городе $city тепло"
                    else -> "В городе $city холодно"
                }
            }.joinToString(
                separator = "\n"
            )
}