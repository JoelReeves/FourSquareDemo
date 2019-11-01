package net.joelreeves.foursquaredemo.ui

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.floatingactionbutton.FloatingActionButton
import net.joelreeves.foursquaredemo.R
import net.joelreeves.foursquaredemo.core.FourSquareDemoApplication
import net.joelreeves.foursquaredemo.data.VenueViewModel
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions

class VenuesActivity : AppCompatActivity() {

    companion object {
        private val TAG = VenuesActivity::class.java.simpleName
        private const val REQUEST_LOCATION_PERMISSION = 1
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var fabLocation: FloatingActionButton
    private lateinit var recyclerView: RecyclerView

    private val venueViewModel: VenueViewModel by lazy {
        ViewModelProviders.of(this).get(VenueViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FourSquareDemoApplication.instance.component.inject(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        fabLocation = findViewById(R.id.location_fab)
        fabLocation.setOnClickListener { checkLocationPermissions() }

        recyclerView = findViewById(R.id.venue_recycler_view)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
//            R.id.menu_location -> {
//                checkLocationPermissions()
//                true
//            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    @AfterPermissionGranted(REQUEST_LOCATION_PERMISSION)
    private fun checkLocationPermissions() {
        val locationPermission = ACCESS_COARSE_LOCATION

        // Permissions already granted
        if (EasyPermissions.hasPermissions(this, locationPermission)) {
            obtainLocation()
        } else {
            val permissionMessage = getString(R.string.location_error)
            EasyPermissions.requestPermissions(this, permissionMessage,
                REQUEST_LOCATION_PERMISSION, locationPermission)
        }
    }


    private fun obtainLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                location?.let {
                    Log.d(TAG, "Latitude: ${location.latitude}")
                    Log.d(TAG, "Longitude: ${location.longitude}")

                    val message = "Latitude: ${location.latitude}, Longitude: ${location.longitude}"
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { error ->
                Log.d(TAG, "Error retrieving location: ${error.localizedMessage}")
            }
    }
}
