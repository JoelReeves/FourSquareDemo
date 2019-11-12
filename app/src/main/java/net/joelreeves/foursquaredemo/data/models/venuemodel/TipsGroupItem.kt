package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TipsGroupItem(
    @SerializedName("id") val id: String,
    @SerializedName("createdAt") val createdAt: Int,
    @SerializedName("text") val text: String,
    @SerializedName("type") val type: String,
    @SerializedName("canonicalUrl") val canonicalUrl: String,
    @SerializedName("lang") val lang: String,
    @SerializedName("likes") val likes: Likes,
    @SerializedName("logView") val logView: Boolean,
    @SerializedName("agreeCount") val agreeCount: Int,
    @SerializedName("disagreeCount") val disagreeCount: Int,
    @SerializedName("todo") val todo: Todo,
    @SerializedName("user") val user: User
) : Serializable