package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ListedGroupItem(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("type") val type: String,
    @SerializedName("user") val user: User,
    @SerializedName("editable") val editable: Boolean,
    @SerializedName("public") val public: Boolean,
    @SerializedName("collaborative") val collaborative: Boolean,
    @SerializedName("url") val url: String,
    @SerializedName("canonicalUrl") val canonicalUrl: String,
    @SerializedName("createdAt") val createdAt: Int,
    @SerializedName("updatedAt") val updatedAt: Int,
    @SerializedName("followers") val followers: Followers,
    @SerializedName("listItems") val listItems: ListItems
) : Serializable