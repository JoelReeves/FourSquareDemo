package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Listed(
    @SerializedName("count") val count: Int,
    @SerializedName("groups") val groups: List<Group>
) : Serializable