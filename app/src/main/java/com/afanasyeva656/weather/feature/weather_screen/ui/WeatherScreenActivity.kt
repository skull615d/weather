package com.afanasyeva656.weather.feature.weather_screen.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import com.afanasyeva656.weather.R
import com.afanasyeva656.weather.databinding.ActivityWeatherBinding
import com.afanasyeva656.weather.feature.city_screen.domain.model.CityDomainModel
import com.afanasyeva656.weather.feature.city_screen.ui.CityScreenViewModel
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.afanasyeva656.weather.feature.wind_screen.ui.WindScreenActivity
import com.afanasyeva656.weather.utils.setDebouncingTextListener
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class WeatherScreenActivity : AppCompatActivity(), KoinComponent {
    val weatherScreenViewModel by viewModel<WeatherScreenViewModel>()
    val cityScreenViewModel by viewModel<CityScreenViewModel>()
    private val binding: ActivityWeatherBinding by viewBinding(ActivityWeatherBinding::bind)
    var city: String = "Moscow"
    var speed: Double = 0.0
    var degree: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        weatherScreenViewModel.liveData.observe(this, Observer(::renderWeather))
        weatherScreenViewModel.requestWeather(city)
        cityScreenViewModel.lifeData.observe(this, Observer(::renderCity))
        with(binding) {
            actvCity.setDebouncingTextListener {
                cityScreenViewModel.requestCities(it)
            }
            actvCity.setOnItemClickListener { adapterView, view, i, l ->
                city = cityScreenViewModel.lifeData.value?.cities?.get(i) ?: city
                weatherScreenViewModel.requestWeather(city)
            }
            bWind.setOnClickListener {
                val intent = Intent(this@WeatherScreenActivity,WindScreenActivity::class.java)
                intent.putExtra("speed",speed)
                intent.putExtra("degree",degree)
                startActivity(intent)
            }
        }
    }

    private fun renderWeather(state: WeatherDomainModel) {
        with(binding) {
            tvTempeture.text = getString(R.string.temperature, state.temperature)
            tvHumidity.text = getString(R.string.humidity, state.humidity)
            tvTempMax.text = getString(R.string.temperature_max, state.tempMax)
            tvTempMin.text = getString(R.string.temperature_min, state.tempMin)
            speed = state.windDomainModel.speed
            degree = state.windDomainModel.degree
        }
    }

    private fun renderCity(state: CityDomainModel) {
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, state.cities)
        with(binding) {
            actvCity.setAdapter(adapter)
        }
    }
}