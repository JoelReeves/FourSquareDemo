package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName

data class AttributeGroupItem(
    @SerializedName("displayName") val displayName: String,
    @SerializedName("displayValue") val displayValue: String,
    @SerializedName("priceTier") val priceTier: Int
)