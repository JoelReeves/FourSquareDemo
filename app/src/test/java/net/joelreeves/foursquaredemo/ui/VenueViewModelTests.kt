// mockito references are showing invalid IncorrectScope errors
@file:Suppress("IncorrectScope")

package net.joelreeves.foursquaredemo.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Single
import net.joelreeves.foursquaredemo.VenueTestUtils
import net.joelreeves.foursquaredemo.data.services.VenueRepository
import net.joelreeves.foursquaredemo.test
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.RETURNS_DEEP_STUBS
import org.mockito.Mockito.mock
import com.nhaarman.mockitokotlin2.check as checkArg

class VenueViewModelTests {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private val venueRepository = mock(VenueRepository::class.java, RETURNS_DEEP_STUBS)

    @Before
    fun setUp() {
        val venueSearchModelList = VenueTestUtils.getVenueSearchModels()
        whenever(venueRepository.findVenuesNearLocation(anyString())).doReturn(Single.just(venueSearchModelList))
        whenever(venueRepository.findVenuesNearCity(anyString())).doReturn(Single.just(venueSearchModelList))
        whenever(venueRepository.findVenueById(VenueTestUtils.getVenueSearchModel())).doReturn(Single.just(VenueTestUtils.getVenue()))
    }

    @Test
    fun `When location is not set, nothing is observed`() {
        val viewModel = VenueViewModel(venueRepository)
        val locationObserver = viewModel.city.test()

        verifyZeroInteractions(locationObserver)
    }

    @Test
    fun `When location is passed to viewmodel, latLng observable is set`() {
        val latLng = "37.98,79.50"
        val viewModel = VenueViewModel(venueRepository)
        val locationObserver = viewModel.latLng.test()

        viewModel.loadVenuesNearMe(latLng)

        verify(locationObserver).onChanged(checkArg{
            assertThat(it).isEqualTo(latLng)
        })
    }

    @Test
    fun `When city is passed to viewmodel, city observable is set`() {
        val city = "philadelphia"
        val viewModel = VenueViewModel(venueRepository)
        val locationObserver = viewModel.city.test()

        viewModel.loadVenuesNearCity(city)

        verify(locationObserver).onChanged(checkArg{
            assertThat(it).isEqualTo(city)
        })
    }
}
