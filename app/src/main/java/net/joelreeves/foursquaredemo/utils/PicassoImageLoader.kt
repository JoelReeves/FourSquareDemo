package net.joelreeves.foursquaredemo.utils

import android.text.TextUtils
import android.widget.ImageView
import com.squareup.picasso.Picasso
import net.joelreeves.foursquaredemo.R

class PicassoImageLoader : ImageLoader {

    override fun loadImage(imageUrl: String?, imageView: ImageView) {
        if (TextUtils.isEmpty(imageUrl)) {
            Picasso.get()
                .load(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView)
        } else {
            Picasso.get()
                .load(imageUrl)
                .into(imageView)
        }
    }
}