package com.afanasyeva656.weather.feature.weather_screen.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import com.afanasyeva656.weather.R
import com.afanasyeva656.weather.databinding.ActivityWeatherBinding
import com.afanasyeva656.weather.feature.city_screen.ui.CityScreenViewModel
import com.afanasyeva656.weather.feature.wind_screen.ui.WindScreenActivity
import com.afanasyeva656.weather.utils.setDebouncingTextListener
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent
import com.afanasyeva656.weather.feature.city_screen.ui.UiEvent as CityScreenUiEvent
import com.afanasyeva656.weather.feature.city_screen.ui.ViewState as CityScreenViewState

class WeatherScreenActivity : AppCompatActivity(), KoinComponent {
    val weatherViewModel by viewModel<WeatherScreenViewModel>()
    val cityViewModel by viewModel<CityScreenViewModel>()
    private val binding: ActivityWeatherBinding by viewBinding(ActivityWeatherBinding::bind)
    var speed: Double = 0.0
    var degree: Int = 0
    private lateinit var adapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        weatherViewModel.viewState.observe(this, Observer(::renderWeather))
        cityViewModel.viewState.observe(this, Observer(::renderCity))
        with(binding) {
            actvCity.setDebouncingTextListener {
                cityViewModel.processUiEvent(CityScreenUiEvent.GetCity(it))
            }
            actvCity.setOnItemClickListener { adapterView, view, i, l ->
                val city = adapter.getItem(i) ?: ""
                weatherViewModel.processUiEvent(UiEvent.GetWeather(city))
                binding.tvCity.text = getString(R.string.city, city)
            }
            bWind.setOnClickListener {
                val intent = Intent(this@WeatherScreenActivity, WindScreenActivity::class.java)
                intent.putExtra("speed", speed)
                intent.putExtra("degree", degree)
                startActivity(intent)
            }
        }
    }

    private fun renderWeather(viewState: ViewState) {
        val state = viewState.weatherData
        with(binding) {
            tvTempeture.text = getString(R.string.temperature, state.temperature)
            tvHumidity.text = getString(R.string.humidity, state.humidity)
            tvTempMax.text = getString(R.string.temperature_max, state.tempMax)
            tvTempMin.text = getString(R.string.temperature_min, state.tempMin)
            speed = state.windDomainModel.speed
            degree = state.windDomainModel.degree
        }
    }

    private fun renderCity(state: CityScreenViewState) {
        adapter = ArrayAdapter<String>(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            state.cityDomainModel.cities
        )
        with(binding) {
            actvCity.setAdapter(adapter)
        }
    }
}