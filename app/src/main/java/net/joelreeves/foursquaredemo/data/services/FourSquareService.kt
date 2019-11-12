package net.joelreeves.foursquaredemo.data.services

import io.reactivex.Single
import net.joelreeves.foursquaredemo.data.models.venuelist.VenueListModel
import net.joelreeves.foursquaredemo.data.models.venuemodel.VenueModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FourSquareService {

    @GET("venues/search/")
    fun findVenuesNearLocation(
        @Query("ll") latLng: String,
        @Query("client_id") client_id: String,
        @Query("client_secret") client_secret: String,
        @Query("v") v: String,
        @Query("limit") limit: String
    ): Single<VenueListModel>

    @GET("venues/search/")
    fun findVenuesNearCity(
        @Query("near") near: String,
        @Query("client_id") client_id: String,
        @Query("client_secret") client_secret: String,
        @Query("v") v: String,
        @Query("limit") limit: String
    ): Single<VenueListModel>

    @GET("venues/{venueId}/")
    fun findVenue(
        @Path("venueId") venueId: String,
        @Query("client_id") client_id: String,
        @Query("client_secret") client_secret: String,
        @Query("v") v: String,
        @Query("limit") limit: String
    ): Single<VenueModel>
}
