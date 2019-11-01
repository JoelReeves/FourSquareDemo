package net.joelreeves.foursquaredemo.data.models

import com.google.gson.annotations.SerializedName

data class Tip(
    @SerializedName("createdAt") val createdAt: Int,
    @SerializedName("text") val text: String,
    @SerializedName("type") val type: String,
    @SerializedName("canonicalUrl") val canonicalUrl: String,
    @SerializedName("likes") val likes: Likes,
    @SerializedName("agreeCount") val agreeCount: Int,
    @SerializedName("user") val user: User
)
