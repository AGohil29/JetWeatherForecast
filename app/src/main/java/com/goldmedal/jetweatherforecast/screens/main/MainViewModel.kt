package com.goldmedal.jetweatherforecast.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goldmedal.jetweatherforecast.data.DataOrException
import com.goldmedal.jetweatherforecast.model.Weather
import com.goldmedal.jetweatherforecast.model.WeatherItem
import com.goldmedal.jetweatherforecast.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel() {

    suspend fun getWeatherData(city: String): DataOrException<Weather, Boolean, Exception> {
        return repository.getWeather(city)
    }
}