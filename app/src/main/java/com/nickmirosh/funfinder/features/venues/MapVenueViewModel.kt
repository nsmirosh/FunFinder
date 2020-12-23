package com.nickmirosh.funfinder.features.venues

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.nickmirosh.funfinder.features.venues.domain.Venue

class MapVenueViewModel() : ViewModel() {
    private var foodVenues = ArrayList<Venue>()

    private val mutableVenuesLiveData: MutableLiveData<List<Venue>> = MutableLiveData()
    val venuesLiveData: LiveData<List<Venue>> get() = mutableVenuesLiveData

    fun getRecommendedVenues(latLng: String, radius: Int){

        val venuesList = listOf(
            Venue("1", "someVenue1"),
            Venue("2", "someVenue2"),
            Venue("3", "someVenue3")
        )

        mutableVenuesLiveData.value = venuesList
    }
}
