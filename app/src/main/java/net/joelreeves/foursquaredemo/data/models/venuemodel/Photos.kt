package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Photos(
    @SerializedName("count") val count: Int,
    @SerializedName("groups") val items: List<Group>
) : Serializable