package net.joelreeves.foursquaredemo.data.models

import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: Location,
    @SerializedName("categories") val categories: List<Category>,
    @SerializedName("url") val url: String,
    @SerializedName("price") val price: Price,
    @SerializedName("rating") val rating: Float,
    @SerializedName("hours") val hours: Hours,
    @SerializedName("hereNow") val hereNow: HereNow
)
