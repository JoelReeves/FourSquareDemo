package net.joelreeves.foursquaredemo.injection.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import net.joelreeves.foursquaredemo.injection.ViewModelFactory
import net.joelreeves.foursquaredemo.injection.ViewModelKey
import net.joelreeves.foursquaredemo.ui.VenueViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(VenueViewModel::class)
    abstract fun bindVenueViewModel(venueViewModel: VenueViewModel): ViewModel
}