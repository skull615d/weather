package com.ldev.weather.feature.weather_screen.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ldev.weather.R
import com.ldev.weather.databinding.ActivityWeatherBinding
import com.ldev.weather.feature.city_screen.domain.model.CityDomainModel
import com.ldev.weather.feature.city_screen.ui.CityScreenViewModel
import com.ldev.weather.feature.weather_screen.domain.model.WeatherDomainModel
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherScreenActivity: AppCompatActivity(), TextWatcher {
    val weatherScreenViewModel by viewModel<WeatherScreenViewModel>()
    val cityScreenViewModel by viewModel<CityScreenViewModel>()
    lateinit var binding: ActivityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        weatherScreenViewModel.lifeData.observe(this, Observer(::renderWeather))
        weatherScreenViewModel.requestWeather("Moscow")
        cityScreenViewModel.lifeData.observe(this, Observer(::renderCity))
        binding.actvCity.addTextChangedListener(this)
        binding.actvCity.setOnItemClickListener { adapterView, view, i, l ->
            val city = cityScreenViewModel.lifeData.value?.cities?.get(i)?:"Moscow"
            weatherScreenViewModel.requestWeather(city)
        }
    }

    private fun renderWeather(state: WeatherDomainModel) {
        binding.tvTempeture.text = "Temperature ${state.temperature}"
        binding.tvHumidity.text = "Humidity ${state.humidity}"
        binding.tvTempMax.text = "Temperature maximum ${state.tempMax}"
        binding.tvTempMin.text = "Temperature minimum ${state.tempMin}"
    }
    private fun renderCity(state: CityDomainModel) {
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, state.cities)
        binding.actvCity.setAdapter(adapter)
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        //TODO("Not yet implemented")
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        //TODO("Not yet implemented")
    }

    override fun afterTextChanged(p0: Editable?) {
        p0?.let {
            cityScreenViewModel.requestCities(it.toString())
        }
    }
}