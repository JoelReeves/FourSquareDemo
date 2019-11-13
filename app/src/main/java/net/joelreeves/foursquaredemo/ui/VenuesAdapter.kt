package net.joelreeves.foursquaredemo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.joelreeves.foursquaredemo.R
import net.joelreeves.foursquaredemo.data.models.venuemodel.Venue
import net.joelreeves.foursquaredemo.utils.VenueFormatter
import net.joelreeves.foursquaredemo.utils.ImageLoader

class VenuesAdapter(
    private val venues: List<Venue>,
    private val imageLoader: ImageLoader,
    private val listener: VenueListener) :
    RecyclerView.Adapter<VenuesAdapter.VenueHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_venue, parent, false)
        return VenueHolder(view, listener)
    }

    override fun onBindViewHolder(holder: VenueHolder, position: Int) {
        holder.bindVenue(venues[position])
    }

    override fun getItemCount(): Int = venues.size

    inner class VenueHolder(view: View, private val listener: VenueListener) :
        RecyclerView.ViewHolder(view) {
        private val venueImage: ImageView = view.findViewById(R.id.venue_image)
        private val venueName: TextView = view.findViewById(R.id.venue_name)
        private val venueDistance: TextView = view.findViewById(R.id.venue_distance)
        private val venueCity: TextView = view.findViewById(R.id.venue_city)
        private val venueRating: TextView = view.findViewById(R.id.venue_rating)

        private val resources by lazy { itemView.resources }
        private val formatter by lazy { VenueFormatter }

        fun bindVenue(venue: Venue) {
            itemView.setOnClickListener {listener.onVenueClick(venue)}
            imageLoader.loadImage(formatter.formatVenueImageUrl(venue), venueImage)
            venueName.text = venue.name
            venueDistance.text = resources.getString(R.string.venue_distance, formatter.formatMiles(venue.distance))
            venueCity.text = venue.location.city
            venueRating.text = venue.rating.toString()
            venueRating.setTextColor(formatter.formatRatingColor(venue.ratingColor))
        }
    }

    interface VenueListener {
        fun onVenueClick(venue: Venue)
    }
}