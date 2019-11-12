package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BeenHere(
    @SerializedName("count") val count: Int,
    @SerializedName("unconfirmedCount") val unconfirmedCount: Int,
    @SerializedName("marked") val marked: Boolean,
    @SerializedName("lastCheckinExpiredAt") val lastCheckinExpiredAt: Int
) : Serializable