package com.nickmirosh.funfinder.features.venues.data.datasource

import com.nickmirosh.funfinder.features.venues.domain.VenueAndReasons

interface IVenuesDataSource {
    suspend fun getRecommendedVenues(latLng: String, radius: Int): List<VenueAndReasons>

}