package net.joelreeves.foursquaredemo.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class VenuesAdapter() : RecyclerView.Adapter<VenuesAdapter.VenueHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueHolder {
    }

    override fun onBindViewHolder(holder: VenueHolder, position: Int) {
    }

    override fun getItemCount(): Int {
    }


    inner class VenueHolder(view: View, private val listener: VenueListener) : RecyclerView.ViewHolder(view) {

    }

    interface VenueListener {
        fun onVenueClick()
    }
}