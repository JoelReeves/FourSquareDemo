package net.joelreeves.foursquaredemo.data.models

import com.google.gson.annotations.SerializedName
import net.joelreeves.foursquaredemo.data.models.Icon
import java.io.Serializable

data class Category(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("pluralName") val pluralName: String,
    @SerializedName("shortName") val shortName: String,
    @SerializedName("icon") val icon: Icon,
    @SerializedName("primary") val primary: Boolean
) : Serializable
