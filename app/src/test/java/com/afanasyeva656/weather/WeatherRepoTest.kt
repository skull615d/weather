package com.afanasyeva656.weather

import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class WeatherRepoTest {
    @Test
    fun testWeather() {
        val mockWeatherRepo = MockWeatherRepo()
        val weather = mockWeatherRepo.getWeather()
        println(weather)
        Assert.assertTrue(weather.isNotEmpty())
    }
}