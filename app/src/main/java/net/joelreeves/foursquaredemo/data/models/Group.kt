package net.joelreeves.foursquaredemo.data.models

import com.google.gson.annotations.SerializedName

data class Group(
    @SerializedName("items") val items: List<Item>
)
