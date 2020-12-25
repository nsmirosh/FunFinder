package com.nickmirosh.funfinder.features.venues.data.datasource

import com.nickmirosh.funfinder.features.venues.domain.Venue
import retrofit2.Call

interface FourSquareDataSource {
    fun getRecommendedVenues(latLng : String, radius: Int) : Call<Any>
}