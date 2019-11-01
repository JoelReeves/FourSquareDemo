package net.joelreeves.foursquaredemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.joelreeves.foursquaredemo.R
import net.joelreeves.foursquaredemo.core.FourSquareDemoApplication

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FourSquareDemoApplication.instance.component.inject(this)
    }
}
