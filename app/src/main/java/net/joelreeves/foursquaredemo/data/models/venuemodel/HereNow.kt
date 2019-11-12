package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HereNow(
    @SerializedName("count") val count: Int,
    @SerializedName("summary") val summary: String,
    @SerializedName("groups") val groups: List<Any>
) : Serializable