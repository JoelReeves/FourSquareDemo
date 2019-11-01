package net.joelreeves.foursquaredemo.data.models

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("venue") val venue: Venue,
    @SerializedName("tips") val tips: List<Tip>,
    @SerializedName("referralId") val referralId: String
)
