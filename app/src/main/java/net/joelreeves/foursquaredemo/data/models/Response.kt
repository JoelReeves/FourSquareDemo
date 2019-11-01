package net.joelreeves.foursquaredemo.data.models

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("headerLocation") val headerLocation: String,
    @SerializedName("headerFullLocation") val headerFullLocation: String,
    @SerializedName("headerLocationGranularity") val headerLocationGranularity: String,
    @SerializedName("query") val query: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("groups") val groups: List<Group>
)
