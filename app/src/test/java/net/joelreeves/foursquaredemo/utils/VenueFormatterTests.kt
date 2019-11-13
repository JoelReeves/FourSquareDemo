package net.joelreeves.foursquaredemo.utils

import android.graphics.Color
import net.joelreeves.foursquaredemo.VenueTestUtils
import net.joelreeves.foursquaredemo.data.models.venuemodel.Venue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
class VenueFormatterTests {

    private lateinit var formatter: VenueFormatter

    @Before
    fun setup() {
        formatter = VenueFormatter
    }

    @Test
    fun formatMilesReturnsCorrectDistance() {
        val meters = 5000
        val expectedMiles = "3.11"
        val actualMiles = formatter.formatMiles(meters)

        assertEquals(expectedMiles, actualMiles)
    }

    @Test
    fun invalidColorStringReturnsBlack() {
        val expectedColorString = Color.BLACK
        val actualColor = formatter.formatRatingColor(null)

        assertEquals(expectedColorString, actualColor)
    }

    @Test
    fun validColorStringReturnsCorrectColor() {
        val colorString = "FFFF0000"
        val expectedColorString = Color.RED
        val actualColor = formatter.formatRatingColor(colorString)

        assertEquals(expectedColorString, actualColor)
    }

    @Test
    fun invalidVenueImageUrlReturnsEmptyString() {
        val venue = mock(Venue::class.java)
        val expectedUrl = ""
        val actualUrl = formatter.formatVenueImageUrl(venue)

        assertEquals(expectedUrl, actualUrl)
    }

    @Test
    fun validVenueImageUrlReturnsCorrectUrl() {
        val venue = VenueTestUtils.getVenue()
        val expectedUrl = "https://www.fi.edu/ben/original.png"
        val actualUrl = formatter.formatVenueImageUrl(venue)

        assertEquals(expectedUrl, actualUrl)
    }

    @Test
    fun formatVenueAddressReturnsCorrectString() {
        val venue = VenueTestUtils.getVenue()
        val expectedAddress = "222 North 20th Street"+"\n"+"Philadelphia, PA 19103"
        val actualAddress = formatter.formatVenueAddress(venue)

        assertEquals(expectedAddress, actualAddress)
    }
}