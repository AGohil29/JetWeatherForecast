package com.goldmedal.jetweatherforecast.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.goldmedal.jetweatherforecast.model.Favorite

@Database(entities = [Favorite::class], version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}