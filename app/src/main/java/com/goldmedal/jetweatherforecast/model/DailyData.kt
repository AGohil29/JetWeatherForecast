package com.goldmedal.jetweatherforecast.model

data class DailyData(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherItem>,
    val message: Double
)