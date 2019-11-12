package net.joelreeves.foursquaredemo.data.services

import io.reactivex.Single
import net.joelreeves.foursquaredemo.data.exceptions.*
import net.joelreeves.foursquaredemo.data.models.venuelist.VenueSearchModel
import net.joelreeves.foursquaredemo.data.models.venuemodel.Venue
import retrofit2.HttpException
import java.text.SimpleDateFormat
import java.util.*

class VenueRepository(val service: FourSquareService) {

    companion object {
        private val TAG = VenueRepository::class.java.simpleName
        private const val CLIENT_ID = "KIOWMNAJN3W4YDR3LHOHRQTB4BDRUFGE4EPHGAZ1VI1AL14U"
        private const val CLIENT_SECRET = "UI4VBJISEV1W3B1TRBJEVUU5YUUIWAQT2VGB3MTFSR35DPYQ"
        private const val VENUE_LIMIT = "50"

        private val dateString: String by lazy {
            val formatter = SimpleDateFormat("yyyyMMdd", Locale.US)
            formatter.format(Date())
        }
    }

    fun findVenuesNearLocation(latLng: String): Single<List<VenueSearchModel>> {
        return service.findVenuesNearLocation(latLng, CLIENT_ID, CLIENT_SECRET, dateString, VENUE_LIMIT)
            .map { response -> response.response.venues }
            .onErrorResumeNext(::venuesError)
    }

    fun findVenuesNearCity(city: String): Single<List<VenueSearchModel>> {
        return service.findVenuesNearCity(city, CLIENT_ID, CLIENT_SECRET, dateString, VENUE_LIMIT)
            .map { response -> response.response.venues }
            .onErrorResumeNext(::venuesError)
    }

    fun findVenueById(model: VenueSearchModel): Single<Venue> {
        return service.findVenue(model.id, CLIENT_ID, CLIENT_SECRET, dateString, VENUE_LIMIT)
            .map { response ->
                val venue = response.response.venue
                venue.distance = model.location.distance
                venue
            }
            .onErrorResumeNext(::venueError)
    }

    private fun venuesError(error: Throwable): Single<List<VenueSearchModel>> {
        if (error is HttpException) {
            when (error.code()) {
                400 -> return Single.error(VenueParamException())
                401 -> return Single.error(VenueAuthException())
                403 -> return Single.error(VenueUnauthorizedException())
                404 -> return Single.error(VenueEndpointException())
                500 -> return Single.error(VenueServerException())
            }
        }
        return Single.error(error)
    }

    private fun venueError(error: Throwable): Single<Venue> {
        return Single.error(error)
    }
}