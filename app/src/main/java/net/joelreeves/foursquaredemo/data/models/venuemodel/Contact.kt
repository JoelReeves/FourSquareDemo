package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Contact(
    @SerializedName("phone") val phone: String,
    @SerializedName("formattedPhone") val formattedPhone: String
) : Serializable