package net.joelreeves.foursquaredemo.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Icon(
    @SerializedName("prefix") val prefix: String,
    @SerializedName("suffix") val suffix: String
) : Serializable
