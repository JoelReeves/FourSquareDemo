package net.joelreeves.foursquaredemo.injection.components

import dagger.Component
import net.joelreeves.foursquaredemo.injection.modules.AndroidModule
import net.joelreeves.foursquaredemo.injection.modules.NetworkModule
import net.joelreeves.foursquaredemo.injection.modules.ViewModelModule
import net.joelreeves.foursquaredemo.ui.VenueDetailActivity
import net.joelreeves.foursquaredemo.ui.VenuesActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AndroidComponent {
    fun inject(activity: VenuesActivity)
    fun inject(activity: VenueDetailActivity)
}
