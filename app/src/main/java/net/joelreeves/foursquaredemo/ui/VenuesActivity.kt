package net.joelreeves.foursquaredemo.ui

import android.Manifest
import android.app.SearchManager
import android.content.Context
import android.location.Location
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import net.joelreeves.foursquaredemo.R
import net.joelreeves.foursquaredemo.core.FourSquareDemoApplication
import net.joelreeves.foursquaredemo.data.models.venuemodel.Venue
import net.joelreeves.foursquaredemo.utils.ImageLoader
import net.joelreeves.foursquaredemo.utils.NetworkUtils
import net.joelreeves.foursquaredemo.utils.SnackbarUtils
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import javax.inject.Inject

class VenuesActivity : AppCompatActivity(),
    VenuesAdapter.VenueListener,
    SearchView.OnQueryTextListener{

    companion object {
        private val TAG = VenuesActivity::class.java.simpleName
        private const val REQUEST_LOCATION_PERMISSION = 1
    }

    @Inject
    lateinit var venueViewModel: VenueViewModel

    @Inject
    lateinit var imageLoader: ImageLoader

    private var searchMenuItem: MenuItem? = null
    private var usingLocation = false
    private var locationQuery = ""

    private val progressBar by lazy { findViewById(R.id.loading_progress) as ProgressBar }
    private val recyclerView by lazy { findViewById(R.id.venue_recycler_view) as RecyclerView }
    private val fusedLocationClient by lazy { LocationServices.getFusedLocationProviderClient(this) as FusedLocationProviderClient }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue)
        FourSquareDemoApplication.instance.component.inject(this)


        venueViewModel.venuesNearMe.observe(this, Observer(::showVenues))
        venueViewModel.venuesNearCity.observe(this, Observer(::showVenues))
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // Forwarding asking for location permission to library
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)

        // setting up SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchMenuItem = menu?.findItem(R.id.venue_search)
        (searchMenuItem?.actionView as SearchView).apply {
            queryHint = getString(R.string.venue_search_hint)
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            setOnQueryTextListener(this@VenuesActivity)
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextChange(newText: String?) = false

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let { locationQuery = it }
        loadVenuesNearCity(locationQuery)
        searchMenuItem?.collapseActionView()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.venue_location -> {
                checkLocationPermissions()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    @AfterPermissionGranted(REQUEST_LOCATION_PERMISSION)
    private fun checkLocationPermissions() {
        if (!NetworkUtils.networkIsAvailable(this)) {
            SnackbarUtils.showSnackBar(this, recyclerView, R.string.network_error)
        } else {
            val locationPermission = Manifest.permission.ACCESS_COARSE_LOCATION

            // Permissions already granted, obtain device's location
            if (EasyPermissions.hasPermissions(this, locationPermission)) {
                loadVenuesNearLocation()
            } else {
                // Permissions not granted, asking for location permission
                val permissionMessage = getString(R.string.location_permissions_error)
                EasyPermissions.requestPermissions(
                    this, permissionMessage,
                    REQUEST_LOCATION_PERMISSION, locationPermission
                )
            }
        }
    }

    private fun loadVenuesNearLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                // unable to obtain location
                if (location == null) {
                    SnackbarUtils.showSnackBar(this, recyclerView, R.string.location_error)
                } else {
                    // sending location to viewmodel to load venues near current location
                    progressBar.visibility = View.VISIBLE
                    usingLocation = true
                    val latLng = "${location.latitude},${location.longitude}"
                    venueViewModel.loadVenuesNearMe(latLng)
                }
            }
    }

    private fun loadVenuesNearCity(cityString: String?) {
        // invalid city entered
        if (cityString == null || cityString.isEmpty()) {
            SnackbarUtils.showSnackBar(this, recyclerView, R.string.venues_city_error)
        } else {
            // sending location to viewmodel to load venues in/near typed in location
            progressBar.visibility = View.VISIBLE
            usingLocation = false
            venueViewModel.loadVenuesNearCity(cityString)
        }
    }

    private fun showVenues(venues: List<Venue>) {
        progressBar.visibility = View.GONE

        // An error occurred trying to display list of venues
        if (venues.isEmpty()) {
            SnackbarUtils.showSnackBar(this, recyclerView, R.string.venues_error)
        } else {
            // setting actionbar title
            when (usingLocation) {
                true -> supportActionBar?.title = getString(R.string.venues_activity_near_me_label)
                false -> supportActionBar?.title = getString(R.string.venues_activity_near_city_label, locationQuery)
            }
            // populating recyclerview with list of venues
            val venuesAdapter = VenuesAdapter(venues, imageLoader, this)
            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@VenuesActivity)
                addItemDecoration(DividerItemDecoration(this@VenuesActivity, DividerItemDecoration.VERTICAL))
                adapter = venuesAdapter
            }
        }
    }

    override fun onVenueClick(venue: Venue) {
        val intent = VenueDetailActivity.newIntent(this, venue)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}
