package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Price(
    @SerializedName("tier") val tier: Int,
    @SerializedName("message") val message: String,
    @SerializedName("currency") val currency: String
) : Serializable