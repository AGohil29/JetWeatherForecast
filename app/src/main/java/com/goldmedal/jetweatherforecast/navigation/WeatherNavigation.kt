package com.goldmedal.jetweatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.goldmedal.jetweatherforecast.screens.about.AboutScreen
import com.goldmedal.jetweatherforecast.screens.favorite.FavoritesScreen
import com.goldmedal.jetweatherforecast.screens.main.MainScreen
import com.goldmedal.jetweatherforecast.screens.main.MainViewModel
import com.goldmedal.jetweatherforecast.screens.search.SearchScreen
import com.goldmedal.jetweatherforecast.screens.settings.SettingsScreen
import com.goldmedal.jetweatherforecast.screens.splash.WeatherSplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WeatherScreens.SplashScreen.name) {
        composable(WeatherScreens.SplashScreen.name) {
            WeatherSplashScreen(navController)
        }

        // www.google.com/city=mumbai
        val route = WeatherScreens.MainScreen.name
        composable("$route/{city}", arguments = listOf(
            navArgument("city") {
                type = NavType.StringType
            }
        )) { navBack ->
            navBack.arguments?.getString("city").let { city ->
                val mainViewModel = hiltViewModel<MainViewModel>()
                MainScreen(navController, mainViewModel, city = city)
            }
        }

        composable(WeatherScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }

        composable(WeatherScreens.AboutScreen.name) {
            AboutScreen(navController = navController)
        }

        composable(WeatherScreens.SettingsScreen.name) {
            SettingsScreen(navController = navController)
        }

        composable(WeatherScreens.FavoriteScreen.name) {
            FavoritesScreen(navController = navController)
        }
    }
}