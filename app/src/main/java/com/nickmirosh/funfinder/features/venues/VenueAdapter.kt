package com.nickmirosh.funfinder.features.venues

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nickmirosh.funfinder.R
import com.nickmirosh.funfinder.features.venues.domain.Venue
import kotlinx.android.synthetic.main.list_venue_item.view.*


class VenueAdapter : RecyclerView.Adapter<VenueAdapter.VenueItemViewHolder>() {
    override fun getItemCount(): Int = venueList.size

    private var venueListClickHandler: VenueListClickHandler? = null
    private var venueList = ArrayList<Venue>()

    fun setData(newVenueList: List<Venue>) {
        venueList.apply {
            clear()
            addAll(newVenueList)
            notifyDataSetChanged()
        }
    }

    fun setVenueListClickHandler(venueListClickHandler: VenueListClickHandler?) {
        this.venueListClickHandler = venueListClickHandler
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_venue_item, parent, false)
        return VenueItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: VenueItemViewHolder, position: Int) {
        val venueItem = venueList[position]
        holder.bindTo(venueItem)
    }

    inner class VenueItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindTo(venueItem: Venue) {
            itemView.apply {
                venueNameTextView.text = venueItem.name
            }
        }
    }
    
    interface VenueListClickHandler {
        fun onVenueClicked(venue: Venue)
    }
}