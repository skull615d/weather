package com.afanasyeva656.weather.feature.city_screen.ui

import androidx.lifecycle.MutableLiveData

import com.afanasyeva656.weather.base.BaseViewModel
import com.afanasyeva656.weather.base.Event
import com.afanasyeva656.weather.feature.city_screen.domain.CityInteractor
import com.afanasyeva656.weather.feature.city_screen.domain.model.CityDomainModel

class CityScreenViewModel(private val cityInteractor: CityInteractor) : BaseViewModel<ViewState>() {

    val lifeData: MutableLiveData<CityDomainModel> = MutableLiveData()

    override fun initialViewState(): ViewState {
        return ViewState(CityDomainModel(), "")
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.GetCity -> {
                cityInteractor.getCities(event.prefixName).fold(
                    onError = {
                        processDataEvent(DataEvent.ErrorWeatherRequest(it.localizedMessage ?: ""))
                    },
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessWeatherRequest(it))
                    }
                )
            }
            is DataEvent.OnLoadData -> {

            }
            is DataEvent.SuccessWeatherRequest -> {
                return previousState.copy(cityDomainModel = event.cityDomainModel)
            }
            is DataEvent.ErrorWeatherRequest -> {

            }
        }
        return null
    }
}