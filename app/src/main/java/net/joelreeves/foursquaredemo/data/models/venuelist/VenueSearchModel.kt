package net.joelreeves.foursquaredemo.data.models.venuelist

import com.google.gson.annotations.SerializedName
import net.joelreeves.foursquaredemo.data.models.Category
import java.io.Serializable

data class VenueSearchModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: Location,
    @SerializedName("categories") val categories: List<Category>
) : Serializable
