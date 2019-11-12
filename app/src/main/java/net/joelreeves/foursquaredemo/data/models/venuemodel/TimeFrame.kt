package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TimeFrame(
    @SerializedName("days") val days: String,
    @SerializedName("includesToday") val includesToday: Boolean,
    @SerializedName("open") val open: List<Open>,
    @SerializedName("segments") val segments: List<Any>
) : Serializable