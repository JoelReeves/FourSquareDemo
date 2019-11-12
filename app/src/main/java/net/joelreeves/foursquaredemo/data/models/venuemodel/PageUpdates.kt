package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PageUpdates(
    @SerializedName("count") val count: Int,
    @SerializedName("items") val items: List<Any>
) : Serializable