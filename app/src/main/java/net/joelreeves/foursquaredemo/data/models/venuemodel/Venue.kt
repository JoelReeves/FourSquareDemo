package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import net.joelreeves.foursquaredemo.data.models.Category
import java.io.Serializable

data class Venue(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("contact") val contact: Contact,
    @SerializedName("location") val location: Location,
    @SerializedName("canonicalUrl") val canonicalUrl: String,
    @SerializedName("categories") val categories: List<Category>,
    @SerializedName("verified") val verified: Boolean,
    @SerializedName("stats") val stats: Stats,
    @SerializedName("url") val url: String,
    @SerializedName("price") val price: Price,
    @SerializedName("likes") val likes: Likes,
    @SerializedName("dislike") val dislike: Boolean,
    @SerializedName("ok") val ok: Boolean,
    @SerializedName("rating") val rating: Float,
    @SerializedName("ratingColor") val ratingColor: String,
    @SerializedName("ratingSignals") val ratingSignals: Int,
    @SerializedName("allowMenuUrlEdit") val allowMenuUrlEdit: Boolean,
    @SerializedName("beenHere") val beenHere: BeenHere,
    @SerializedName("specials") val specials: Specials,
    @SerializedName("photos") val photos: Photos,
    @SerializedName("reasons") val reasons: Reasons,
    @SerializedName("description") val description: String,
    @SerializedName("hereNow") val hereNow: HereNow,
    @SerializedName("createdAt") val createdAt: Int,
    @SerializedName("tips") val tips: Tips,
    @SerializedName("shortUrl") val shortUrl: String,
    @SerializedName("timeZone") val timeZone: String,
    @SerializedName("listed") val listed: Listed,
    @SerializedName("hours") val hours: Hours,
    @SerializedName("pageUpdates") val pageUpdates: PageUpdates,
    @SerializedName("inbox") val inbox: Inbox,
    @SerializedName("attributes") val attributes: Attributes,
    @SerializedName("bestPhoto") val bestPhoto: BestPhoto?,
    var distance: Int
) : Serializable