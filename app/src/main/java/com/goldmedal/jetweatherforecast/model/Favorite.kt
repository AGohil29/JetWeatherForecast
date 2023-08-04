package com.goldmedal.jetweatherforecast.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

@Entity(tableName = "fav_tbl")
data class Favorite(
    @Nonnull
    @PrimaryKey
    val city: String,
    val country: String
)
