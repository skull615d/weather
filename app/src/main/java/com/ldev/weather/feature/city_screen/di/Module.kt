package com.ldev.weather.feature.city_screen.di

import com.ldev.weather.feature.city_screen.data.api.CityApi
import com.ldev.weather.feature.city_screen.data.api.CityRemoteSource
import com.ldev.weather.feature.city_screen.data.api.CityRepo
import com.ldev.weather.feature.city_screen.data.api.CityRepoImpl
import com.ldev.weather.feature.city_screen.domain.CityInteractor
import com.ldev.weather.feature.city_screen.ui.CityScreenViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://geodb-free-service.wirefreethought.com/"
val appModule = module {

    single<OkHttpClient> (named("http2")) {
        OkHttpClient.Builder()
            .build()
    }

    single<Retrofit>( named("retrofit2")) {
        Retrofit.Builder()
            .baseUrl(com.ldev.weather.feature.city_screen.di.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named("http2")))
            .build()
    }

    single<CityApi> {
        get<Retrofit>(named("retrofit2")).create(CityApi::class.java)
    }

    single<CityRemoteSource> {
        CityRemoteSource(get<CityApi>())
    }


    single<CityRepo> {
        CityRepoImpl(get<CityRemoteSource>())
    }

    single<CityInteractor> {
        CityInteractor(get<CityRepo>())
    }

    viewModel {
        CityScreenViewModel(get<CityInteractor>())
    }
}