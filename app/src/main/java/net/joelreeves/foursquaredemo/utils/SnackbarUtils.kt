package net.joelreeves.foursquaredemo.utils

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import net.joelreeves.foursquaredemo.R

class SnackbarUtils {

    companion object {
        fun showSnackBar(context: Context, view: View, stringRes: Int) {
            val snackBar = Snackbar.make(view, stringRes, Snackbar.LENGTH_SHORT)
            snackBar.view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
            snackBar.show()
        }
    }
}