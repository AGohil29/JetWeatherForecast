package com.goldmedal.jetweatherforecast.repository

import com.goldmedal.jetweatherforecast.data.DataOrException
import com.goldmedal.jetweatherforecast.model.WeatherItem
import com.goldmedal.jetweatherforecast.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(cityQuery: String) : DataOrException<WeatherItem, Boolean, Exception> {
         val response = try {
             api.getWeather(query = cityQuery)
         } catch (e: Exception) {
             return DataOrException(e = e)
         }

        return DataOrException(data = response)
    }
}