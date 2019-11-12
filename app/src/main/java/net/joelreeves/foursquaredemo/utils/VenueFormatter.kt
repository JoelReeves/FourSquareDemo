package net.joelreeves.foursquaredemo.utils

import android.content.res.Resources
import android.graphics.Color
import net.joelreeves.foursquaredemo.R
import net.joelreeves.foursquaredemo.data.models.venuemodel.Venue
import java.math.RoundingMode

object VenueFormatter {

    private const val METERS_TO_MILES = 0.000621
    private const val DECIMAL_PLACES = 2
    private const val ORIGINAL_SIZE = "original"

    fun formatMiles(res: Resources, meters: Int): String {
        val miles = meters * METERS_TO_MILES
        val roundedMiles = miles.toBigDecimal().setScale(DECIMAL_PLACES, RoundingMode.UP).toString()
        return res.getString(R.string.venue_distance, roundedMiles)
    }

    fun formatRatingColor(colorString: String?): Int {
        return when (colorString) {
            null -> Color.BLACK
            else -> Color.parseColor("#$colorString")
        }
    }

    fun formatVenueImageUrl(venue: Venue): String {
        val bestPhoto = venue.bestPhoto
        return when (bestPhoto) {
            null -> ""
            else -> {
                val prefix = bestPhoto.prefix
                val suffix = bestPhoto.suffix
                return prefix+ ORIGINAL_SIZE+suffix
            }
        }
    }

    fun formatVenueAddress(venue: Venue): String {
        val venueLocation = venue.location
        val street = venueLocation.address ?: ""
        val city = venueLocation.city ?: ""
        val state = venueLocation.state ?: ""
        val zip = venueLocation.postalCode ?: ""
        return street+"\n"+city+", "+state+" "+zip
    }
}