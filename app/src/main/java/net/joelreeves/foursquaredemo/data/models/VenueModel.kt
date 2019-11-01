package net.joelreeves.foursquaredemo.data.models

import com.google.gson.annotations.SerializedName

data class VenueModel(
    @SerializedName("meta") val meta: Meta,
    @SerializedName("response") val response: Response
)
