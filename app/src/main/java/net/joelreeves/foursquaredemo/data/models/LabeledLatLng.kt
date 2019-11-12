package net.joelreeves.foursquaredemo.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LabeledLatLng(
    @SerializedName("label") val label: String,
    @SerializedName("lat") val lat: Float,
    @SerializedName("lng") val lng: Float
) : Serializable