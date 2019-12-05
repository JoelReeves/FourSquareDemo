package net.joelreeves.foursquaredemo.ui

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.*
import io.reactivex.schedulers.Schedulers
import net.joelreeves.foursquaredemo.data.models.venuemodel.Venue
import net.joelreeves.foursquaredemo.data.services.VenueRepository
import javax.inject.Inject

class VenueViewModel @Inject constructor(private val repository: VenueRepository) : ViewModel() {

    companion object {
        private val TAG = VenueViewModel::class.java.simpleName
    }

    @VisibleForTesting val latLng = MutableLiveData<String>()
    @VisibleForTesting val city = MutableLiveData<String>()

    val venuesNearMe: LiveData<List<Venue>> =
        Transformations.switchMap(latLng) {
            LiveDataReactiveStreams.fromPublisher(
                repository.findVenuesNearLocation(it).toObservable()
                    .flatMapIterable { venues -> venues }
                    .flatMap { venue -> repository.findVenueById(venue).toObservable() }
                    .toList()
                    .onErrorReturn { emptyList() }
                    .subscribeOn(Schedulers.io())
                    .toFlowable()
            )
        }

    val venuesNearCity: LiveData<List<Venue>> =
        Transformations.switchMap(city) {
            LiveDataReactiveStreams.fromPublisher(
                repository.findVenuesNearCity(it).toObservable()
                    .flatMapIterable { venues -> venues }
                    .flatMap { venue -> repository.findVenueById(venue).toObservable() }
                    .toList()
                    .onErrorReturn { emptyList() }
                    .subscribeOn(Schedulers.io())
                    .toFlowable()
            )
        }

    fun loadVenuesNearMe(latLngString: String) {
        latLng.value = latLngString
    }

    fun loadVenuesNearCity(cityString: String) {
        city.value = cityString
    }
}