package net.joelreeves.foursquaredemo.injection.modules

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import androidx.annotation.NonNull
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import net.joelreeves.foursquaredemo.utils.NetworkUtils
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class AndroidModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun providePicasso(context: Context, client: OkHttpClient): Picasso {
        return Picasso.Builder(context)
            .downloader(OkHttp3Downloader(client))
            .defaultBitmapConfig(Bitmap.Config.ARGB_8888)
            .build()
    }
}
