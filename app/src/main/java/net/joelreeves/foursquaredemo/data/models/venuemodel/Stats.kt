package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Stats(
    @SerializedName("tipCount") val tipCount: Int
) : Serializable