package net.joelreeves.foursquaredemo.data.models.venuelist

import com.google.gson.annotations.SerializedName

data class VenueListModel(
    @SerializedName("meta") val meta: Meta,
    @SerializedName("response") val response: Response
)
