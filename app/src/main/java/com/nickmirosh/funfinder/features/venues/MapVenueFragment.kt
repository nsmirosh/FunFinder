package com.nickmirosh.funfinder.features.venues

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nickmirosh.funfinder.R
import com.nickmirosh.funfinder.features.venues.utils.VerticalSpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_map_venue.*


class MapVenueFragment : Fragment(R.layout.fragment_map_venue) {

    private lateinit var venueListAdapter: VenueAdapter

    val mapVenueViewModel: MapVenueViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val doOnClick: (View) -> Unit = {
            mapVenueViewModel.getRecommendedVenues("fdfs", 2)
        }

        get_venues_button.setOnClickListener(doOnClick)
        initRecyclerView()
        startObservingViewModelEvents()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            venueListAdapter = VenueAdapter()
            addItemDecoration(VerticalSpaceItemDecoration(requireContext()));
            layoutManager = LinearLayoutManager(context)
            adapter = venueListAdapter
        }
    }

    private fun startObservingViewModelEvents() {

        mapVenueViewModel.apply {
            venuesLiveData.observe(viewLifecycleOwner, Observer { venues ->
                venueListAdapter.setData(venues)
            })
        }

    }
}