package com.afanasyeva656.weather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import by.kirich1409.viewbindingdelegate.viewBinding
import com.afanasyeva656.weather.databinding.ActivityMainBinding
import com.afanasyeva656.weather.feature.weather_screen.ui.WeatherScreenActivity
import com.afanasyeva656.weather.feature.wind_screen.ui.WindScreenActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherButton = findViewById<Button>(R.id.weatherButton)
        weatherButton.setOnClickListener {
            Intent(this, WeatherScreenActivity::class.java).also { startActivity(it) }
        }

    }
}