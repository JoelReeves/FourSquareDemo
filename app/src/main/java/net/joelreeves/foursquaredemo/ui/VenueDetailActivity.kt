package net.joelreeves.foursquaredemo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.joelreeves.foursquaredemo.R
import net.joelreeves.foursquaredemo.core.FourSquareDemoApplication
import net.joelreeves.foursquaredemo.data.models.venuemodel.Venue
import net.joelreeves.foursquaredemo.utils.ImageLoader
import net.joelreeves.foursquaredemo.utils.SnackbarUtils
import net.joelreeves.foursquaredemo.utils.VenueFormatter
import javax.inject.Inject

class VenueDetailActivity : AppCompatActivity() {

    companion object {
        private val TAG = VenueDetailActivity::class.java.simpleName
        private const val ARG_VENUE = "venue"

        fun newIntent(context: Context, venue: Venue): Intent {
            return Intent(context, VenueDetailActivity::class.java).apply {
                putExtra(ARG_VENUE, venue)
            }
        }
    }

    @Inject
    lateinit var imageLoader: ImageLoader

    private val venueImage by lazy { findViewById(R.id.venue_detail_image) as ImageView }
    private val venueDescription by lazy { findViewById(R.id.venue_detail_description) as TextView }
    private val venueAddress by lazy { findViewById(R.id.venue_detail_address) as TextView }
    private val venuePhoneNumber by lazy { findViewById(R.id.venue_detail_phone_number) as TextView }
    private val venueWebsite by lazy { findViewById(R.id.venue_detail_website) as TextView }
    private val formatter by lazy { VenueFormatter }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue_detail)
        FourSquareDemoApplication.instance.component.inject(this)

        val venue = intent.getSerializableExtra(ARG_VENUE) as? Venue
        if (venue == null) {
            venueError()
        } else {
            showVenueDetail(venue)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    private fun showVenueDetail(venue: Venue) {
        supportActionBar?.title = venue.name
        imageLoader.loadImage(formatter.formatVenueImageUrl(venue), venueImage)
        venueDescription.text = venue.description ?: getString(R.string.venue_description_missing)
        venueAddress.text = formatter.formatVenueAddress(venue)
        venuePhoneNumber.text = venue.contact.formattedPhone
        venueWebsite.text = venue.url
    }

    private fun venueError() {
        SnackbarUtils.showSnackBar(this, venueImage, R.string.venue_detail_error)
        finish()
    }
}
