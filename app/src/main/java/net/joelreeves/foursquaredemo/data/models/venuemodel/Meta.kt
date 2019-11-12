package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Meta(
    @SerializedName("code") val code: Int,
    @SerializedName("requestId") val requestId: String
) : Serializable
