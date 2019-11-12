package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VenueModel(
    @SerializedName("meta") val meta: Meta,
    @SerializedName("response") val response: Response
) : Serializable