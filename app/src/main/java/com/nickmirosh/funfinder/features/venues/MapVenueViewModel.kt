package com.nickmirosh.funfinder.features.venues

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import nikolay.miroshnychenko.beat_test_task.data.Venue

class MapVenueViewModel() : ViewModel() {
    private var foodVenues = ArrayList<Venue>()

    private val mutableVenuesLiveData: MutableLiveData<Result<List<Venue>>> = MutableLiveData()
    val venuesLiveData: LiveData<Result<List<Venue>>> get() = mutableVenuesLiveData

    fun getRecommendedVenues(latLng: String, radius: Int) {

    }
}
