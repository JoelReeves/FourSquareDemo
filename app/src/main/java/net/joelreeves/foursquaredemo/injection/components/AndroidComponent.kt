package net.joelreeves.foursquaredemo.injection.components

import dagger.Component
import net.joelreeves.foursquaredemo.ui.VenuesActivity
import net.joelreeves.foursquaredemo.injection.modules.AndroidModule
import net.joelreeves.foursquaredemo.injection.modules.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidModule::class,
    NetworkModule::class
])
interface AndroidComponent {
    fun inject(activity: VenuesActivity)
}
