package net.joelreeves.foursquaredemo.data.models.venuemodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Hours(
    @SerializedName("status") val status: String,
    @SerializedName("richStatus") val richStatus: RichStatus,
    @SerializedName("isOpen") val isOpen: Boolean,
    @SerializedName("isLocalHoliday") val isLocalHoliday: Boolean,
    @SerializedName("dayData") val dayData: List<Any>,
    @SerializedName("timeFrames") val timeframes: List<TimeFrame>
) : Serializable