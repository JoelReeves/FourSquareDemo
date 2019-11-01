package net.joelreeves.foursquaredemo.core

import android.app.Application
import net.joelreeves.foursquaredemo.injection.components.AndroidComponent
import net.joelreeves.foursquaredemo.injection.components.DaggerAndroidComponent
import net.joelreeves.foursquaredemo.injection.modules.AndroidModule

class FourSquareDemoApplication : Application() {

    companion object {
        lateinit var instance: FourSquareDemoApplication
            private set
    }

    init {
        instance = this
    }

    lateinit var component: AndroidComponent

    override fun onCreate() {
        super.onCreate()

        component = initDagger(this)
    }

    private fun initDagger(application: Application) : AndroidComponent {
        return DaggerAndroidComponent.builder()
            .androidModule(AndroidModule(application))
            .build()
    }
}
