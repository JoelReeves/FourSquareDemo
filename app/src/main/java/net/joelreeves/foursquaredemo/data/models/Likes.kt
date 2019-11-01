package net.joelreeves.foursquaredemo.data.models

import com.google.gson.annotations.SerializedName

data class Likes(
    @SerializedName("count") val count: Int,
    @SerializedName("groups") val groups: List<Any>,
    @SerializedName("summary") val summary: String
)
