package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Photo(
    @SerializedName("prefix") val prefix: String,
    @SerializedName("suffix") val suffix: String
) : Serializable