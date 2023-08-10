package com.goldmedal.jetweatherforecast.screens.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goldmedal.jetweatherforecast.model.Favorite
import com.goldmedal.jetweatherforecast.repository.WeatherDbRepository
import com.goldmedal.jetweatherforecast.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: WeatherDbRepository) :
    ViewModel() {
    private val _favList = MutableStateFlow<List<Favorite>>(emptyList())
    val favList = _favList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getFavorites().distinctUntilChanged()
                .collect { listOfFav ->
                    if (listOfFav.isEmpty()) {
                        Log.d("TAG", "Empty favs")
                    } else {
                        _favList.value = listOfFav
                        Log.d("TAG", "${favList.value}")
                    }
                }
        }
    }

    fun insertFavorite(favorite: Favorite) = viewModelScope.launch { repository.insertFavorite(favorite ) }

    fun updateFavorite(favorite: Favorite) = viewModelScope.launch { repository.updateFavorite(favorite) }

    fun deleteFavorite(favorite: Favorite) = viewModelScope.launch { repository.deleteFavorite(favorite) }

    fun deleteAllFavorites() = viewModelScope.launch { repository.deleteAllFavorites() }

    fun getFavByCity(city: String) = viewModelScope.launch { repository.getFavoriteByCity(city) }
}