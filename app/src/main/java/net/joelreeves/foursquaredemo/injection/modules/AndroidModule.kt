package net.joelreeves.foursquaredemo.injection.modules

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import net.joelreeves.foursquaredemo.data.services.FourSquareService
import net.joelreeves.foursquaredemo.data.services.VenueRepository
import net.joelreeves.foursquaredemo.utils.FourSquareImageLoader
import net.joelreeves.foursquaredemo.utils.ImageLoader
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class AndroidModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideVenueRepository(service: FourSquareService): VenueRepository {
        return VenueRepository(service)
    }

    @Provides
    @Singleton
    fun provideImageLoader() : ImageLoader {
        return FourSquareImageLoader()
    }

    @Provides
    @Singleton
    fun providePicasso(context: Context, client: OkHttpClient): Picasso {
        return Picasso.Builder(context)
            .downloader(OkHttp3Downloader(client))
            .defaultBitmapConfig(Bitmap.Config.ARGB_8888)
            .build()
    }
}
