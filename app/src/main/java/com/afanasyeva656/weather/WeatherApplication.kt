package com.afanasyeva656.weather

import android.app.Application
import com.afanasyeva656.weather.feature.weather_screen.di.appModule as appModuleWeather
import com.afanasyeva656.weather.feature.city_screen.di.appModule as appModuleCity
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@WeatherApplication)
            modules(listOf(appModuleWeather,appModuleCity))
        }
    }
}