package net.joelreeves.foursquaredemo.injection.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.HttpUrl
import java.io.File
import javax.inject.Named
import javax.inject.Singleton
import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.OkHttpClient
import androidx.annotation.NonNull
import net.joelreeves.foursquaredemo.data.services.FourSquareService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
class NetworkModule(private val endPoint: HttpUrl) {

    companion object {
        private const val NETWORK_CACHE = "network_cache"
        private const val KB = 1024L
        private const val CACHE_SIZE = 20 * KB * KB
        private val GLOBAL_TIMEOUT = TimeUnit.SECONDS.toMillis(30)
    }

    @Provides
    @Singleton
    fun provideEndpoint() : HttpUrl = endPoint

    @Provides
    @Singleton
    @Named(NETWORK_CACHE)
    fun provideNetworkCacheDirectory(context: Context) : File {
        return context.getDir(NETWORK_CACHE, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideNetworkCache(@Named(NETWORK_CACHE) cacheDir: File) : Cache {
        return Cache(cacheDir, CACHE_SIZE)
    }

    @Provides
    @Singleton
    fun provideHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(cache)
            .connectTimeout(GLOBAL_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(GLOBAL_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(GLOBAL_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun providePlaces(client: OkHttpClient, url: HttpUrl): FourSquareService {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FourSquareService::class.java)
    }
}
