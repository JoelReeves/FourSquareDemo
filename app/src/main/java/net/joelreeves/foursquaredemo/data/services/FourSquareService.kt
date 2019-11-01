package net.joelreeves.foursquaredemo.data.services

import retrofit2.http.GET

interface FourSquareService {

    @GET("venues/search?ll=")
    fun findVenues()
}