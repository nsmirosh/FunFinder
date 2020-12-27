package com.nickmirosh.funfinder.features.venues.domain


data class RecommendedVenuesResponse(
    val type: String,
    val name: String,
    val items: List<VenueReasonGroup>
)
