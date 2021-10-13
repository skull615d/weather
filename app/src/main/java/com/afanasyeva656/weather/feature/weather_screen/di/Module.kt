package com.afanasyeva656.weather.feature.weather_screen.di

import com.afanasyeva656.weather.feature.weather_screen.data.api.WeatherApi
import com.afanasyeva656.weather.feature.weather_screen.data.api.WeatherRemoteSource
import com.afanasyeva656.weather.feature.weather_screen.data.api.WeatherRepo
import com.afanasyeva656.weather.feature.weather_screen.data.api.WeatherRepoImpl
import com.afanasyeva656.weather.feature.weather_screen.domain.WeatherInteractor
import com.afanasyeva656.weather.feature.weather_screen.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "api.openweathermap.org/data/2.5/"
val appModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    // singleton, который входит в API
    single<WeatherApi> {
        get<Retrofit>().create(WeatherApi::class.java)
    }

     single<WeatherRemoteSource> {
        WeatherRemoteSource(get<WeatherApi>())
     }


    single<WeatherRepo> {
        WeatherRepoImpl(get<WeatherRemoteSource>())
    }

    single<WeatherInteractor> {
        WeatherInteractor(get<WeatherRepo>())
    }

    viewModel {
        WeatherScreenViewModel(get<WeatherInteractor>())
    }
}