package com.goldmedal.jetweatherforecast.network

import com.goldmedal.jetweatherforecast.model.WeatherItem
import com.goldmedal.jetweatherforecast.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET(value = "data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("appid") appId: String = Constants.API_KEY,
        @Query("units") units: String = "imperial"
    ): WeatherItem
}