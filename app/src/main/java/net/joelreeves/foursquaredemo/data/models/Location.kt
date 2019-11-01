package net.joelreeves.foursquaredemo.data.models

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("address") val address: String,
    @SerializedName("crossStreet") val crossStreet: String,
    @SerializedName("lat") val lat: Float,
    @SerializedName("lng") val lng: Float,
    @SerializedName("distance") val distance: Int,
    @SerializedName("postalCode") val postalCode: String,
    @SerializedName("cc") val cc: String,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("country") val country: String,
    @SerializedName("formattedAddress") val formattedAddress: List<String>
)
