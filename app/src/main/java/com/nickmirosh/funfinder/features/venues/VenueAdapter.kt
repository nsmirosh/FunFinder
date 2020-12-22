package com.nickmirosh.funfinder.features.venues

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nickmirosh.funfinder.R
import nikolay.miroshnychenko.beat_test_task.data.Venue


class VenueAdapter : RecyclerView.Adapter<VenueAdapter.VenueItemViewHolder>() {
    override fun getItemCount(): Int = venueList.size

    private var venueListClickHandler: VenueListClickHandler? = null
    private var venueList = ArrayList<Venue>()

    fun setData(newVenueList: List<Venue>) {
      /*  val diffCallback = VenuesDiffCallback(venueList, newVenueList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)*/
        venueList.apply {
            clear()
            addAll(newVenueList)
            notifyDataSetChanged()
        }
//        diffResult.dispatchUpdatesTo(this)
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
/*                val parsedVenue = VenueUtils.parseVenue(venueItem)
                parsedVenue.apply {
                    venueNameTextView.text = this.name
                    addressTextView.text = this.address
                    PicassoUtils.insertInto(categoryImageView, primaryCategoryIconPath)
                    categoryNameTextView.text = this.primaryCategoryName
                }

                setOnClickListener {
                    val clickedImage = venueList[adapterPosition]
                    venueListClickHandler?.onVenueClicked(clickedImage)
                }*/
            }
        }
    }

    interface VenueListClickHandler {
        fun onVenueClicked(venue: Venue)
    }
}