package com.afanasyeva656.weather.feature.weather_screen.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.coroutineScope
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherScreenActivity: AppCompatActivity() {
    val weatherScreenViewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}