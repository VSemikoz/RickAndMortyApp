package ru.vssemikoz.rickandmortyapp.utils.imageUtlis

import android.widget.ImageView
import com.squareup.picasso.Picasso
import ru.vssemikoz.rickandmortyapp.MainApplication
import ru.vssemikoz.rickandmortyapp.R

object ImageUtils {
    fun setImageByUrl(url: String, imageView: ImageView) {
        Picasso.with(MainApplication.getInstance()?.applicationContext)
            .load(url)
            .error(R.mipmap.no_image_found)
            .into(imageView)
    }

}
