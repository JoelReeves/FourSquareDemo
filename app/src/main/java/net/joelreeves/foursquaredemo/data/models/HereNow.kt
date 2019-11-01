package net.joelreeves.foursquaredemo.data.models

import com.google.gson.annotations.SerializedName

data class HereNow(
    @SerializedName("count") val count: Int,
    @SerializedName("summary") val summary: String
)
