package com.goldmedal.jetweatherforecast.screens.main

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.goldmedal.jetweatherforecast.data.DataOrException
import com.goldmedal.jetweatherforecast.model.Weather

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = mainViewModel.getWeatherData(city = "Mumbai")
    }.value

    if (weatherData.loading == true) {
        CircularProgressIndicator()
    } else if (weatherData.data != null) {
        MainScaffold(weatherData.data!!, navController)
    }
}

@Composable
fun MainScaffold(weather: Weather, navController: NavController) {

    Scaffold(topBar = {
        WeatherAppBar(title = "${weather.city.name}, ${weather.city.country}",
            navController = navController,
            elevation = 6.dp) {
            Log.d("TAG", "MainScaffold: Button Clicked")
        }
    }) {
        MainContent(weather, it)
    }

}

@Composable
fun MainContent(weather: Weather, paddingValues: PaddingValues) {
    Text(text = weather.city.name)
}
