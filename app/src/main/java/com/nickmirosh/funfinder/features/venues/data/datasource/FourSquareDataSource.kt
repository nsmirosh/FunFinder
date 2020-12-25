package com.nickmirosh.funfinder.features.venues.data.datasource

import com.nickmirosh.funfinder.features.venues.domain.Venue

interface FourSquareDataSource {
    fun getRecommendedVenues(latLng : String, radius: Int) : List<Venue>
}