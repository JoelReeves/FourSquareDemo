package net.joelreeves.foursquaredemo.data.models.venuelist

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("venues") val venues: List<VenueSearchModel>,
    @SerializedName("confident") val confident: Boolean
)
