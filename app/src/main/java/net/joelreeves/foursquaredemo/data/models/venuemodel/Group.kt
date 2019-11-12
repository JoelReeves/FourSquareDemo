package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Group(
    @SerializedName("type") val type: String,
    @SerializedName("name") val name: String,
    @SerializedName("count") val count: Int,
    @SerializedName("items") val items: List<Item>
) : Serializable