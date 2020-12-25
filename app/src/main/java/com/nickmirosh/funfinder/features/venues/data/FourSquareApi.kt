package com.nickmirosh.funfinder.features.venues.data

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FourSquareApi {

    @GET("venues/search")
    fun getVenues(
        @Query("ll") latAndLong: String,
        @Query("categoryId") categoryId: String,
        @Query("radius") radiusToSearchFor: Int)
            : Call<Any>
}