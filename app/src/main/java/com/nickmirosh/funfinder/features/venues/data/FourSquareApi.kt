package com.nickmirosh.funfinder.features.venues.data

import com.nickmirosh.funfinder.features.venues.domain.RecommendedVenuesRawResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FourSquareApi {

    @GET("venues/explore")
    fun getRecommendedVenues(
        @Query("ll") latAndLong: String,
        @Query("categoryId") categoryId: String,
        @Query("limit") limit: Int,
        @Query("radius") radiusToSearchFor: Int)
            : Call<RecommendedVenuesRawResponse>
}