package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Attributes(
    @SerializedName("groups") val groups: List<Group>
) : Serializable