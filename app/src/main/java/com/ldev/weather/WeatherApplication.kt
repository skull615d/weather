package com.ldev.weather

import android.app.Application
import com.ldev.weather.feature.weather_screen.di.appModule as appModuleWeather
import com.ldev.weather.feature.city_screen.di.appModule as appModuleCity
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